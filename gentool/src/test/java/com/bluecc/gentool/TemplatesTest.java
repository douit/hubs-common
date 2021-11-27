package com.bluecc.gentool;

import com.bluecc.gentool.common.TemplateUtil;
import com.bluecc.hubs.fund.ProtoMeta;
import org.junit.Test;

import java.io.IOException;

public class TemplatesTest {
    @Test
    public void testRender() throws IOException {
        // ProtoMeta protoMeta=new ProtoMeta();
        // protoMeta.getEntityMeta("OrderItem");
        String cnt=TemplateUtil.sourceGen("OrderItem", "dao_sql");
        System.out.println(cnt);
    }
}
