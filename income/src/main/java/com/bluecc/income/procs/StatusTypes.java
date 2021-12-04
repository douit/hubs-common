package com.bluecc.income.procs;

import com.bluecc.hubs.feed.FactBag;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusValidChangeData;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StatusTypes {

    @Inject
    FactBag factBag;

    public Optional<String> getTransitionName(String statusId, String statusIdTo) {
        Optional<String> transName= factBag.allTypes("StatusValidChange", StatusValidChangeData::parseFrom)
                .stream().filter(e -> e.getStatusId().equals(statusId)
                        && e.getStatusIdTo().equals(statusIdTo))
                .findFirst()
                .map(e -> e.getTransitionName());
        return transName;
    }

    public Set<String> getValidChanges(String statusId){
        return factBag.allTypes("StatusValidChange", StatusValidChangeData::parseFrom)
                .stream().filter(e -> e.getStatusId().equals(statusId))
                .map(e -> e.getStatusIdTo())
                .collect(Collectors.toSet());
    }

    public List<StatusItemData> getAllStatusItems(String statusTypeId){
        return factBag.allTypes("StatusItem", StatusItemData::parseFrom)
                .stream().filter(e -> e.getStatusTypeId().equals(statusTypeId))
                .collect(Collectors.toList());
    }

    public List<String> getAllStatusItemIds(String statusTypeId){
        return getAllStatusItems(statusTypeId)
                .stream().map(e -> e.getStatusId())
                .collect(Collectors.toList());
    }
}

