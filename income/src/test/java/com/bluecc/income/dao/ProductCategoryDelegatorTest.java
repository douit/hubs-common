package com.bluecc.income.dao;

import com.bluecc.hubs.fund.Tuple2;
import com.bluecc.hubs.stub.ProductCategoryFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.model.Product;
import com.bluecc.income.model.ProductCategory;
import com.github.javafaker.Faker;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import lombok.NonNull;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindList;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class ProductCategoryDelegatorTest extends AbstractStoreProcTest {
    @Inject
    ProductCategoryDelegator productCategorys;

    @Before
    public void setUp() throws Exception {
        setupEntities("ProductCategory");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId = sequence.nextStringId();
            ProductCategoryFlatData flatData = ProductCategoryFlatData.newBuilder()
                    .setProductCategoryId(newId)
                    .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, productCategorys.create(ctx, flatData));
            assertEquals(1, productCategorys.update(ctx, flatData));
            assertEquals(1, productCategorys.find(ctx, flatData).size());
            assertEquals(1, productCategorys.findById(ctx, flatData).size());
            assertEquals(1, productCategorys.delete(ctx, flatData));
            assertEquals(0, productCategorys.find(ctx, flatData).size());
        });
    }

    @Test
    public void testQueryChildren() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            // child - child - product
            List<String> pids = productCategorys.getAgent(c, "HotelFac")
                    .getPrimaryChildProductCategory().stream()
                    .peek(cpc -> System.out.println("child: " + cpc.getProductCategoryId()))
                    .map(cpc -> cpc.agent(c, productCategorys).getPrimaryProduct())
                    .flatMap(el -> el.stream())
                    .map(pp -> pp.getProductId())
                    .collect(Collectors.toList());
            System.out.println("*** products: " + pids);
            assertThat(pids).contains("RoomLarge", "RoomLux", "RoomStd");

            // child - child - category
            pids = productCategorys.getAgent(c, "RentBrowseRoot")
                    .getPrimaryChildProductCategory().stream()
                    .peek(cpc -> System.out.println("child: " + cpc.getProductCategoryId()))
                    .map(cpc -> cpc.agent(c, productCategorys).getPrimaryChildProductCategory())
                    .flatMap(el -> el.stream())
                    .map(pp -> pp.getProductCategoryId())
                    .collect(Collectors.toList());
            System.out.println(pids);
            assertThat(pids).contains("MotorBoats", "RowBoats", "SailBoats");
        });
    }

    @Inject
    ProductDelegator productDelegator;
    @Inject
    ProductCategoryRollupDelegator productCategoryRollupDelegator;
    @Inject
    ProductCategoryDelegator productCategoryDelegator;

    @Test
    public void testRollup() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            List<ProductCategory> cats = productDelegator.getAgent(c, "RoomStd").getPrimaryProductCategory();
            System.out.println(cats);
            List<String> cids = cats.stream().map(cat -> cat.agent(c, productCategorys).getPrimaryParentProductCategory())
                    .flatMap(el -> el.stream())
                    .peek(e -> System.out.println("parent: " + e))
                    .map(pcr -> pcr.agent(c, productCategoryDelegator).getPrimaryParentProductCategory())
                    .flatMap(el -> el.stream())
                    .peek(pc -> System.out.format("%s - %s\n", pc.getProductCategoryId(),
                            pc.getPrimaryParentCategoryId()))
                    .peek(pc -> {
                        assertNull(pc.getPrimaryParentCategoryId());
                    })
                    .map(pc -> pc.getProductCategoryId())
                    .collect(Collectors.toList());
            System.out.println(cids);
        });
    }


    @Test
    public void testAllCatRollups() {
        process(c -> {
            printCatRollups(c);
            // printCatMembers(c);
        });
    }

    private void printCatRollups(IProc.ProcContext ctx) {
        ProductCategoryDelegator.Dao dao = ctx.getHandle()
                .attach(ProductCategoryDelegator.Dao.class);
        List<ProductCategory> rollupList = dao.listProductCategory();
        rollupList.stream()
                // .peek(e -> pretty(e))
                .map(roll -> {
                    return Tuple2.of(roll.getProductCategoryId(), rollupList.stream().filter(
                                    c -> c.getPrimaryParentCategoryId() != null
                                            && c.getPrimaryParentCategoryId().equals(roll.getProductCategoryId()))
                            .map(c -> c.getProductCategoryId())
                            .collect(Collectors.toList()));
                }).collect(Collectors.toList())
                .forEach(e -> System.out.println(e));
    }

    @RegisterBeanMapper(Product.class)
    public interface RelatedProductDao {
        // by primaryProductCategoryId
        @SqlQuery("select * from product where primary_product_category_id in (<cats>)")
        List<Product> list(@BindList("cats") List<String> cats);
    }

    @Test
    public void testTreeTraverse() {
        process(ctx -> {
            // Dao dao = c.getHandle().attach(Dao.class);
            ProductCategoryDelegator.Dao dao = ctx.getHandle()
                    .attach(ProductCategoryDelegator.Dao.class);
            List<ProductCategory> rollupList = dao.listProductCategory();
            // TreeTraverser<ProductCategory> typeTraverser = new TreeTraverser<ProductCategory>() {
            // com.google.common.graph.Traverser<ProductCategory> categoryTraverse=new


            List<Tuple2<String, List<String>>> rs=rollupList.stream()
                    // .peek(e -> pretty(e))
                    .map(roll -> {
                        return Tuple2.of(roll.getProductCategoryId(), rollupList.stream().filter(
                                        c -> c.getPrimaryParentCategoryId() != null
                                                && c.getPrimaryParentCategoryId().equals(roll.getProductCategoryId()))
                                .map(c -> c.getProductCategoryId())
                                .collect(Collectors.toList()));
                    }).collect(Collectors.toList());

            // build tree
            SuccessorsFunction<String> tree = createDirectedGraph(rs);
            Traverser<String> traverser = Traverser.forGraph(tree);

            // query tree
            traverser.breadthFirst(Lists.newArrayList("BoatRental", "CATALOG1"))
                    .forEach(e -> System.out.println("- "+e));
            assertThat(traverser.breadthFirst(Lists.newArrayList("BoatRental")))
                    .contains("RowBoats", "MotorBoats");

            // query related products
            System.out.println("----------");
            traverser.breadthFirst("HotelFac")
                    .forEach(e -> System.out.println(e));
            RelatedProductDao relatedProductDao=ctx.getHandle().attach(RelatedProductDao.class);
            List<String> catIds = new ArrayList<String>();
            traverser.breadthFirst("HotelFac").forEach(catIds::add);
            assertThat(relatedProductDao.list(catIds).stream()
                    .peek(e -> System.out.println(e.getProductId()))
                    .map(p -> p.getProductId())
                    .collect(Collectors.toList()))
                    .contains("RoomLarge", "RoomLux", "RoomStd");
        });
    }

    private static SuccessorsFunction<String> createDirectedGraph(List<Tuple2<String, List<String>>> edges) {
        return createGraph(/* directed = */ true, edges);
    }
    private static SuccessorsFunction<String> createGraph(boolean directed, List<Tuple2<String, List<String>>>  edges) {
        ImmutableMultimap.Builder<String, String> graphMapBuilder = ImmutableMultimap.builder();
        for (Tuple2<String, List<String>> edge : edges) {
            String node1 = edge.f0;
            edge.f1.forEach(node2 ->{
                graphMapBuilder.put(node1, node2);
                if (!directed) {
                    graphMapBuilder.put(node2, node1);
                }
            });

        }
        final ImmutableMultimap<String, String> graphMap = graphMapBuilder.build();

        return new SuccessorsFunction<String>() {
            @Override
            public Iterable<? extends String> successors(String node) {
                checkArgument(
                        graphMap.containsKey(node) || graphMap.containsValue(node),
                        "Node %s is not an element of this graph",
                        node);
                return Ordering.natural().immutableSortedCopy(graphMap.get(node));
            }
        };
    }

    @Test
    public void testAll() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            System.out.println(productCategoryDelegator.all(c).stream()
                    // .peek(r -> System.out.println(r.getProductCategoryId()))
                    .filter(p -> "HotelFac".equals(p.getPrimaryParentCategoryId()))
                    .map(cat -> cat.getProductCategoryId())
                    .collect(Collectors.toList()));
        });
    }
    @Test
    public void testCache() {
        process(c -> {

            // Dao dao = c.getHandle().attach(// Dao.class);
            CacheLoader<String, List<String>> loader;
            loader = new CacheLoader<String, List<String>>() {
                @Override
                public List<String> load(@NonNull String key) {
                    return productCategoryDelegator.all(c).stream()
                            .filter(p -> key.equals(p.getPrimaryParentCategoryId()))
                            .map(cat -> cat.getProductCategoryId())
                            .collect(Collectors.toList());
                }
            };

            LoadingCache<String, List<String>> cache;
            cache = CacheBuilder.newBuilder().build(loader);

            assertEquals(0, cache.size());
            assertTrue(cache.getUnchecked("HotelFac").size()>0);
            assertEquals(1, cache.size());
        });
    }
}
