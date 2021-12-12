package com.bluecc.income.dao;

import com.bluecc.hubs.feed.DataFill;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.SqlMeta;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.dummy.store.ContactBean;
import com.bluecc.income.dummy.store.PhoneBean;
import com.bluecc.income.model.Party;
import com.bluecc.income.model.PartyContactMech;
import com.bluecc.income.model.Person;
import com.github.javafaker.Faker;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
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
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.SeedReader.collectEntityData;
import static com.bluecc.hubs.fund.Util.pretty;
import static com.bluecc.hubs.fund.Util.prettyFull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PartyDelegator.PARTY_CONTACT_MECH);
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
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PartyDelegator.PARTY_CONTACT_MECH);
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
        default Map<String, Party> getPartyListWithContactMech(ProtoMeta protoMeta) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Party");
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PartyDelegator.PARTY_CONTACT_MECH);
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
            Map<String, Party> ds = dao.getPartyListWithContactMech(protoMeta);
            System.out.println(ds.keySet());
            ds.values().stream()
                    .filter(e -> !e.getRelPartyContactMech().isEmpty())
                    .forEach(p -> {
                        pretty(p);
                        pretty(p.getRelPartyContactMech());
                    });
        });
    }
}
