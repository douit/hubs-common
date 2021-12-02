package com.bluecc.income.dao;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.feed.DataFill;
import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.dummy.store.PartiesTest;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.model.Person;
import com.bluecc.income.procs.Parties;
import com.github.javafaker.Faker;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.JsonObject;
import com.google.protobuf.Message;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.bluecc.hubs.fund.SeedReader.collectEntityData;
import static com.bluecc.hubs.fund.Util.pretty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PartyDelegatorTest extends AbstractStoreProcTest {
    @Inject PartyDelegator partyDelegator;

    @Before
    public void setUp() throws Exception {
        // setupEntities("Party");
        setupEntities();
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            PartyFlatData flatData= PartyFlatData.newBuilder()
                    .setPartyId(newId)
                    .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, partyDelegator.create(ctx, flatData));
            assertEquals(1, partyDelegator.update(ctx, flatData));
            assertEquals(1, partyDelegator.find(ctx, flatData).size());
            assertEquals(1, partyDelegator.findById(ctx, flatData).size());
            assertEquals(1, partyDelegator.delete(ctx, flatData));
            assertEquals(0, partyDelegator.find(ctx, flatData).size());
        });
    }


    @Test
    public void storeProtoData(){

        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, sourceSalesOrder, false);

        assertTrue(dataList.get("Party").size()>0);

        DataFill dataFill=new DataFill();
        Multimap<String, Message> dataMap=dataFill.setupData(dataList);

        dataMap.get("Party").forEach(e -> System.out.println(e));

        process(c ->{
            dataMap.get("Party").forEach(e -> {
                System.out.println(e);
                genericProcs.storeOrUpdate(c, e);
            });

            dataMap.asMap().forEach((k,v)->{
                v.forEach(e ->{
                    System.out.println(e);
                    genericProcs.storeOrUpdate(c, e);
                });
            });

            // list

        });
    }


    @Test
    public void testBeanToMessage() {
        process(c -> {
            String id=sequence.nextStringId();
            LocalDate date = LocalDate.of(2001, 2, 1);

            Person data= Person.builder()
                    .partyId(id)
                    .lastName("samlet")
                    .firstName("wu")
                    .birthDate(date)
                    .passportExpireDate(LocalDate.now())
                    .gender('Y')
                    .build();
            genericProcs.create(c, data.toData());

            // for (Person person : dao.listPersons()) {
            //     pretty(person);
            //     PersonFlatData flat=person.toFlatData();
            //     System.out.println("-> flat = "+flat);
            // }
        });
    }
}
