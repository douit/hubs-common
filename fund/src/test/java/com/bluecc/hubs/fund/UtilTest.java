package com.bluecc.hubs.fund;

import com.google.common.base.CaseFormat;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void snakeToCamel() {
        String words="Scrum Project status";
        // System.out.println(Util.toClassName(words));
        String result=CaseFormat.LOWER_UNDERSCORE.to(
                CaseFormat.UPPER_CAMEL, words.replaceAll(" ", "_"));
        System.out.println(result);
    }

    @Test
    public void testWordsConvert(){
        // System.out.println(Util.wordsToClassName(Util.toSnakecase("Scrum Project status")));
        // System.out.println(Util.wordsToClassName(Util.toSnakecase("ShipmentRouteSegment:CarrierService")));
        assertEquals("ScrumProjectStatus",
                Util.wordsToClassName("Scrum Project status"));
        assertEquals("ShipmentRouteSegmentCarrierService",
                Util.wordsToClassName("ShipmentRouteSegment:CarrierService"));
    }
}