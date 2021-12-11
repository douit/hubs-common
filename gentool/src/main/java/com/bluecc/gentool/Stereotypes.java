package com.bluecc.gentool;

import com.bluecc.hubs.fund.EntityMeta;
import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Slf4j
public class Stereotypes {

    @Data
    @Builder
    public static class Stereotype {
        EntityMeta meta;
        @Singular
        Map<String, StField> fields;
        String constName;

        public Collection<StField> getFieldList() {
            return fields.values();
        }
    }

    @Data
    @Builder
    public static class StField {
        EntityMeta.FieldMeta meta;
        Object value;
    }

    public static Stereotype convertToStereotype(JsonObject jo, EntityMeta meta, Set<String> idSet) {

        // String keyValues = getKeyValue(jo, meta);
        String keyValues = getFullConstName(jo, meta);
        if (idSet.contains(keyValues)) {
            log.warn("exists key {}, skip the {} data", keyValues, meta.getName());
            return null;  // skip the data with a same key
        }

        idSet.add(keyValues);
        Stereotype.StereotypeBuilder builder = Stereotype.builder().meta(meta);
        builder.constName(keyValues);

        for (String k : jo.keySet()) {
            Optional<EntityMeta.FieldMeta> fld = meta.getField(k);
            if (fld.isPresent()) {
                builder.field(k, StField.builder().meta(fld.get())
                        .value(jo.get(k).getAsString())
                        .build());
            } else {
                log.warn("ignore invalid field {} for entity {}", k, meta.getName());
            }
        }
        return builder.build();
    }

    public static String getFullConstName(JsonObject jo, EntityMeta meta) {
        return format("%s_%s", meta.getName(), getKeyValue(jo, meta));
    }

    private static String getKeyValue(JsonObject jo, EntityMeta meta) {
        return meta.getPks().stream()
                .map(p -> fixSymbolValue(jo.get(p).getAsString(),
                        meta.getField(p).get()))
                .collect(Collectors.joining("_"));
    }

    private static String fixSymbolValue(String valStr, EntityMeta.FieldMeta fieldMeta) {
        if (fieldMeta.isDateTimeField()) {
            return "";
        }
        return valStr.replaceAll("[ \\-:./+]", "_");
    }


    public static String getCapName(String dataFile) {
        File file = new File(dataFile);
        return getCapName(file);
    }

    public static String getCapName(File file) {
        String name = file.getName().replace(".xml", "");
        // return name.contains("_") ? Util.snakeToCamel(name)
        //         : name.replaceAll("[\\-]", "");
        //
        return name.replaceAll("[\\-]", "");
    }
}
