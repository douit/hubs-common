package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.StereoDemoStoreGiftCertificateSettings.*;

import com.bluecc.hubs.stub.ProductContentData;
import com.bluecc.hubs.stub.ProductStoreFinActSettingData;
import com.bluecc.hubs.stub.ContentData;
import com.bluecc.hubs.stub.ProductStorePaymentSettingData;

public final class StereoDemoStoreGiftCertificateSettingsList {
    public static final List<ProductContentData> productContentList=ImmutableList.of(        
            ProductContent_GC_001_GC_PURCHASE_FULFILLMENT_EXTASYNC_);

    public static final List<ProductStoreFinActSettingData> productStoreFinActSettingList=ImmutableList.of(        
            ProductStoreFinActSetting_9000_GIFTCERT_ACCOUNT);

    public static final List<ContentData> contentList=ImmutableList.of(        
            Content_GC_PURCHASE);

    public static final List<ProductStorePaymentSettingData> productStorePaymentSettingList=ImmutableList.of(        
            ProductStorePaymentSetting_9000_GIFT_CARD_PRDS_PAY_AUTH,        
            ProductStorePaymentSetting_9000_GIFT_CARD_PRDS_PAY_RELEASE,        
            ProductStorePaymentSetting_9000_GIFT_CARD_PRDS_PAY_CAPTURE,        
            ProductStorePaymentSetting_9000_GIFT_CARD_PRDS_PAY_REAUTH,        
            ProductStorePaymentSetting_9000_GIFT_CARD_PRDS_PAY_REFUND);

}
