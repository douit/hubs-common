package com.bluecc.hubs.fund.descriptor;

import com.bluecc.hubs.fund.ProtoMeta;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class EntitySummariesTest {

    @Test
    public void load() throws FileNotFoundException {
        Optional<EntitySummaries.CommonUse> commonUse = EntitySummaries.load().getCommonUses()
                .stream().filter(c -> c.entity.equals("Product")).findFirst();
        assertTrue(commonUse.isPresent());
        System.out.println(commonUse.get().getFields());
    }

    @Test
    public void testInProtoMeta() {
        ProtoMeta protoMeta = new ProtoMeta();
        assertThat(protoMeta.getEntityMeta("Product").getCommonUseFields()
                .stream()
                .peek(e -> System.out.println(e)).collect(Collectors.toList()))
                .contains("productId", "description");
    }
}