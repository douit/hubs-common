package com.bluecc.income.exchange;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.InspectMeta;
import com.bluecc.hubs.fund.InspectMeta.EntityInspect;
import com.bluecc.hubs.fund.InspectMeta.RelationMark;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.stub.EntityValue;
import com.bluecc.hubs.stub.OrderHeaderFlatData;
import com.bluecc.income.model.OrderHeader;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.bluecc.hubs.ProtoTypes.*;
import static com.bluecc.hubs.ProtoTypes.getCurrency;
import static com.bluecc.hubs.fund.Util.pretty;
import static org.junit.Assert.*;
import static org.yaml.snakeyaml.DumperOptions.FlowStyle.*;

public class ModelSerializerTest {

    @Test
    public void toStringMap() {
        OrderHeader orderHeader=OrderHeader.fromData(OrderHeader_DEMO10090());
        ModelSerializer.toStringMap(orderHeader).forEach((k, v) ->{
            System.out.println(k+": "+v);
        });
    }

    @Test
    public void testToEntityValue(){
        OrderHeader orderHeader=OrderHeader.fromData(OrderHeader_DEMO10090());
        EntityValue entityValue= EntityValue.newBuilder()
                .putAllValues(ModelSerializer.toStringMap(orderHeader))
                .build();
        System.out.println(entityValue);
    }

    static OrderHeaderFlatData OrderHeader_DEMO10090() {
        return OrderHeaderFlatData.newBuilder()
                .setCreatedBy("admin")
                .setCurrencyUom("USD")
                .setEntryDate(getTimestamp("2008-04-23 16:49:27.392"))
                .setGrandTotal(getCurrency("50.85"))
                .setInvoicePerShipment(castIndicator("Y"))
                .setOrderDate(getTimestamp("2008-04-23 16:49:27.392"))
                .setOrderId("DEMO10090")
                .setOrderTypeId("SALES_ORDER")
                .setPriority(castIndicator("2"))
                .setProductStoreId("9000")
                .setRemainingSubTotal(getCurrency("38.40"))
                .setSalesChannelEnumId("WEB_SALES_CHANNEL")
                .setStatusId("ORDER_APPROVED")
                .setVisitId("10002")
                .setWebSiteId("WebStore")
                .build();
    }

    ProtoMeta protoMeta=new ProtoMeta();

    @Test
    public void testRelations(){
        // System.out.println(RelationTags.skip);
        // EntityMeta meta=protoMeta.getEntityMeta("Product");
        EntityMeta meta=protoMeta.getEntityMeta("Tenant");
        // skip, multi, single, assoc
        List<RelationMark> marks=meta.getValidRelations()
                .stream().sorted(Comparator.comparing(e -> e.getRelEntityName()))
                .peek( e -> System.out.println(e.getName()+", "
                        +e.getType()))
                .map(e -> RelationMark.builder()
                        .name(e.getName())
                        .relationType(e.getType())
                        .entityName(e.getRelEntityName())
                        .bindFields(e.getRelFieldList())
                        .tags(Collections.singletonList("skip"))
                        .build()
                )
                .collect(Collectors.toList());
        EntityInspect inspect=EntityInspect.builder()
                .name(meta.getName())
                .relationMarks(marks)
                .build();
        // pretty(inspect);

        System.out.println("----------------");
        // Yaml yaml = new Yaml();
        DumperOptions dumperOptions = new DumperOptions();
        // dumperOptions.setPrettyFlow(true);
        dumperOptions.setDefaultFlowStyle(AUTO);
        Yaml yaml = new Yaml(dumperOptions);
        System.out.println(yaml.dumpAs(inspect, Tag.MAP, null));
    }

}