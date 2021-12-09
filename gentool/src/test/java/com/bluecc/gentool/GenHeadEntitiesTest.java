package com.bluecc.gentool;

import com.bluecc.hubs.fund.HeadEntityResources;
import com.bluecc.hubs.fund.MetaTypes;
import org.junit.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.*;

public class GenHeadEntitiesTest {

    @Test
    public void genBean() {
        Set<String> ents=MetaTypes.getAllEntitiesCopy();
        System.out.println(ents.size());
        ents.removeAll(HeadEntityResources.allHeads());
        System.out.println(ents.size());
    }

    @Test
    public void genConvHeader() throws IOException {
        String cnt=new GenHeadEntities(new GenConfig()).genHeadPart("ProductStore");
        System.out.println(cnt);
    }
}