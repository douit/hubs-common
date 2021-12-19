package com.bluecc.gentool;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.MetaTypes;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.TypeMappers;
import lombok.Builder;
import lombok.Data;

import java.util.Locale;

import static com.bluecc.hubs.fund.TypeMappers.digestMapper;
import static com.bluecc.hubs.fund.Util.prettyYaml;

public class EntityTypesMapper {

    public static void main(String[] args) {
        MetaTypes.types().getEntities().forEach(e -> System.out.println(e));
        System.out.println(MetaTypes.types().getEntities().size());

        ProtoMeta protoMeta=new ProtoMeta();

        String typeEnt="StatusType";
        String typeItemEnt="StatusItem";

        printTypeMappers(typeEnt, typeItemEnt, protoMeta);
        printTypeMappers("", "", protoMeta);
    }

    private static void printTypeMappers(String typeEnt, String typeItemEnt, ProtoMeta protoMeta) {
        // TypeMappers.TypeMapper mapper = digestMapper(typeEnt, protoMeta);
        TypeMappers.TypeMapper mapper = protoMeta.getTypeMapper(typeEnt);
        prettyYaml(mapper);
        prettyYaml(digestMapper(typeItemEnt, protoMeta));
    }

}
