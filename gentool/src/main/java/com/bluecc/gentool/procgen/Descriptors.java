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
                        .sigular(Person.fields("lastName", "firstName"))
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
                        .sigular(Person)  // 前面定义的也会起作用
                        .detail(PartyRole)
                        .build())
                .build();
    }
}

