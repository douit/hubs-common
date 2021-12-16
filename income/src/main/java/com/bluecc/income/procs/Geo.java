package com.bluecc.income.procs;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.hubs.fund.model.WithLocation;
import com.bluecc.hubs.stub.GeoPointData;
import com.bluecc.income.helper.TenantId;
import org.redisson.api.GeoEntry;
import org.redisson.api.GeoPosition;
import org.redisson.api.GeoUnit;
import org.redisson.api.RGeo;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Geo {
    LiveObjects liveObjects;
    String tenantId;
    RGeo<String> geo;

    @Inject
    public Geo(LiveObjects liveObjects, @TenantId String tenantId) {
        this.liveObjects = liveObjects;
        this.tenantId = tenantId;

        geo = liveObjects.redisson().getGeo(tenantId);
    }

    public static GeoEntry getGeoEntry(GeoPointData pointData) {
        GeoEntry entry = new GeoEntry(Double.parseDouble(pointData.getLongitude()),
                Double.parseDouble(pointData.getLatitude()),
                pointData.getGeoPointId());
        return entry;
    }

    public RGeo<String> getGeo() {
        return geo;
    }

    public void addGeoPoint(GeoPointData pointData) {
        GeoEntry entry = getGeoEntry(pointData);
        geo.add(entry);
    }

    public Double dist(String fromId, String toId) {
        return geo.dist(fromId, toId, GeoUnit.METERS);
    }

    public Double dist(WithLocation from, WithLocation to) {
        return dist(from.getGeoPointId(), to.getGeoPointId());
    }

    public Map<String, GeoPosition> pos(String... ids) {
        return geo.pos(ids);
    }

    public List<GeoPointData> getGeoPoints(String... ids) {
        return geo.pos(ids).entrySet().stream().map(entry ->
                GeoPointData.newBuilder()
                        .setGeoPointId(entry.getKey())
                        .setLongitude(Double.toString(entry.getValue().getLongitude()))
                        .setLatitude(Double.toString(entry.getValue().getLatitude()))
                        .build())
                .collect(Collectors.toList());
    }
}
