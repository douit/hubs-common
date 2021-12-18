package com.bluecc.gentool;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.ProtoMeta;
import org.junit.Test;

import static org.junit.Assert.*;

public class DartWrapperToolTest {
    ProtoMeta protoMeta=new ProtoMeta();
    @Test
    public void testFieldTemplate(){
        EntityMeta meta=protoMeta.getEntityMeta("ProductPrice");
        System.out.println(meta.getField("price").get().getDartTemplate());
    }
}