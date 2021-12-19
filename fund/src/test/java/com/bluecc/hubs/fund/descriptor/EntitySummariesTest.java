package com.bluecc.hubs.fund.descriptor;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Optional;

import static org.junit.Assert.*;

public class EntitySummariesTest {

    @Test
    public void load() throws FileNotFoundException {
        Optional<EntitySummaries.CommonUse> commonUse = EntitySummaries.load().getCommonUses()
                .stream().filter(c -> c.entity.equals("Product")).findFirst();
        assertTrue(commonUse.isPresent());
        System.out.println(commonUse.get().getFields());
    }
}