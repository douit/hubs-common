package com.bluecc.hubs.feed;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetConverter {
    public void convertData(GeneratedMessageV3.Builder<?> msg, ResultSet rs, Descriptors.Descriptor descriptor) throws SQLException {
        for (Descriptors.FieldDescriptor fld : descriptor.getFields()) {
            Object val = rs.getObject(fld.getName());
            // System.out.format("\t%s = %s\n", fld.getName(), val==null?"_":val.getAsString());
            if (val != null) {
                switch (fld.getType()) {
                    // scalar types
                    case STRING:
                    case INT64:
                    case INT32:
                    case DOUBLE:
                    case FLOAT:
                        msg.setField(fld, val);
                        break;
                    case BYTES:
                        msg.setField(fld, val);
                        break;
                    // case MESSAGE:
                    //     setFieldWithMessage(entityName, msg, fld, val);
                    //     break;
                    // case ENUM:
                    //     setFieldWithEnum(msg, fld, val);
                    //     break;

                    default:
                        throw new RuntimeException("Cannot handle type: "
                                + fld.getType() + ", for field "
                                + fld.getName());
                }
            }
        }
    }
}
