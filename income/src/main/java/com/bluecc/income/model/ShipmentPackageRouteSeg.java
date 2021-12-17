//// Generated, DO NOT EDIT
package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;
// import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.annotations.SerializedName;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.ShipmentPackageRouteSegData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentPackageRouteSegData.class,
        symbol = EntityNames.ShipmentPackageRouteSeg)
public class ShipmentPackageRouteSeg implements IEventModel<ShipmentPackageRouteSegData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("shipment_id")
	@RIndex 
    String shipmentId;
    @SerializedName("shipment_package_seq_id")
	@RIndex 
    String shipmentPackageSeqId;
    @SerializedName("shipment_route_segment_id")
	@RIndex 
    String shipmentRouteSegmentId;
    @SerializedName("tracking_code") 
    String trackingCode;
    @SerializedName("box_number") 
    String boxNumber;
    @SerializedName("label_image") 
    byte[] labelImage;
    @SerializedName("label_intl_sign_image") 
    byte[] labelIntlSignImage;
    @SerializedName("label_html") 
    String labelHtml;
    @SerializedName("label_printed") 
    Character labelPrinted;
    @SerializedName("international_invoice") 
    byte[] internationalInvoice;
    @SerializedName("package_transport_cost") 
    java.math.BigDecimal packageTransportCost;
    @SerializedName("package_service_cost") 
    java.math.BigDecimal packageServiceCost;
    @SerializedName("package_other_cost") 
    java.math.BigDecimal packageOtherCost;
    @SerializedName("cod_amount") 
    java.math.BigDecimal codAmount;
    @SerializedName("insured_amount") 
    java.math.BigDecimal insuredAmount;
    @SerializedName("currency_uom_id") 
    String currencyUomId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("id")
	@RId 
    String id;
    

        
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


/*
-- keys: shipmentId, shipmentPackageSeqId, shipmentRouteSegmentId

-- fields --
    
    String shipmentId
    String shipmentPackageSeqId
    String shipmentRouteSegmentId
    String trackingCode
    String boxNumber
    byte[] labelImage
    byte[] labelIntlSignImage
    String labelHtml
    Character labelPrinted
    byte[] internationalInvoice
    java.math.BigDecimal packageTransportCost
    java.math.BigDecimal packageServiceCost
    java.math.BigDecimal packageOtherCost
    java.math.BigDecimal codAmount
    java.math.BigDecimal insuredAmount
    String currencyUomId

-- relations --
    
    - ShipmentPackage (one, autoRelation: false, keymaps: shipmentId, shipmentPackageSeqId)
    - Shipment (one-nofk, autoRelation: false, keymaps: shipmentId)
    - ShipmentRouteSegment (one, autoRelation: false, keymaps: shipmentId, shipmentRouteSegmentId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
*/

