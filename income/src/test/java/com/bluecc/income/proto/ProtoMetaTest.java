package com.bluecc.income.proto;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.*;
import com.bluecc.hubs.fund.InspectMeta.EntityInspect;
import com.bluecc.hubs.stub.*;
import com.bluecc.income.dao.PartyDelegator;
import com.google.common.collect.Maps;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.Util.prettyYaml;
import static com.bluecc.income.exchange.MessageMapCollector.collect;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class ProtoMetaTest {
    @Test
    public void testMetaFields() {
        PersonFlatData flatData = PersonFlatData.newBuilder()
                .setPartyId(Long.toString(System.currentTimeMillis()))
                .setLastName("samlet")
                .setFirstName("wu")
                .build();
        flatData.getAllFields().keySet().forEach(e -> System.out.println(e));

        // Map<Descriptors.FieldDescriptor, Object> allFields = flatData.getAllFields();
        // System.out.println(allFields.keySet().stream().map(f -> f.getName())
        //         .collect(Collectors.toList()));

        System.out.println("-----------");
        collect((c, e) -> {
            System.out.println("Ⓜ️ " + c.getSymbol() + " -> " + e);
        }).fillMap(flatData);

        // new with proto-instance
        PersonFlatData.Builder builder=PersonFlatData.newBuilder(flatData);
        builder.setBirthDate(ProtoTypes.nowDate());
        collect((c, e) -> {
            System.out.println("Ⓜ️ " + c.getSymbol() + " -> " + e);
        }).fillMap(builder.build());
    }

    ProtoMeta protoMeta = new ProtoMeta();

    @Test
    public void testRelationNames() {
        EntityMeta p = protoMeta.getEntityMeta("UserLogin");
        p.getRelations().forEach(r -> System.out.println(r.getProtoName()));
    }

    @Test
    public void testGetRelation(){
        EntityMeta p = protoMeta.getEntityMeta("Product");
        // p.getRelations().forEach(r -> System.out.println(r.getProtoName()));
        EntityMeta.RelationMeta relationMeta=p.findRelation("ProductPrice").get();
        relationMeta.getRelFieldList().forEach(e -> System.out.println(e));

    }

    @Test
    public void testRelations() {

        // EntityMeta c=protoMeta.getEntityMeta("OrderItem");
        // EntityMeta p=protoMeta.getEntityMeta("OrderHeader");

        // userlogin(*) - partystatus(*)
        EntityMeta p = protoMeta.getEntityMeta("UserLogin"); // peer
        EntityMeta c = protoMeta.getEntityMeta("PartyStatus"); // peer
        UserLoginData userLoginData = UserLoginData.newBuilder()
                .setUserLoginId("u_123")
                .setPasswordHint("forget?")
                .build();
        System.out.println(ProtoTypes.getEntityIdenValues(userLoginData));

        PartyStatusData partyStatusData = PartyStatusData.newBuilder().build();
        System.out.println(partyStatusData);

        {
            String slaveFld = "changeByUserLoginId";
            System.out.println(c.getName() + ": " + c.getRelations().stream().map(r ->
                    r.getMainRelField()).collect(Collectors.toSet()));
            c.getRelations().stream().filter(r -> r.getMainRelField().equals(slaveFld))
                    .forEach(r -> System.out.println("flds: " + r.getTargetFieldList()
                            + ", " + r.getRelEntityName()));
        }

        System.out.println();
        {
            String slaveFld = "userLoginId";
            System.out.println(p.getName() + ": " + p.getRelations().stream().map(r ->
                    r.getMainRelField()).collect(Collectors.toSet()));
            p.getRelations().stream().filter(r ->
                            r.getMainRelField().equals(slaveFld)
                                    && r.getRelEntityName().equals(c.getName()))
                    .forEach(r -> System.out.println("flds: " + r.getTargetFieldList()
                            + ", " + r.getRelEntityName()));
        }

        System.out.println();
        c.getRelations().stream().filter(r -> r.getRelEntityName().equals(p.getName()))
                .map(r -> r.getRelFieldList())
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e));
    }

    @Test
    public void testTransferRelations(){
        EntityMeta p = protoMeta.getEntityMeta("UserLogin"); // peer
        EntityMeta c = protoMeta.getEntityMeta("PartyStatus"); // peer
        UserLoginData userLoginData = UserLoginData.newBuilder()
                .setUserLoginId("u_123")
                .setPasswordHint("forget?")
                .build();

        Map<String, Object> values=transferRelations(userLoginData,
                "change_by_party_status", c.getName());
        System.out.println(values);
        assertThat(values).containsKey("change_by_user_login_id");

        OrderHeaderData orderHeaderData= OrderHeaderData.newBuilder()
                .setOrderId("o_444")
                .setOrderName("sales order")
                .build();
        values=transferRelations(orderHeaderData,
                "order_item", "OrderItem");
        System.out.println(values);
        assertThat(values).containsKey("order_id");

        values=transferRelations(orderHeaderData,
                "billing_account", "BillingAccount");
        System.out.println(values.size());
        assertEquals(0, values.size());

        PartyData partyData= PartyData.newBuilder()
                .setPartyId("p_33")
                .build();
        values=transferRelations(partyData,
                "party_group", "PartyGroup");
        System.out.println(values);
        System.out.println(values.size());
    }

    public Map<String, Object> transferRelations(Message from, String relationProtoName, String toEntity) {
        Descriptors.Descriptor descriptor = from.getDescriptorForType();
        String fromEnt = ProtoTypes.getEntityTypeByMessage(from);
        EntityMeta meta = protoMeta.getEntityMeta(fromEnt);
        Map<String, Object> values = Maps.newHashMap();
        meta.getRelations().stream().filter(r ->
                        r.getProtoName().equals(relationProtoName)
                                && r.getRelEntityName().equals(toEntity))
                .forEach(r -> {
                    for (EntityMeta.KeymapMeta keymap : r.getKeymaps()) {
                        Descriptors.FieldDescriptor fldDesc=descriptor.findFieldByName(keymap.getProtoField());
                        if(fldDesc==null){
                            System.out.println("Cannot find "+keymap.getProtoField()+" in "+descriptor.getName());
                        }else {
                            Object val = from.getField(fldDesc);
                            values.put(keymap.getProtoRelField(), val);
                        }
                    }
                });
        return values;
    }

    @Test
    public void testSqlMeta(){
        {
            EntityMeta meta = protoMeta.getEntityMeta("Party");
            System.out.println(meta.getPrefix());
            // c.id cid, c.name cname
            String prefix = meta.getPrefix();
            meta.getColNames("*stamp").stream()
                    .map(f -> String.format("%s.%s %s_%s", prefix, f, prefix, f))
                    .forEach(e -> System.out.println(e));
        }
        // "select "
        //     + "c.id c_id, c.name c_name, "
        //     + "p.id p_id, p.name p_name, p.number p_number "
        //     + "from contacts c left join phones p on c.id = p.contact_id"
        {
            EntityMeta meta = protoMeta.getEntityMeta("PartyContactMech");
            System.out.println(meta.getPrefix());
            String prefix = meta.getPrefix();
            meta.getColNames("*stamp", "party_id").stream()
                    .map(f -> String.format("%s.%s %s_%s", prefix, f, prefix, f))
                    .forEach(e -> System.out.println(e));
        }

        {
            // testSqlMetaBuilder();

        }
    }

    @Test
    public void testSqlMetaBuilder() {
        SqlMeta sqlMeta=protoMeta.getSqlMeta("Party");
        System.out.println(sqlMeta.getAliases());
        System.out.println(sqlMeta.leftJoin(PartyDelegator.PARTY_CONTACT_MECH));
    }

    @Test
    public void testLoadInspectMeta() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        EntityInspect inspectMeta=yaml.loadAs(new FileReader(
                SystemDefs.prependHubsHomeFile("asset/inspect/Product.yml")),
                EntityInspect.class);
        // prettyYaml(inspectMeta);
        inspectMeta.getRelationMarks().stream()
                .filter(r -> !r.getTags().contains("skip"))
                .forEach(r -> System.out.println("incl: "+r));
    }

    @Test
    public void testGetInspectMeta(){
        protoMeta.getInspectMeta("Product")
                .getValidRelationNames()
                .forEach(e -> System.out.println(e));
    }
}
