package com.bluecc.income.procs;

import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.feed.FactBag;
import com.bluecc.hubs.fund.FnUtil;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.Tuple2;
import com.bluecc.hubs.fund.TypeMappers;
import com.bluecc.hubs.stub.*;
import com.bluecc.income.GuiceTestRunner;
import com.google.common.collect.Maps;
import com.google.protobuf.Descriptors;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.FnUtil.wrap;
import static com.bluecc.hubs.fund.TypeMappers.digestMapper;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceTestRunner.class)
public class TypeEntityProcsTest {
    @Inject
    TypeEntityProcs typeEntityProcs;
    @Inject
    StatusTypes statusTypes;
    @Inject
    FactBag factBag;
    @Inject
    ProtoMeta protoMeta;

    @Test
    public void getEntityData() throws InvalidProtocolBufferException {
        CustRequestTypeData.Builder custReqType = CustRequestTypeData.newBuilder();
        typeEntityProcs.factBag.getEntityData("RF_BUGFIX", custReqType);
        CustRequestTypeData data = custReqType.build();
        System.out.println(data);
        assertEquals("Request For Bug Fix", data.getDescription());
    }

    @Test
    public void getEnumeration() throws InvalidProtocolBufferException {
        EnumerationData.Builder typeBuilder = EnumerationData.newBuilder();
        typeEntityProcs.factBag.getEntityData("WEB_SALES_CHANNEL", typeBuilder);
        EnumerationData data = typeBuilder.build();
        System.out.println(data);
        assertEquals("Web Channel", data.getDescription());
        assertEquals("ORDER_SALES_CHANNEL", data.getEnumTypeId());

    }

    @Test
    public void getAll() {
        typeEntityProcs.factBag.all("StatusType").forEach((k, v) -> {
            try {
                StatusTypeData d = StatusTypeData.parseFrom(v);
                System.out.println(k + ": " + d);
            } catch (InvalidProtocolBufferException e) {
                fail(e.getMessage());
            }
        });


        FnUtil.CheckedFunction<byte[], StatusTypeData> parseFn = StatusTypeData::parseFrom;
        List<StatusTypeData> ds = typeEntityProcs.factBag.all("StatusType")
                .readAllMap()
                .values().stream()
                // .map(wrap(bytes -> StatusTypeData.parseFrom(bytes)))
                .map(wrap(parseFn))
                .collect(Collectors.toList());
        System.out.println(ds.size());
        // Flux.fromIterable(typeEntityProcs.factBag.all("StatusType").readAllMap()
        //                 .values())
        //         .map(bytes -> StatusTypeData.parseFrom(bytes))
        //         .oner
    }

    @Test
    public void testAllTypes() {
        FactBag types = typeEntityProcs.factBag;
        List<StatusTypeData> ds = types.allTypes("StatusType", StatusTypeData::parseFrom);
        System.out.println(ds.size());
        ds.forEach(e -> System.out.println(e.getDescription()));
    }

    @Test
    public void testStatusItems() {
        FactBag types = typeEntityProcs.factBag;
        String statusTypeId = "ORDER_ITEM_STATUS";
        types.allTypes("StatusItem", StatusItemData::parseFrom)
                .stream().filter(e -> e.getStatusTypeId().equals(statusTypeId))
                .map(e -> e.getStatusId())
                .collect(Collectors.toList())
                .forEach(t -> System.out.println(t));

        String statusId = "ORDER_CREATED";
        System.out.format("from %s to:\n", statusId);
        types.allTypes("StatusValidChange", StatusValidChangeData::parseFrom)
                .stream().filter(e -> e.getStatusId().equals(statusId))
                .map(e -> e.getStatusIdTo())
                .collect(Collectors.toSet())
                .forEach(e -> System.out.println("\t-> " + e));

        String statusIdTo = "ORDER_PROCESSING";
        Optional<String> transName = statusTypes.getTransitionName(statusId, statusIdTo);
        assertTrue(transName.isPresent());
        assertEquals("Process Order", transName.get());

        transName = statusTypes.getTransitionName(statusId, "ORDER_CREATED");
        assertFalse(transName.isPresent());
    }

    @Test
    public void getAllEnumerationIds() throws InvalidProtocolBufferException {
        assertThat(typeEntityProcs.getAllEnumerationIds("ORDER_SALES_CHANNEL").stream()
                // .peek(e -> System.out.println(e))
                .map(t -> t.f0)
                .collect(Collectors.toSet()))
                .contains("WEB_SALES_CHANNEL");

        assertThat(typeEntityProcs.getAllEnumerationIdsBySample("PHONE_SALES_CHANNEL").stream()
                .peek(e -> System.out.println(e))
                .map(t -> t.f0)
                .collect(Collectors.toSet()))
                .contains("WEB_SALES_CHANNEL");
    }

    @Test
    public void testTypeAndItems() {
        String typeName = "StatusType";

        // types
        List<SeedType> seedTypes = getStatusType(typeName).stream().map(e -> {
            System.out.format("%s -> %d\n", e.f0.getStatusTypeId(), e.f1.size());
            SeedType seedType = SeedType.newBuilder()
                    .setTypeId(e.f0.getStatusTypeId())
                    .setParentTypeId(e.f0.getParentTypeId())
                    .setDescription(e.f0.getDescription())
                    .putAllItems(convertItems(e.f1))
                    .build();
            return seedType;
        }).collect(Collectors.toList());

        seedTypes.forEach(e -> System.out.println(e));
    }

    // convert items
    private Map<String, SeedTypeItem> convertItems(List<StatusItemData> items) {
        Map<String, SeedTypeItem> result = Maps.newHashMap();
        items.forEach(item -> {
            result.put(item.getStatusId(), SeedTypeItem.newBuilder()
                    .setItemId(item.getStatusId())
                    .setDescription(item.getDescription())
                    .setItemTypeId(item.getStatusTypeId())
                    .build());
        });
        return result;
    }

    // type
    private List<Tuple2<StatusTypeData, List<StatusItemData>>> getStatusType(String typeName) {
        return factBag.allTypes(typeName, StatusTypeData::parseFrom)
                .stream()
                .map(e -> Tuple2.of(e, getStatusItems(e.getStatusTypeId())))
                .collect(Collectors.toList());
    }

    // items
    private List<StatusItemData> getStatusItems(String typeId) {
        List<StatusItemData> items = factBag.allTypes("StatusItem", StatusItemData::parseFrom)
                .stream().filter(e -> e.getStatusTypeId().equals(typeId))
                .collect(Collectors.toList());
        return items;
    }

    // ------------

    @Test
    public void testConvertTypeMappers() {
        String typeName = "ContactMechType";
        List<SeedType> seedTypes = factBag.allTypes(typeName, ContactMechTypeData::parseFrom)
                .stream()
                .peek(e -> System.out.println(e))
                .map(e -> mapBy(typeName, e))
                .collect(Collectors.toList());

        seedTypes.forEach(e -> {
            System.out.println(e);
        });

        // factBag.allTypes("StatusItem", StatusItemData::parseFrom)
        //         .stream()
        //         .peek(e -> System.out.println(e))
        //         .collect(Collectors.toList());
    }

    @Test
    public void testQueryTypeMapper(){
        System.out.println(protoMeta.getTypeMapper("ContactMechType"));
        System.out.println(digestMapper("ContactMechType", protoMeta));
    }


    private SeedType mapBy(String typeName, Message e) {
        TypeMappers.TypeMapper typeMapper = protoMeta.getTypeMapper(typeName);
        // TypeMappers.TypeMapper itemTypeMapper=protoMeta.getTypeMapper(itemTypeName);
        Descriptors.Descriptor descriptor = e.getDescriptorForType();
        System.out.println(typeMapper);
        String idFld=typeMapper.getIdField();
        System.out.println("id fld: "+idFld);
        Object val = e.getField(descriptor.findFieldByName(idFld));
        String descFld=typeMapper.getDescriptionField();
        String description="";
        if(descFld!=null){
            description=(String)e.getField(descriptor.findFieldByName(idFld));
        }
        String parent=typeMapper.getParentField()==null?""
                :(String)e.getField(descriptor.findFieldByName(typeMapper.getParentField()));
        return SeedType.newBuilder()
                .setTypeId(val.toString())
                .setParentTypeId(parent)
                .setDescription(description)
                .build();
    }

    @Test
    public void testShoppingListType(){
        List<ShoppingListTypeData> items =
                factBag.allTypes("ShoppingListType", ShoppingListTypeData::parseFrom);
        // items.forEach(e -> System.out.println(e));
        items.forEach(e -> System.out.println(ProtoJsonUtils.toJson(e)));

        // testSerializeType();
    }

    @Test
    public void testSerializeType() {
        String typeName="ShoppingListType";
        String result;
        switch (typeName){
            case "ShoppingListType":
                result= quoteList(factBag.allTypes("ShoppingListType", ShoppingListTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            default:
                result="[]";
                break;
        }

        System.out.println(result);
    }

    static String quoteList(String jsonLines){
        return String.format("[%s]", jsonLines);
    }
}

