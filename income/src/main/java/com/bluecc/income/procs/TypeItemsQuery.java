package com.bluecc.income.procs;

import com.bluecc.hubs.feed.FactBag;
import com.bluecc.hubs.fund.Tuple2;
import com.bluecc.hubs.stub.SeedType;
import com.bluecc.hubs.stub.SeedTypeItem;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.google.common.collect.Maps;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TypeItemsQuery {
    @Inject
    FactBag factBag;

    public List<SeedType> queryStatusTypeAndItems() {
        // types
        List<SeedType> seedTypes = getStatusType("StatusType")
                .stream().map(e -> {
                    SeedType seedType = SeedType.newBuilder()
                            .setTypeId(e.f0.getStatusTypeId())
                            .setParentTypeId(e.f0.getParentTypeId())
                            .setDescription(e.f0.getDescription())
                            .putAllItems(convertItems(e.f1))
                            .build();
                    return seedType;
                }).collect(Collectors.toList());
        return seedTypes;
    }

    // convert items
    private Map<String, SeedTypeItem> convertItems(List<StatusItemData> items) {
        Map<String, SeedTypeItem> result = Maps.newHashMap();
        items.forEach(item -> {
            result.put(item.getStatusId(), SeedTypeItem.newBuilder()
                    .setItemId(item.getStatusId())
                    .setDescription(item.getDescription())
                    .setItemTypeId(item.getStatusTypeId())
                    .build());
        });
        return result;
    }

    // type
    private List<Tuple2<StatusTypeData, List<StatusItemData>>> getStatusType(String typeName) {
        return factBag.allTypes(typeName, StatusTypeData::parseFrom)
                .stream()
                .map(e -> Tuple2.of(e, getStatusItems(e.getStatusTypeId())))
                .collect(Collectors.toList());
    }

    // items
    private List<StatusItemData> getStatusItems(String typeId) {
        List<StatusItemData> items = factBag.allTypes("StatusItem", StatusItemData::parseFrom)
                .stream().filter(e -> e.getStatusTypeId().equals(typeId))
                .collect(Collectors.toList());
        return items;
    }

}
