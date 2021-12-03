package com.bluecc.income.exchange;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.stub.Indicator;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.ProductConfigData;
import com.google.protobuf.Descriptors;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
public class FlatMessageCollectorTest {

    Sequence sequence=new Sequence(null);
    @Test
    public void extractFromMessage() {
        String newId=sequence.nextStringId();
        PersonFlatData flatData= PersonFlatData.newBuilder()
                .setPartyId(newId)
                .setLastName("samlet")
                .setFirstName("wu")
                .build();
        FlatMessageCollector.extract(flatData).forEach((k,v)->
                System.out.println(k+": "+v));
        assertThat(FlatMessageCollector.extract(flatData))
                .containsKey("party_id")
                .containsKey("last_name")
                .containsKey("first_name")
                .containsValue(newId);
    }

    @Test
    public void testExtractFromMessage() {
        ProductConfigData prodcfg=getProductConfigData();
        Map<String, Object> rs= FlatMessageCollector.extract(prodcfg);
        System.out.println(rs.keySet());
        assertEquals(1L, rs.get("sequence_num"));

        Map<Descriptors.FieldDescriptor, Object> allFields = prodcfg.getAllFields();
        for (Map.Entry<Descriptors.FieldDescriptor, Object> objectEntry : allFields.entrySet()) {
            Descriptors.FieldDescriptor fld = objectEntry.getKey();
            System.out.println(fld.getName());
        }
    }


    private ProductConfigData getProductConfigData() {
        ProductConfigData productConfigData=ProductConfigData.newBuilder()
                .setProductId("pc001")
                .setConfigItemId("it0003")
                .setSequenceNum(1) // 设置为0时, 则不会保存这个字段
                .setFromDate(ProtoTypes.now())
                .setConfigTypeId("STANDARD")
                .setIsMandatory(Indicator.YES)
                .build();
        return productConfigData;
    }
}