package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.GeoPointData;

public final class PartyGeoPointData {
    public static GeoPointData GeoPoint_9000() {
        return GeoPointData.newBuilder()
            .setDataSourceId("GEOPT_GOOGLE")
            .setElevation(getFixedPoint("4770"))
            .setElevationUomId("LEN_ft")
            .setGeoPointId("9000")
            .setInformation("A testing GeoPoint for contactMechId=9015 (DemoCustomer)")
            .setLatitude("40.297264")
            .setLongitude("-111.696625")
            .build();
    }


    public static GeoPointData GeoPoint_9001() {
        return GeoPointData.newBuilder()
            .setDataSourceId("GEOPT_GOOGLE")
            .setElevation(getFixedPoint("10"))
            .setElevationUomId("LEN_m")
            .setGeoPointId("9001")
            .setInformation("A testing GeoPoint for contactMechId=EUROCUSTOMER (EuroCustomer)")
            .setLatitude("52.350")
            .setLongitude("4.917")
            .build();
    }


    public static GeoPointData GeoPoint_9002() {
        return GeoPointData.newBuilder()
            .setDataSourceId("GEOPT_GOOGLE")
            .setElevation(getFixedPoint("30"))
            .setElevationUomId("LEN_m")
            .setGeoPointId("9002")
            .setInformation("A testing GeoPoint for contactMechId=FRENCHCUSTOMER (FrenchCustomer)")
            .setLatitude("43.492")
            .setLongitude("3.684")
            .build();
    }

}
