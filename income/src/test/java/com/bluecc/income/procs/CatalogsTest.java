package com.bluecc.income.procs;

import com.bluecc.income.AbstractStoreProcTest;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CatalogsTest extends AbstractStoreProcTest {
    @Inject
    Catalogs catalogs;

    @Before
    public void setUp() throws Exception {
        setupEntities();
    }

    @Test
    public void testProductsInCatalog() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            assertThat(catalogs.getProductsInCatalog(c, "HotelFac")
                    .stream()
                    .peek(p -> System.out.println(p)))
                    .contains("RoomLarge", "RoomLux", "RoomStd");
        });
    }

    @Test
    public void testCatalog() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            catalogs.catalogTree(c, "BoatRental")
                            .forEach(e -> System.out.println(e));
            assertThat(catalogs.catalogTree(c, "BoatRental"))
                    .contains("RowBoats", "MotorBoats");

        });
    }
}