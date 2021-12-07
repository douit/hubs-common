package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.AgreementItemData;
import com.bluecc.hubs.stub.AgreementProductApplData;
import com.bluecc.hubs.stub.AgreementData;
import com.bluecc.hubs.stub.AgreementTermData;

public final class SalesAgreement {
    public static AgreementItemData AgreementItem_AGR_SALES_00001() {
        return AgreementItemData.newBuilder()
            .setAgreementId("AGR_SALES")
            .setAgreementItemSeqId("00001")
            .setAgreementItemTypeId("AGREEMENT_PRICING_PR")
            .setAgreementText("Price list in US Dollars")
            .setCurrencyUomId("USD")
            .build();
    }


    public static AgreementProductApplData AgreementProductAppl_AGR_SALES_00001_GZ_1000() {
        return AgreementProductApplData.newBuilder()
            .setAgreementId("AGR_SALES")
            .setAgreementItemSeqId("00001")
            .setPrice(getCurrency("10.000"))
            .setProductId("GZ-1000")
            .build();
    }


    public static AgreementData Agreement_AGR_SALES() {
        return AgreementData.newBuilder()
            .setAgreementId("AGR_SALES")
            .setAgreementTypeId("SALES_AGREEMENT")
            .setDescription("Agreement for DemoCustomer")
            .setPartyIdFrom("DemoCustomer")
            .setPartyIdTo("Company")
            .setRoleTypeIdFrom("CUSTOMER")
            .setRoleTypeIdTo("INTERNAL_ORGANIZATIO")
            .build();
    }


    public static AgreementTermData AgreementTerm_9000() {
        return AgreementTermData.newBuilder()
            .setAgreementId("AGR_SALES")
            .setAgreementItemSeqId("00001")
            .setAgreementTermId("9000")
            .setDescription("Sales test agreement")
            .setTermDays(30)
            .setTermTypeId("FIN_PAYMENT_FIXDAY")
            .build();
    }

}
