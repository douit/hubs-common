package com.bluecc.income.dao;

import com.bluecc.hubs.feed.DataFill;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.SqlMeta;
import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.hubs.stub.PartyData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.model.Party;
import com.bluecc.income.model.PartyContactMech;
import com.bluecc.income.model.Person;
import com.github.javafaker.Faker;
import com.google.common.collect.*;
import com.google.gson.JsonObject;
import com.google.protobuf.Message;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.generic.GenericType;
import org.jdbi.v3.core.mapper.JoinRow;
import org.jdbi.v3.core.mapper.JoinRowMapper;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import org.jdbi.v3.sqlobject.SqlObject;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.SeedReader.collectEntityData;
import static com.bluecc.hubs.fund.Util.pretty;
import static com.bluecc.hubs.fund.Util.prettyFull;
import static com.bluecc.income.dao.PartyDelegator.PARTY_CONTACT_MECH;
import static com.bluecc.income.dao.PartyDelegator.PERSON;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PartyDelegatorTest extends AbstractStoreProcTest {
    @Inject
    PartyDelegator partyDelegator;

    @Before
    public void setUp() throws Exception {
        // setupEntities("Party");
        setupEntities();
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId = sequence.nextStringId();
            PartyFlatData flatData = PartyFlatData.newBuilder()
                    .setPartyId(newId)
                    .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, partyDelegator.create(ctx, flatData));
            assertEquals(1, partyDelegator.update(ctx, flatData));
            assertEquals(1, partyDelegator.find(ctx, flatData).size());
            assertEquals(1, partyDelegator.findById(ctx, flatData).size());
            assertEquals(1, partyDelegator.delete(ctx, flatData));
            assertEquals(0, partyDelegator.find(ctx, flatData).size());
        });
    }


    @Test
    public void storeProtoData() {

        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, sourceSalesOrder, false);

        assertTrue(dataList.get("Party").size() > 0);

        DataFill dataFill = new DataFill();
        Multimap<String, Message> dataMap = dataFill.setupData(dataList);

        dataMap.get("Party").forEach(e -> System.out.println(e));

        process(c -> {
            dataMap.get("Party").forEach(e -> {
                System.out.println(e);
                genericProcs.storeOrUpdate(c, e);
            });

            dataMap.asMap().forEach((k, v) -> {
                v.forEach(e -> {
                    System.out.println(e);
                    genericProcs.storeOrUpdate(c, e);
                });
            });

            // list

        });
    }


    @Test
    public void testBeanToMessage() {
        process(c -> {
            String id = sequence.nextStringId();
            LocalDate date = LocalDate.of(2001, 2, 1);

            Person data = Person.builder()
                    .partyId(id)
                    .lastName("samlet")
                    .firstName("wu")
                    .birthDate(date)
                    .passportExpireDate(LocalDate.now())
                    .gender('Y')
                    .build();
            genericProcs.create(c, data.toData());

            // for (Person person : dao.listPersons()) {
            //     pretty(person);
            //     PersonFlatData flat=person.toFlatData();
            //     System.out.println("-> flat = "+flat);
            // }
        });
    }

    @Test
    public void testJoinRow() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            Handle handle = c.getHandle();

            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party");
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_CONTACT_MECH);
            System.out.println(view.getSql());

            handle.registerRowMapper(BeanMapper.factory(Party.class, view.getLeftPrefix()));
            handle.registerRowMapper(BeanMapper.factory(PartyContactMech.class, view.getRightPrefix()));
            handle.registerRowMapper(JoinRowMapper.forTypes(Party.class,
                    PartyContactMech.class));

            List<JoinRow> contacts = c.getHandle().select(view.getSql())
                    .mapTo(JoinRow.class)
                    .list();
            contacts.stream().map(jo -> jo.get(Party.class))
                    .forEach(p -> System.out.println(p.getPartyId()));
            Party party = contacts.get(0).get(Party.class);
            pretty(party);

            // multimap
            Multimap<Party, PartyContactMech> contactMaps = c.getHandle()
                    .select(view.getSql())
                    .collectInto(new GenericType<Multimap<Party, PartyContactMech>>() {
                    });

            // System.out.println(contactMaps);
            // contactMaps.keySet().forEach(k -> System.out.println(k.getPartyId()));
            contactMaps.asMap().forEach((k, v) -> {
                System.out.println(k.getPartyId() + ": " + v.stream()
                        .map(pc -> pc.getContactMechId())
                        .collect(Collectors.joining(", ")));
            });

            //
            // partyDelegator.findOne()
            Party one = partyDelegator.get(c, "admin");
            assertEquals("admin", one.getPartyId());
        });
    }

    private interface PrivatePartyDao extends SqlObject {

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyContactMech.class, prefix = "pcm")
        default Optional<Party> getPartyWithContactMech(ProtoMeta protoMeta, String id) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party");
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_CONTACT_MECH);
            return getHandle().select(view.getSql()
                            + "where pa.party_id = :id "
                            + "order by pa.party_id")
                    .bind("id", id)
                    .reduceRows(Optional.empty(),
                            (acc, rv) -> {
                                Party a = acc.orElseGet(() -> rv.getRow(Party.class));

                                if (rv.getColumn("pcm_party_id", String.class) != null) {
                                    a.getRelPartyContactMech().add(rv.getRow(PartyContactMech.class));
                                }

                                return Optional.of(a);
                            });
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyContactMech.class, prefix = "pcm")
        default Map<String, Party> getPartyListWithContactMech(ProtoMeta protoMeta, boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_CONTACT_MECH);
            return getHandle().select(view.getSql())
                    .reduceRows(new HashMap<>(), (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pcm_party_id", String.class) != null) {
                            p.getRelPartyContactMech()
                                    .add(rr.getRow(PartyContactMech.class));
                        }
                        return map;
                    });
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyContactMech.class, prefix = "pcm")
        default Map<String, Party> chainContactMech(ProtoMeta protoMeta,
                                                    Map<String, Party> inMap,
                                                    boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_CONTACT_MECH);
            return getHandle().select(view.getSql())
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pcm_party_id", String.class) != null) {
                            p.getRelPartyContactMech()
                                    .add(rr.getRow(PartyContactMech.class));
                        }
                        return map;
                    });
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        default Map<String, Party> chainPerson(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               boolean succInvoke) {
            return chainPerson(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        default Map<String, Party> chainPerson(ProtoMeta protoMeta,
                                               Map<String, Party> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PartyDelegator.PERSON);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Party p = map.computeIfAbsent(rr.getColumn("pa_party_id", String.class),
                                id -> rr.getRow(Party.class));
                        if (rr.getColumn("pe_party_id", String.class) != null) {
                            p.getRelPerson()
                                    .add(rr.getRow(Person.class));
                        }
                        return map;
                    });
        }
    }

    Consumer<Map<String, Party>> contactMech(PrivatePartyDao dao, boolean succ) {
        return e -> dao.chainContactMech(protoMeta, e, succ);
    }

    Consumer<Map<String, Party>> person(PrivatePartyDao dao, boolean succ) {
        return e -> dao.chainPerson(protoMeta, e, succ);
    }

    Consumer<Map<String, Party>> person(PrivatePartyDao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPerson(protoMeta, e, whereClause, binds, succ);
    }

    Consumer<Map<String, Party>> printParties(String key) {
        return e -> {

            assertNotNull(e.get(key));
            assertThat(e.get(key).getRelPerson())
                    .hasSize(1)
                    .allMatch(p -> p.getPartyId().equals(key));
            assertThat(e.get(key).getRelPartyContactMech())
                    .hasAtLeastOneElementOfType(PartyContactMech.class)
                    .allMatch(p -> p.getPartyId().equals(key));
            pretty(e.get(key));
            pretty(e.get(key).getRelPartyContactMech());
            pretty(e.get(key).getRelPerson());

            System.out.println("total: " + e.size());
        };
    }

    Consumer<Map<String, Party>> convertParties(String key) {
        return e -> {
            assertNotNull(e.get(key));
        };
    }

    // @Test
    // public void testConsumerAsVar(){
    //     Consumer<Map<String, Party>> fn=printParties("DemoCustomer");
    // }

    @Test
    public void testChainInvoke() {
        process(c -> {
            PrivatePartyDao dao = c.getHandle().attach(PrivatePartyDao.class);
            contactMech(dao, false)
                    .andThen(person(dao, true))
                    .andThen(printParties("DemoCustomer"))
                    .accept(new HashMap<>());
        });
    }

    @Test
    public void testChainInvokeWithDao() {
        process(c -> {
            PartyDelegator.Dao dao = c.getHandle().attach(PartyDelegator.Dao.class);
            partyDelegator.partyContactMech(dao, false)
                    .andThen(partyDelegator.person(dao, true))
                    .andThen(printParties("DemoCustomer"))
                    .accept(new HashMap<>());
        });
    }

    @Test
    public void testChainInvokeAndConvert() {
        process(c -> {
            PartyDelegator.Dao dao = c.getHandle().attach(PartyDelegator.Dao.class);
            Map<String, Party> dataMap=Maps.newHashMap();

            // partyDelegator.partyContactMech(dao, false)
            //         .andThen(partyDelegator.person(dao, true))
            //         .andThen(printParties("DemoCustomer"))
            //         .accept(dataMap);

            Set<String> incls= Sets.newHashSet(
                    PARTY_CONTACT_MECH,
                    PERSON);

            // chain-queries
            Consumer<Map<String, Party>> chain=partyDelegator.person(dao, false);
            if(incls.contains(PARTY_CONTACT_MECH)){
                chain=chain.andThen(partyDelegator.partyContactMech(dao, true));
            }
            chain.accept(dataMap);

            System.out.println(dataMap.keySet());

            // convert (在这个阶段可以根据权限来确定要返回的关联数据和字段,
            // 选在这个阶段的好处是可以为所有用户只缓存一份数据)
            List<PartyData> partyDataList = dataMap.values().stream().map(data -> {
                PartyData.Builder partyData = data.toHeadBuilder();
                data.getRelPerson().forEach(e -> partyData.setPerson(e.toHeadBuilder()));
                data.getRelPartyContactMech().forEach(e -> partyData.addPartyContactMech(e.toDataBuilder()));
                return partyData.build();
            }).collect(Collectors.toList());

            partyDataList.forEach(e -> System.out.println(e));
        });
    }


    Consumer<Map<String, Party>> checkParties(String key, int n) {
        return e -> {
            assertEquals(n, e.size());
            assertNotNull(e.get(key));
            assertThat(e.get(key).getRelPerson())
                    .hasSize(1)
                    .allMatch(p -> p.getPartyId().equals(key));
            pretty(e.get(key));
            pretty(e.get(key).getRelPerson());

            for (Party p : e.values()) {
                System.out.println(p);
            }
            System.out.println("total: " + e.size());
        };
    }


    @Test
    public void testChainInvokeWithCondition() {
        process(c -> {
            PrivatePartyDao dao = c.getHandle().attach(PrivatePartyDao.class);
            person(dao, "where pe.last_name=:name and pa.status_id=:status",
                    ImmutableMap.of("name", "Customer",
                            "status", "PARTY_ENABLED"),
                    false)
                    .andThen(checkParties("DemoCustomer", 3))
                    .accept(new HashMap<>());
        });
    }

    @Test
    public void testChainInvokeWithConditionAndDao() {
        process(c -> {
            PartyDelegator.Dao dao = c.getHandle().attach(PartyDelegator.Dao.class);
            partyDelegator.person(dao, "where pe.last_name=:name" +
                                    " and pa.status_id=:status",
                    ImmutableMap.of("name", "Customer",
                            "status", "PARTY_ENABLED"),
                    false)
                    .andThen(checkParties("DemoCustomer", 3))
                    .accept(new HashMap<>());
        });
    }

    @Test
    public void testCompletableFuture() throws ExecutionException, InterruptedException {
        // CompletableFuture
        CompletableFuture<List<IModel<?>>> result = process(c -> {
            PrivatePartyDao dao = c.getHandle().attach(PrivatePartyDao.class);
            contactMech(dao, false)
                    .andThen(person(dao, true))
                    .andThen(e -> e.values().forEach(v -> c.getSubscriber().onNext(v)))
                    .accept(new HashMap<>());
            c.getSubscriber().onComplete();
        }).collectList().toFuture();
        System.out.println(result.get().size());
        assertThat(result.get()).hasOnlyElementsOfType(Party.class);
    }

    @Test
    public void testQueryReduce() {
        process(c -> {
            PrivatePartyDao dao = c.getHandle().attach(PrivatePartyDao.class);
            Optional<Party> rec = dao.getPartyWithContactMech(protoMeta, "DemoCustomer");
            assertTrue(rec.isPresent());
            prettyFull(rec.get());
            pretty(rec.get().getRelPartyContactMech());
        });
    }

    @Test
    public void testQueryReduceMap() {
        process(c -> {
            PrivatePartyDao dao = c.getHandle().attach(PrivatePartyDao.class);
            Map<String, Party> ds = dao.getPartyListWithContactMech(protoMeta, false);
            System.out.println(ds.keySet());
            ds.values().stream()
                    .filter(e -> !e.getRelPartyContactMech().isEmpty())
                    .forEach(p -> {
                        pretty(p);
                        pretty(p.getRelPartyContactMech());
                    });

            // ..
            ds = dao.getPartyListWithContactMech(protoMeta, true);
            System.out.println(ds.keySet());
            ds.values().stream()
                    .filter(e -> !e.getRelPartyContactMech().isEmpty())
                    .forEach(p -> {
                        System.out.println("---------");
                        pretty(p);
                        // pretty(p.getRelPartyContactMech());
                        assertNotNull(p.getPartyId());
                        assertNull(p.getPartyTypeId());
                        assertFalse(p.getRelPartyContactMech().isEmpty());
                    });
        });
    }
}
