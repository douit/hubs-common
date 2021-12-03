package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.OrderHeaderFlatData;

import com.bluecc.hubs.stub.OrderHeaderData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderHeader implements IEventModel<OrderHeaderFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String orderId;
    String orderTypeId;
    String orderName;
    String externalId;
    String salesChannelEnumId;
    java.time.LocalDateTime orderDate;
    Character priority;
    java.time.LocalDateTime entryDate;
    java.time.LocalDateTime pickSheetPrintedDate;
    String visitId;
    String statusId;
    String createdBy;
    String firstAttemptOrderId;
    String currencyUom;
    String syncStatusId;
    String billingAccountId;
    String originFacilityId;
    String webSiteId;
    String productStoreId;
    String agreementId;
    String terminalId;
    String transactionId;
    String autoOrderShoppingListId;
    Character needsInventoryIssuance;
    Character isRushOrder;
    String internalCode;
    java.math.BigDecimal remainingSubTotal;
    java.math.BigDecimal grandTotal;
    Character isViewed;
    Character invoicePerShipment;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderHeaderFlatData.Builder toDataBuilder() {
        OrderHeaderFlatData.Builder builder = OrderHeaderFlatData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderTypeId != null) {
            builder.setOrderTypeId(orderTypeId);
        }
        if (orderName != null) {
            builder.setOrderName(orderName);
        }
        if (externalId != null) {
            builder.setExternalId(externalId);
        }
        if (salesChannelEnumId != null) {
            builder.setSalesChannelEnumId(salesChannelEnumId);
        }
        if (orderDate != null) {
            builder.setOrderDate(getTimestamp(orderDate));
        }
        if (priority != null) {
            builder.setPriority(getIndicator(priority));
        }
        if (entryDate != null) {
            builder.setEntryDate(getTimestamp(entryDate));
        }
        if (pickSheetPrintedDate != null) {
            builder.setPickSheetPrintedDate(getTimestamp(pickSheetPrintedDate));
        }
        if (visitId != null) {
            builder.setVisitId(visitId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (createdBy != null) {
            builder.setCreatedBy(createdBy);
        }
        if (firstAttemptOrderId != null) {
            builder.setFirstAttemptOrderId(firstAttemptOrderId);
        }
        if (currencyUom != null) {
            builder.setCurrencyUom(currencyUom);
        }
        if (syncStatusId != null) {
            builder.setSyncStatusId(syncStatusId);
        }
        if (billingAccountId != null) {
            builder.setBillingAccountId(billingAccountId);
        }
        if (originFacilityId != null) {
            builder.setOriginFacilityId(originFacilityId);
        }
        if (webSiteId != null) {
            builder.setWebSiteId(webSiteId);
        }
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (agreementId != null) {
            builder.setAgreementId(agreementId);
        }
        if (terminalId != null) {
            builder.setTerminalId(terminalId);
        }
        if (transactionId != null) {
            builder.setTransactionId(transactionId);
        }
        if (autoOrderShoppingListId != null) {
            builder.setAutoOrderShoppingListId(autoOrderShoppingListId);
        }
        if (needsInventoryIssuance != null) {
            builder.setNeedsInventoryIssuance(getIndicator(needsInventoryIssuance));
        }
        if (isRushOrder != null) {
            builder.setIsRushOrder(getIndicator(isRushOrder));
        }
        if (internalCode != null) {
            builder.setInternalCode(internalCode);
        }
        if (remainingSubTotal != null) {
            builder.setRemainingSubTotal(getCurrency(remainingSubTotal));
        }
        if (grandTotal != null) {
            builder.setGrandTotal(getCurrency(grandTotal));
        }
        if (isViewed != null) {
            builder.setIsViewed(getIndicator(isViewed));
        }
        if (invoicePerShipment != null) {
            builder.setInvoicePerShipment(getIndicator(invoicePerShipment));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static OrderHeader fromData(OrderHeaderFlatData data) {
        return OrderHeader.builder()
                .orderId(data.getOrderId())
                .orderTypeId(data.getOrderTypeId())
                .orderName(data.getOrderName())
                .externalId(data.getExternalId())
                .salesChannelEnumId(data.getSalesChannelEnumId())
                .orderDate(getLocalDateTime(data.getOrderDate()))
                .priority(getIndicatorChar(data.getPriority()))
                .entryDate(getLocalDateTime(data.getEntryDate()))
                .pickSheetPrintedDate(getLocalDateTime(data.getPickSheetPrintedDate()))
                .visitId(data.getVisitId())
                .statusId(data.getStatusId())
                .createdBy(data.getCreatedBy())
                .firstAttemptOrderId(data.getFirstAttemptOrderId())
                .currencyUom(data.getCurrencyUom())
                .syncStatusId(data.getSyncStatusId())
                .billingAccountId(data.getBillingAccountId())
                .originFacilityId(data.getOriginFacilityId())
                .webSiteId(data.getWebSiteId())
                .productStoreId(data.getProductStoreId())
                .agreementId(data.getAgreementId())
                .terminalId(data.getTerminalId())
                .transactionId(data.getTransactionId())
                .autoOrderShoppingListId(data.getAutoOrderShoppingListId())
                .needsInventoryIssuance(getIndicatorChar(data.getNeedsInventoryIssuance()))
                .isRushOrder(getIndicatorChar(data.getIsRushOrder()))
                .internalCode(data.getInternalCode())
                .remainingSubTotal(getBigDecimal(data.getRemainingSubTotal()))
                .grandTotal(getBigDecimal(data.getGrandTotal()))
                .isViewed(getIndicatorChar(data.getIsViewed()))
                .invoicePerShipment(getIndicatorChar(data.getInvoicePerShipment()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
    @SuppressWarnings("unchecked")
    public <T extends Message.Builder> T toHeadBuilder() {
        OrderHeaderData.Builder builder = OrderHeaderData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderTypeId != null) {
            builder.setOrderTypeId(orderTypeId);
        }
        if (orderName != null) {
            builder.setOrderName(orderName);
        }
        if (externalId != null) {
            builder.setExternalId(externalId);
        }
        if (salesChannelEnumId != null) {
            builder.setSalesChannelEnumId(salesChannelEnumId);
        }
        if (orderDate != null) {
            builder.setOrderDate(getTimestamp(orderDate));
        }
        if (priority != null) {
            builder.setPriority(getIndicator(priority));
        }
        if (entryDate != null) {
            builder.setEntryDate(getTimestamp(entryDate));
        }
        if (pickSheetPrintedDate != null) {
            builder.setPickSheetPrintedDate(getTimestamp(pickSheetPrintedDate));
        }
        if (visitId != null) {
            builder.setVisitId(visitId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (firstAttemptOrderId != null) {
            builder.setFirstAttemptOrderId(firstAttemptOrderId);
        }
        if (currencyUom != null) {
            builder.setCurrencyUom(currencyUom);
        }
        if (syncStatusId != null) {
            builder.setSyncStatusId(syncStatusId);
        }
        if (originFacilityId != null) {
            builder.setOriginFacilityId(originFacilityId);
        }
        if (agreementId != null) {
            builder.setAgreementId(agreementId);
        }
        if (terminalId != null) {
            builder.setTerminalId(terminalId);
        }
        if (transactionId != null) {
            builder.setTransactionId(transactionId);
        }
        if (autoOrderShoppingListId != null) {
            builder.setAutoOrderShoppingListId(autoOrderShoppingListId);
        }
        if (needsInventoryIssuance != null) {
            builder.setNeedsInventoryIssuance(getIndicator(needsInventoryIssuance));
        }
        if (isRushOrder != null) {
            builder.setIsRushOrder(getIndicator(isRushOrder));
        }
        if (internalCode != null) {
            builder.setInternalCode(internalCode);
        }
        if (remainingSubTotal != null) {
            builder.setRemainingSubTotal(getCurrency(remainingSubTotal));
        }
        if (grandTotal != null) {
            builder.setGrandTotal(getCurrency(grandTotal));
        }
        if (isViewed != null) {
            builder.setIsViewed(getIndicator(isViewed));
        }
        if (invoicePerShipment != null) {
            builder.setInvoicePerShipment(getIndicator(invoicePerShipment));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return (T)builder;
    }

}
