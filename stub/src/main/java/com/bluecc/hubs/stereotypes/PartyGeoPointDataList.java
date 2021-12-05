package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.PartyGeoPointData.*;

import com.bluecc.hubs.stub.GeoPointData;

public final class PartyGeoPointDataList {
    public static List<GeoPointData> geoPointList() {
        return ImmutableList.of(        
            GeoPoint_9000(),        
            GeoPoint_9001(),        
            GeoPoint_9002());
    }

}
