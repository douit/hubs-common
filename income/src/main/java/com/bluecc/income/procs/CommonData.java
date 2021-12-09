package com.bluecc.income.procs;

import lombok.Data;

public class CommonData {
    @Data
    public static class PartyFromTo{
        String from;
        String to;
    }

    @Data
    public static class ShipmentDestination{
        // .setDestinationContactMechId("9200"),
        // .setDestinationFacilityId("WebStoreWarehouse"),
        // .setDestinationTelecomNumberId("9201")
        String contactMechId;
        String facilityId;
        String telecomNumberId;
    }
}
