package com.bluecc.income.procs;

import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.cli.DataDumper;
import com.bluecc.income.dao.ProductDelegator;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.Util.pretty;
import static com.bluecc.hubs.fund.Util.prettyFull;
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

    @Inject
    ProductDelegator productDelegator;

    @Test
    public void testProductDetailsInCatalog() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            assertThat(catalogs.getProductsInCatalog(c, "HotelFac")
                    .stream()
                    .peek(p -> System.out.println(p)))
                    .contains("RoomLarge", "RoomLux", "RoomStd");

            System.out.println(protoMeta.getInspectMeta("Product").getValidRelationNames());

            DataDumper.dumpJson("productsInCatalog",
                    productDelegator.chainQuery(c, "where pr.product_id in (<ids>)",
                                    SelectorBindings.stringList("ids", catalogs.getProductsInCatalog(c, "HotelFac")),
                                    protoMeta.getInspectMeta("Product").getValidRelationNames())
                            .entrySet().stream().peek(entry -> {
                                System.out.println(entry.getKey() + " ==> ");
                                prettyFull(entry.getValue());
                                // System.out.println(value.getRelProductPrice());
                            })
                            .map(entry -> entry.getValue())
                            .collect(Collectors.toList())
            );

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