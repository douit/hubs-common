package com.bluecc.hubs.fund;

import com.google.common.collect.Sets;

import java.util.Set;

public class HeadEntity {
    // @Singular
    private Set<String> flatIds;
    private static final Set<String> EMPTY_SET= Sets.newHashSet();
    public Set<String> getFlatIds() {
        if(flatIds==null){
            return EMPTY_SET;
        }
        return flatIds;
    }

    public void setFlatIds(Set<String> flatIds) {
        this.flatIds = flatIds;
    }
}
