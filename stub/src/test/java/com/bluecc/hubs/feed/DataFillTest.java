package com.bluecc.hubs.feed;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.EntityMetaDigester;
import com.bluecc.hubs.fund.EntityMetaManager;
import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.stub.PersonData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.JsonObject;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;

import java.io.IOException;
import java.util.Locale;

import com.google.protobuf.Message;
import org.junit.Test;

import static com.bluecc.hubs.fund.SeedReader.collectEntityData;
import static org.junit.Assert.*;
import static com.bluecc.hubs.fund.MetaTypes.typeList;

public class DataFillTest {

    @Test
    public void fillData() throws IOException {
        String entName="Person";
        EntityMeta meta= EntityMetaManager.readEntityMeta(entName);
        EntityMetaDigester digester=new EntityMetaDigester(meta, typeList);

        // setup the entity-meta-info
        // processRelations(meta);

        // DataFill dataFill=new DataFill(PersonData.getDescriptor(), meta);
        PersonData.getDescriptor().getFields().forEach(f -> {
            System.out.format("[%s] %s(%s) %s = %d\n",
                    f.isRepeated()?"+":"-",
                    f.getType().toString().toLowerCase(Locale.ROOT),
                    f.getType()== Type.MESSAGE?f.getMessageType().getName():"*",
                    f.getName(), f.getNumber());
        });

        PersonFlatData.Builder person=PersonFlatData.newBuilder();
        // person.setField()
    }

    @Test
    public void getSeedData(){
        String source= SystemDefs.prependHubsHome( "dataset/sample/sales_order.xml");
        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, source, false);
        assertTrue(dataList.get("Party").size()>0);
    }

    @Test
    public void getSeedProtoData(){
        String source= SystemDefs.prependHubsHome( "dataset/sample/sales_order.xml");
        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, source, false);
        assertTrue(dataList.get("Party").size()>0);

        DataFill dataFill=new DataFill();
        Multimap<String, Message> dataMap=dataFill.setupData(dataList);
        dataMap.get("Party").forEach(e -> System.out.println(e));
    }
}