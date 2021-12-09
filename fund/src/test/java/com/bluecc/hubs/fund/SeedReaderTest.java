package com.bluecc.hubs.fund;

import com.google.gson.JsonObject;
import org.junit.Test;
import org.w3c.dom.Element;

import java.util.List;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.junit.Assert.*;

public class SeedReaderTest {

    @Test
    public void convertElement() {
        List<Element> rs=Util.allElements(SystemDefs.prependHubsHome(
                "dataset/sample/SampleWithChildElements.xml"), null);
        rs.forEach(e ->{
            List<Element> children=Util.childElements(e, null);
            children.forEach(c -> System.out.println(c.getTagName()+" - "+c.getTextContent()));
            JsonObject jo=SeedReader.convertElement(e, true);
            pretty(jo);
        });

    }
}