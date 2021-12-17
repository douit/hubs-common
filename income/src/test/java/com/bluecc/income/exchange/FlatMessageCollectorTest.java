package com.bluecc.income.exchange;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.stub.*;
import com.bluecc.income.model.OrderHeader;
import com.google.common.base.CaseFormat;
import com.google.protobuf.Descriptors;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.Arrays;
import java.util.Map;

import static com.bluecc.hubs.ProtoTypes.*;
import static com.bluecc.hubs.ProtoTypes.getCurrency;
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

    @Test
    public void testExtractMessageToXml() throws ParserConfigurationException {
        ProductConfigData prodcfg = getProductConfigData();
        Map<String, Object> rs = FlatMessageCollector.extract(prodcfg);
        System.out.println(rs.keySet());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element element = doc.createElement("ProductConfig");
        rs.forEach((k,v)-> element.setAttribute(CaseFormat.LOWER_UNDERSCORE.
                to(CaseFormat.LOWER_CAMEL, k), v.toString()));
        // System.out.println(element.toString());
        assertEquals("STANDARD", element.getAttribute("configTypeId"));

        // ....
        doc=FlatMessageCollector.toXmlDocument(Arrays.asList(prodcfg));
        // System.out.println(doc);
        assertEquals(1, Util.childElements(doc.getDocumentElement()).size());
        assertEquals("STANDARD", Util.childElements(doc.getDocumentElement())
                .get(0).getAttribute("configTypeId"));
    }

}