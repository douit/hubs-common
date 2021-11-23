package com.bluecc.hubs.proto;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.EntityMetaDigester;
import com.bluecc.hubs.fund.EntityMetaManager;
import com.bluecc.hubs.stub.PersonData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;

import java.io.IOException;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.bluecc.hubs.fund.MetaTypes.typeList;

class DataFillTest {

    @Test
    void fillData() throws IOException {
        String entName="Person";
        EntityMeta meta= EntityMetaManager.getEntityMeta(entName, false);
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

}