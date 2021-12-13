package com.bluecc.income.procs;

import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.hubs.stub.ProductStoreFlatData;
import com.bluecc.income.dao.ProductStoreDelegator;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.bluecc.hubs.ProtoTypes.castIndicator;

public class ProductStores extends ProductStoreDelegator {
    public CompletableFuture<List<IModel<?>>> queryProductStoreSettings(String storeId){
        CompletableFuture<List<IModel<?>>> cf=
                process(c -> {
                    ProductStoreDelegator.Agent agent = getAgent(c, storeId);
                    // ProductStore productStore = agent.merge(); // DON'T DO THIS

                    c.getSubscriber().onNext(agent.getRecord());
                    agent.getProductStorePaymentSetting().forEach(e -> {
                        c.getSubscriber().onNext(e);
                    });
                    c.getSubscriber().onComplete();
                }).collectList().toFuture();
        return cf;
    }

    public ProductStoreFlatData createRentalStore() {
        return ProductStoreFlatData.newBuilder()
                .setAllowPassword(castIndicator("Y"))
                .setAuthDeclinedMessage("There has been a problem with your method of payment. Please try a different method or call customer service.")
                .setAuthErrorMessage("Problem connecting to payment processor; we will continue to retry and notify you by email.")
                .setAuthFraudMessage("Your order has been rejected and your account has been disabled due to fraud.")
                .setAutoApproveInvoice(castIndicator("Y"))
                .setAutoApproveOrder(castIndicator("Y"))
                .setCheckInventory(castIndicator("N"))
                .setCompanyName("Open Travel Ltd")
                .setDaysToCancelNonPay(30)
                .setDefaultCurrencyUomId("EUR")
                .setDefaultLocaleString("en_US")
                .setDigitalItemApprovedStatus("ITEM_APPROVED")
                .setExplodeOrderItems(castIndicator("N"))
                .setHeaderApprovedStatus("ORDER_APPROVED")
                .setHeaderCancelStatus("ORDER_CANCELLED")
                .setHeaderDeclinedStatus("ORDER_REJECTED")
                .setInventoryFacilityId("WebStoreWarehouse")
                .setIsImmediatelyFulfilled(castIndicator("Y"))
                .setItemApprovedStatus("ITEM_APPROVED")
                .setItemCancelStatus("ITEM_CANCELLED")
                .setItemDeclinedStatus("ITEM_REJECTED")
                .setOneInventoryFacility(castIndicator("N"))
                .setOrderNumberPrefix("WS")
                .setPayToPartyId("Company")
                .setProductStoreId(sequence.nextStringId())
                .setProrateShipping(castIndicator("Y"))
                .setProrateTaxes(castIndicator("Y"))
                .setRequireInventory(castIndicator("N"))
                .setReserveInventory(castIndicator("N"))
                .setReserveOrderEnumId("INVRO_FIFO_REC")
                .setRetryFailedAuths(castIndicator("Y"))
                .setShipIfCaptureFails(castIndicator("Y"))
                .setStoreName("Open Travel system Demo Site")
                .setSubtitle("Part of the Apache OFBiz Family of Open Source Software")
                .setTitle("Ready for your reservation")
                .setVisualThemeId("EC_DEFAULT")
                .build();
    }
}


