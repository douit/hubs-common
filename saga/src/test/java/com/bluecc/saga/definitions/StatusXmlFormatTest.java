package com.bluecc.saga.definitions;

import com.bluecc.gentool.SeedScanner;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.income.exchange.FlatMessageCollector;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Arrays;

import static com.bluecc.hubs.ProtoTypes.castIndicator;
import static org.junit.Assert.assertEquals;

public class StatusXmlFormatTest {
    public final static StatusTypeData StatusType_ORDER_STATUS = StatusTypeData.newBuilder()
            .setDescription("Order")
            .setHasTable(castIndicator("N"))
            .setStatusTypeId("ORDER_STATUS")
            .build();

    @Test
    public void testStatusDataToXml() throws ParserConfigurationException {
        Document doc= FlatMessageCollector.toXmlDocument(Arrays.asList(StatusType_ORDER_STATUS));

        // System.out.println(doc);
        assertEquals(1, Util.childElements(doc.getDocumentElement()).size());
        assertEquals("ORDER_STATUS", Util.childElements(doc.getDocumentElement())
                .get(0).getAttribute("statusTypeId"));

        SeedScanner scanner=new SeedScanner();
        Util.childElements(doc.getDocumentElement()).forEach(e -> scanner.processElement(e));
        scanner.setupChanges();
        scanner.printStatus();
    }
}
