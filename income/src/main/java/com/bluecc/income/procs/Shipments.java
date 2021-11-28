package com.bluecc.income.procs;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.hubs.stub.ShipmentData;
import com.bluecc.income.exchange.MessageMapCollector;
import com.bluecc.income.template.TemplateGlobalContext;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.SqlLogger;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.TimestampedConfig;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.io.Serializable;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;

import static com.bluecc.hubs.fund.Util.pretty;
import static com.bluecc.income.dummy.store.StoreModule.startup;
import static com.bluecc.income.exchange.ResourceHelper.readResource;

public class Shipments extends AbstractProcs{
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent=false;
    }

    public static void main(String[] args) {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        Shipments shipments=startup(Shipments.class);
        shipments.init(opts);
        shipments.crudSample();
    }

    void crudSample(){
        process(ctx -> {
            ShipmentDao dao = ctx.getHandle().attach(ShipmentDao.class);
            Map<String, MessageMapCollector.ResultData> resultMap=
                    storeCompoundObject(ctx, readResource("shipment_simple",
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



    private static final ZoneOffset GMT_PLUS_2 = ZoneOffset.ofHours(2);
    void init(Opts opts){
        final Jdbi db = hubsStore.getJdbi();
        db.getConfig(TimestampedConfig.class).setTimezone(GMT_PLUS_2);

        if(!opts.silent) {
            db.setSqlLogger(new SqlLogger() {
                @Override
                public void logBeforeExecution(StatementContext ctx) {
                    System.out.println("sql -> " + ctx.getRawSql());
                    System.out.println("\t" + ctx.getParsedSql().getSql());
                }
            });
        }

        TemplateGlobalContext.getContext().preload("Shipment", "PostalAddress");
    }

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

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Shipment implements Serializable {
        private static final long serialVersionUID = 1L;

        String shipmentId;
        String shipmentTypeId;
        String statusId;
        String primaryOrderId;
        String primaryReturnId;
        String primaryShipGroupSeqId;
        String picklistBinId;
        java.time.LocalDateTime estimatedReadyDate;
        java.time.LocalDateTime estimatedShipDate;
        String estimatedShipWorkEffId;
        java.time.LocalDateTime estimatedArrivalDate;
        String estimatedArrivalWorkEffId;
        java.time.LocalDateTime latestCancelDate;
        java.math.BigDecimal estimatedShipCost;
        String currencyUomId;
        String handlingInstructions;
        String originFacilityId;
        String destinationFacilityId;
        String originContactMechId;
        String originTelecomNumberId;
        String destinationContactMechId;
        String destinationTelecomNumberId;
        String partyIdTo;
        String partyIdFrom;
        java.math.BigDecimal additionalShippingCharge;
        String addtlShippingChargeDesc;
        java.time.LocalDateTime createdDate;
        String createdByUserLogin;
        java.time.LocalDateTime lastModifiedDate;
        String lastModifiedByUserLogin;
        java.time.LocalDateTime lastUpdatedStamp;
        java.time.LocalDateTime createdStamp;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostalAddress implements Serializable {
        private static final long serialVersionUID = 1L;

        String contactMechId;
        String toName;
        String attnName;
        String address1;
        String address2;
        Long houseNumber;
        String houseNumberExt;
        String directions;
        String city;
        String cityGeoId;
        String postalCode;
        String postalCodeExt;
        String countryGeoId;
        String stateProvinceGeoId;
        String countyGeoId;
        String municipalityGeoId;
        String postalCodeGeoId;
        String geoPointId;
        java.time.LocalDateTime lastUpdatedStamp;
        java.time.LocalDateTime createdStamp;

    }

}

