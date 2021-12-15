package com.bluecc.income.procs;

import com.bluecc.hubs.fund.Tuple2;
import com.bluecc.income.dao.ProdCatalogDelegator;
import com.bluecc.income.dao.ProductCategoryDelegator;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.model.Product;
import com.bluecc.income.model.ProductCategory;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindList;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;

public class Catalogs extends ProdCatalogDelegator {
    // @Data
    // public static class CatWrapper implements IModel<StringValue.Builder> {
    //     StringValue cat;
    //     CatWrapper(String cat){
    //         this.cat=StringValue.of(cat);
    //
    //     }
    //     @Override
    //     public StringValue toData() {
    //         return cat;
    //     }
    //
    //     @Override
    //     public StringValue.Builder toDataBuilder() {
    //         return null;
    //     }
    // }
    @RegisterBeanMapper(Product.class)
    public interface RelatedProductDao {
        // by primaryProductCategoryId
        @SqlQuery("select * from product where primary_product_category_id in (<cats>)")
        List<Product> list(@BindList("cats") List<String> cats);
    }

    // CacheLoader<String, List<Tuple2<String, List<String>>>> loader;
    public Iterable<String> catalogTree(IProc.ProcContext ctx, String... cats) {
        Traverser<String> traverser = catalogTraverser(ctx);

        // query tree
        // traverser.breadthFirst(Lists.newArrayList("BoatRental", "CATALOG1"))
        //         .forEach(e -> System.out.println("- "+e));
        return traverser.breadthFirst(Lists.newArrayList(cats));
        // ctx.getSubscriber().onComplete();
    }

    private Traverser<String> catalogTraverser(IProc.ProcContext ctx) {
        List<Tuple2<String, List<String>>> rs = cacheCatalogTree(ctx);

        // build tree
        SuccessorsFunction<String> tree = createDirectedGraph(rs);
        Traverser<String> traverser = Traverser.forGraph(tree);
        return traverser;
    }

    public List<String> getProductsInCatalog(IProc.ProcContext ctx, String... cats){
        Traverser<String> traverser = catalogTraverser(ctx);
        RelatedProductDao relatedProductDao=ctx.getHandle().attach(RelatedProductDao.class);
        List<String> catIds = new ArrayList<String>();
        traverser.breadthFirst(Lists.newArrayList(cats)).forEach(catIds::add);
        return relatedProductDao.list(catIds).stream()
                // .peek(e -> System.out.println(e.getProductId()))
                .map(p -> p.getProductId())
                .collect(Collectors.toList());
    }


    private List<Tuple2<String, List<String>>> cacheCats;

    private List<Tuple2<String, List<String>>> cacheCatalogTree(IProc.ProcContext ctx) {
        if (cacheCats == null) {
            ProductCategoryDelegator.Dao dao = ctx.getHandle()
                    .attach(ProductCategoryDelegator.Dao.class);
            List<ProductCategory> rollupList = dao.listProductCategory();

            List<Tuple2<String, List<String>>> rs = rollupList.stream()
                    // .peek(e -> pretty(e))
                    .map(roll -> {
                        return Tuple2.of(roll.getProductCategoryId(), rollupList.stream().filter(
                                        c -> c.getPrimaryParentCategoryId() != null
                                                && c.getPrimaryParentCategoryId().equals(roll.getProductCategoryId()))
                                .map(c -> c.getProductCategoryId())
                                .collect(Collectors.toList()));
                    }).collect(Collectors.toList());

            cacheCats = rs;
            return rs;
        }
        return cacheCats;
    }


    private static SuccessorsFunction<String> createDirectedGraph(List<Tuple2<String, List<String>>> edges) {
        return createGraph(/* directed = */ true, edges);
    }

    private static SuccessorsFunction<String> createGraph(boolean directed, List<Tuple2<String, List<String>>> edges) {
        ImmutableMultimap.Builder<String, String> graphMapBuilder = ImmutableMultimap.builder();
        for (Tuple2<String, List<String>> edge : edges) {
            String node1 = edge.f0;
            edge.f1.forEach(node2 -> {
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

}
