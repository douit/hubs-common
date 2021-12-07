package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.SalesAgreement.*;

import com.bluecc.hubs.stub.AgreementItemData;
import com.bluecc.hubs.stub.AgreementProductApplData;
import com.bluecc.hubs.stub.AgreementData;
import com.bluecc.hubs.stub.AgreementTermData;

public final class SalesAgreementList {
    public static List<AgreementItemData> agreementItemList() {
        return ImmutableList.of(        
            AgreementItem_AGR_SALES_00001());
    }

    public static List<AgreementProductApplData> agreementProductApplList() {
        return ImmutableList.of(        
            AgreementProductAppl_AGR_SALES_00001_GZ_1000());
    }

    public static List<AgreementData> agreementList() {
        return ImmutableList.of(        
            Agreement_AGR_SALES());
    }

    public static List<AgreementTermData> agreementTermList() {
        return ImmutableList.of(        
            AgreementTerm_9000());
    }

}
