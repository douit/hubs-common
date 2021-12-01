package com.bluecc.income.types;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.stub.OrderItemData;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import lombok.Data;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.bluecc.hubs.fund.Util.pretty;
import static com.bluecc.hubs.feed.ProtoModule.startup;

public class WideTables {
    @Data
    static class WideTableConf{
        String head;
        List<String> embed;
        Map<String, Object> details;
    }

    public static void main(String[] args) throws IOException {
        WideTableConf tableConf=Util.readJson(WideTableConf.class,
                WideTableConf.class.getResourceAsStream("/data/order_item_simple.meta"));
        pretty(tableConf);

        WideTables wideTables=startup(WideTables.class);
        wideTables.printFields(tableConf.head);

        OrderItemData orderItemData= OrderItemData.newBuilder().build();
        wideTables.printFields(orderItemData);

        Descriptors.Descriptor descriptor= orderItemData.getDescriptorForType();
        tableConf.embed.forEach(e -> {
            Descriptors.Descriptor fieldDesc=descriptor.findFieldByName(e).getMessageType();
            wideTables.printFields(fieldDesc);
        });

        tableConf.details.forEach((k,v)->{
            System.out.println(k+": "+v.getClass().getName());

            Descriptors.Descriptor fieldDesc=descriptor.findFieldByName(k).getMessageType();
            wideTables.printKeys(fieldDesc);

        });
    }

    @Inject
    ProtoMeta protoMeta;
    void printFields(String ent){
        protoMeta.getEntityMeta(ent).getFields().forEach(f ->
                System.out.println("- "+f.getName()));
    }

    void printFields(Message message){
        message.getDescriptorForType().getFields().forEach(f->{
            System.out.println("+ "+f.getName());
        });
    }

    void printFields(Descriptors.Descriptor descriptor){
        descriptor.getFields().forEach(f->{
            System.out.format("+ %s.%s\n", descriptor.getName(), f.getName());
        });
    }

    void printKeys(Descriptors.Descriptor descriptor){
        System.out.println(Arrays.toString(ProtoTypes.getEntityKeys(descriptor)));
    }
}
