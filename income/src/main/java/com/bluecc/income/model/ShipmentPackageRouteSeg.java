package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.ShipmentPackageRouteSegData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class ShipmentPackageRouteSeg implements IEventModel<ShipmentPackageRouteSegData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String shipmentId;
    @RIndex String shipmentPackageSeqId;
    @RIndex String shipmentRouteSegmentId;
    String trackingCode;
    String boxNumber;
    byte[] labelImage;
    byte[] labelIntlSignImage;
    String labelHtml;
    Character labelPrinted;
    byte[] internationalInvoice;
    java.math.BigDecimal packageTransportCost;
    java.math.BigDecimal packageServiceCost;
    java.math.BigDecimal packageOtherCost;
    java.math.BigDecimal codAmount;
    java.math.BigDecimal insuredAmount;
    String currencyUomId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShipmentPackageRouteSegData.Builder toDataBuilder() {
        ShipmentPackageRouteSegData.Builder builder = ShipmentPackageRouteSegData.newBuilder();
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (shipmentPackageSeqId != null) {
            builder.setShipmentPackageSeqId(shipmentPackageSeqId);
        }
        if (shipmentRouteSegmentId != null) {
            builder.setShipmentRouteSegmentId(shipmentRouteSegmentId);
        }
        if (trackingCode != null) {
            builder.setTrackingCode(trackingCode);
        }
        if (boxNumber != null) {
            builder.setBoxNumber(boxNumber);
        }
        if (labelImage != null) {
            builder.setLabelImage(ByteString.copyFrom(labelImage));
        }
        if (labelIntlSignImage != null) {
            builder.setLabelIntlSignImage(ByteString.copyFrom(labelIntlSignImage));
        }
        if (labelHtml != null) {
            builder.setLabelHtml(labelHtml);
        }
        if (labelPrinted != null) {
            builder.setLabelPrinted(getIndicator(labelPrinted));
        }
        if (internationalInvoice != null) {
            builder.setInternationalInvoice(ByteString.copyFrom(internationalInvoice));
        }
        if (packageTransportCost != null) {
            builder.setPackageTransportCost(getCurrency(packageTransportCost));
        }
        if (packageServiceCost != null) {
            builder.setPackageServiceCost(getCurrency(packageServiceCost));
        }
        if (packageOtherCost != null) {
            builder.setPackageOtherCost(getCurrency(packageOtherCost));
        }
        if (codAmount != null) {
            builder.setCodAmount(getCurrency(codAmount));
        }
        if (insuredAmount != null) {
            builder.setInsuredAmount(getCurrency(insuredAmount));
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

    public static ShipmentPackageRouteSeg fromData(ShipmentPackageRouteSegData data) {
        return ShipmentPackageRouteSeg.builder()
                .shipmentId(data.getShipmentId())
                .shipmentPackageSeqId(data.getShipmentPackageSeqId())
                .shipmentRouteSegmentId(data.getShipmentRouteSegmentId())
                .trackingCode(data.getTrackingCode())
                .boxNumber(data.getBoxNumber())
                .labelImage(data.getLabelImage().toByteArray())
                .labelIntlSignImage(data.getLabelIntlSignImage().toByteArray())
                .labelHtml(data.getLabelHtml())
                .labelPrinted(getIndicatorChar(data.getLabelPrinted()))
                .internationalInvoice(data.getInternationalInvoice().toByteArray())
                .packageTransportCost(getBigDecimal(data.getPackageTransportCost()))
                .packageServiceCost(getBigDecimal(data.getPackageServiceCost()))
                .packageOtherCost(getBigDecimal(data.getPackageOtherCost()))
                .codAmount(getBigDecimal(data.getCodAmount()))
                .insuredAmount(getBigDecimal(data.getInsuredAmount()))
                .currencyUomId(data.getCurrencyUomId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
