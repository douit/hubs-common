package com.bluecc.income.procs;

import com.bluecc.hubs.stub.PersonFlatData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.protobuf.Message;
import org.junit.Test;

import java.lang.reflect.Type;

import static org.junit.Assert.*;

public class ServiceManagerTest {

    @Test
    public void fireOne() {

    }

    @Test
    public void testTypeRef() throws NoSuchMethodException {
        TypeReference<String> token1=new TypeReference<String>(){};
        TypeReference<Message> token2=new TypeReference<Message>(){};
        TypeReference<PersonFlatData> token3=new TypeReference<PersonFlatData>(){};

        Type type=ServiceManagerTest.class.getMethod("aMethod").getGenericReturnType();
        assertSame(type, token2.getType());
        assertNotSame(type, token1.getType());

        Type superType=PersonFlatData.class.getGenericSuperclass();
        System.out.println(superType);
        System.out.println(token3.getType().getTypeName());
        // System.out.println(token2.getClass().getName());

    }

    public Message aMethod(){
        return null;
    }
}