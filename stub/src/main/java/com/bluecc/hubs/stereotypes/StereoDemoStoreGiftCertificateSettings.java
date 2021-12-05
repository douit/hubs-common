package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ProductContentData;
import com.bluecc.hubs.stub.ProductStoreFinActSettingData;
import com.bluecc.hubs.stub.ContentData;
import com.bluecc.hubs.stub.ProductStorePaymentSettingData;

public final class StereoDemoStoreGiftCertificateSettings {
    public final static ProductContentData ProductContent_GC_001_GC_PURCHASE_FULFILLMENT_EXTASYNC_ = ProductContentData.newBuilder()
        .setContentId("GC_PURCHASE")
        .setFromDate(getTimestamp("2000-01-01 00:00:00"))
        .setProductContentTypeId("FULFILLMENT_EXTASYNC")
        .setProductId("GC-001")
        .build();

    public final static ProductStoreFinActSettingData ProductStoreFinActSetting_9000_GIFTCERT_ACCOUNT = ProductStoreFinActSettingData.newBuilder()
        .setAccountCodeLength(12)
        .setAccountValidDays(365)
        .setAuthValidDays(30)
        .setFinAccountTypeId("GIFTCERT_ACCOUNT")
        .setPinCodeLength(4)
        .setProductStoreId("9000")
        .setPurchSurveyCopyMe("copyMe")
        .setPurchSurveySendTo("recipientEmail")
        .setPurchaseSurveyId("1000")
        .setRequirePinCode(castIndicator("N"))
        .setValidateGCFinAcct(castIndicator("Y"))
        .build();

    public final static ContentData Content_GC_PURCHASE = ContentData.newBuilder()
        .setContentId("GC_PURCHASE")
        .setCustomMethodId("GIFT_PURCH_OFBIZ")
        .build();

    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_9000_GIFT_CARD_PRDS_PAY_AUTH = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("GIFT_AUTH_OFBIZ")
        .setPaymentMethodTypeId("GIFT_CARD")
        .setPaymentService("ofbGcAuthorize")
        .setPaymentServiceTypeEnumId("PRDS_PAY_AUTH")
        .setProductStoreId("9000")
        .build();

    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_9000_GIFT_CARD_PRDS_PAY_RELEASE = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("GIFT_RELEASE_OFBIZ")
        .setPaymentMethodTypeId("GIFT_CARD")
        .setPaymentService("ofbGcRelease")
        .setPaymentServiceTypeEnumId("PRDS_PAY_RELEASE")
        .setProductStoreId("9000")
        .build();

    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_9000_GIFT_CARD_PRDS_PAY_CAPTURE = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("GIFT_CAPTURE_OFBIZ")
        .setPaymentMethodTypeId("GIFT_CARD")
        .setPaymentService("ofbGcProcessor")
        .setPaymentServiceTypeEnumId("PRDS_PAY_CAPTURE")
        .setProductStoreId("9000")
        .build();

    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_9000_GIFT_CARD_PRDS_PAY_REAUTH = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("GIFT_AUTH_OFBIZ")
        .setPaymentMethodTypeId("GIFT_CARD")
        .setPaymentService("ofbGcAuthorize")
        .setPaymentServiceTypeEnumId("PRDS_PAY_REAUTH")
        .setProductStoreId("9000")
        .build();

    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_9000_GIFT_CARD_PRDS_PAY_REFUND = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("GIFT_REFUND_OFBIZ")
        .setPaymentMethodTypeId("GIFT_CARD")
        .setPaymentService("ofbGcRefund")
        .setPaymentServiceTypeEnumId("PRDS_PAY_REFUND")
        .setProductStoreId("9000")
        .build();

}
