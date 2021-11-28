package com.bluecc.income.dummy.store;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.stub.ShipmentData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.exchange.MessageMapCollector;
import com.bluecc.income.procs.Shipments.*;
import com.bluecc.income.template.TemplateGlobalContext;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.SqlLogger;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.TimestampedConfig;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.junit.Before;
import org.junit.Test;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.Util.pretty;
import static com.bluecc.income.exchange.MessageMapCollector.collect;
import static com.bluecc.income.exchange.ResourceHelper.readResource;
import static com.bluecc.income.procs.AbstractProcs.getPk;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ShipmentsTest extends AbstractStoreProcTest {
    @RegisterBeanMapper(Shipment.class)
    public interface ShipmentDao {
        @SqlQuery("select * from shipment")
        List<Shipment> listShipment();

        @SqlQuery("select * from shipment where shipment_id=:id")
        Shipment getShipment(@Bind("id") String id);

        @RegisterBeanMapper(PostalAddress.class)
        @SqlQuery("select * from postal_address where contact_mech_id = " +
                "(select origin_contact_mech_id from shipment " +
                "where shipment_id=:id)")
        PostalAddress getShipmentOriginContactMech(@Bind("id") String id);
    }

    private static final ZoneOffset GMT_PLUS_2 = ZoneOffset.ofHours(2);

    @Before
    public void setUp() throws Exception {
        final Jdbi db = hubsStore.getJdbi();
        db.getConfig(TimestampedConfig.class).setTimezone(GMT_PLUS_2);
        db.setSqlLogger(new SqlLogger() {
            @Override
            public void logBeforeExecution(StatementContext ctx) {
                System.out.println("sql -> " + ctx.getRawSql());
                System.out.println("\t" + ctx.getParsedSql().getSql());
            }
        });

        TemplateGlobalContext.getContext().preload("Shipment", "PostalAddress");
    }

    @Test
    public void testCompoundShipment() {
        process(ctx -> {
            ShipmentDao dao = ctx.getHandle().attach(ShipmentDao.class);

            Map<String, MessageMapCollector.ResultData> resultMap = collect((c, e) -> {
                System.out.println("Ⓜ️ " + c.getSymbol() + " -> " + e);

                String idval = sequence.nextStringId();
                e.put(getPk(c.getSymbol()), idval);

                // 将子实体的id作为关联字段保存
                c.getCollector().getResultContext().forEach((k, v) -> {
                    e.put(v.getRelatedFields().get(0), v.getChildId());
                });

                List<String> names = new ArrayList<>(e.keySet());
                List<String> placers = names.stream().map(name -> ":" + name)
                        .collect(Collectors.toList());

                int total = ctx.getHandle().createUpdate("insert into <table> (<columns>) values (<placers>)")
                        .define("table", c.getSymbol().getTable())
                        .defineList("columns", names)
                        .defineList("placers", placers)
                        .bindMap(e)
                        .execute();
                assertEquals(1, total);

                if (c.getParentFld() != null) {
                    String entityType = ProtoTypes.getEntityTypeByMessage(c.getParentMsg());
                    EntityMeta.RelationQueryMeta queryMeta = protoMeta.findRelationQueryMeta(
                            entityType, c.getParentFld().getName());
                    System.out.format("\tresult to: %s -> %s\n",
                            c.getParentFld().getName(),
                            queryMeta.getTableFields());
                    c.getCollector().putResult(c.getParentFld().getName(),
                            queryMeta.getTableFields(), idval);
                } else {
                    c.getCollector().putResult("_id_",
                            c.getSymbol().getTableKeys(), idval);
                }

            }).fillMap(readResource("shipment_simple",
                    ShipmentData.newBuilder())
                    .build());
            resultMap.forEach((k, v) -> {
                System.out.println(k + ": " + v);
            });

            String shipmentId = resultMap.get("_id_").getChildId();
            Shipment shipment = dao.getShipment(shipmentId);
            pretty(shipment);
            PostalAddress postalAddress = dao.getShipmentOriginContactMech(shipmentId);
            assertNotNull(postalAddress);
            pretty(postalAddress);
            assertEquals(postalAddress.getContactMechId(),
                    resultMap.get("origin_postal_address").getChildId());
        });
    }

}

