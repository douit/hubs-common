package com.bluecc.income.dummy.util;

import com.bluecc.hubs.stub.ShipmentData;
import com.google.common.collect.Maps;
import com.google.protobuf.Message;
import org.junit.Test;
import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.Map;

import static com.bluecc.income.exchange.ResourceHelper.readResource;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MVELTest {
    @Test
    public void testMVEL(){
        String expression = "a == empty && b == empty";
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("a", "");
        paramMap.put("b", null);
        Object object = MVEL.eval(expression, paramMap);
        System.out.println(object); // true
        assertTrue((boolean)object);
    }

    @Test
    public void testEvalMessage(){
        // MVEL在为类型变量赋值时提供了自动类型转换（如果可能的话）
        String expression="shipmentId == 's_1' && estimatedShipCost.value > 5";
        Message msg=readResource("shipment_simple",
                ShipmentData.newBuilder())
                .build();
        Object object = MVEL.eval(expression, msg);
        assertTrue((boolean)object);

        expression="shipmentId == 's_1' && estimatedShipCost.value > 19";
        object = MVEL.eval(expression, msg);
        assertFalse((boolean)object);

        Serializable compiledExpression= MVEL.compileExpression(expression);
        object = MVEL.executeExpression(compiledExpression, msg);
        assertFalse((boolean)object);
    }


}

/*
"(age > 10 && age <= 20) || age == 11 ";
"name contains(\"张\")";
"mobile.startsWith(136)";
"foo == null ; foo1 == nil; foo2 == empty";
// 多个表达式时，只有最后一个表达式的结果为返回
"age > 20; sex == 1; name contains(\"张2\")";
"a = 10;b = (a = a * 2) + 10; a;";
 */