package com.bluecc.gentool.procgen;

import static com.bluecc.gentool.descriptor.EntityNames.*;

public class Descriptors implements IDescriptors {

    public DaoDescriptors paramObjects() {
        return DaoDescriptors.builder()
                .daoName("CustomerProcs")
                .base(Party)
                .item(DaoDescriptor.builder()
                        .name("CustomerParams")
                        .params(true)
                        .master(Party)
                        .sigular(Person)
                        .sigular(UserLogin)
                        .sigular(PartyStatus)
                        .detail(PartyRole)
                        .build())
                .item(DaoDescriptor.builder()
                        .name("Customer")
                        .attr("partyId")
                        .attr("lastName")
                        .attr("firstName")
                        .master(Party)
                        .sigular(Person)
                        .detail(PartyRole)
                        .build())
                .build();
    }
}

