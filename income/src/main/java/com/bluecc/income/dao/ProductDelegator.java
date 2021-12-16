package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.SqlObject;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.function.Consumer;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

import javax.inject.Inject;
import javax.inject.Provider;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.income.exchange.IProc;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.SqlMeta;

import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.model.IModel;
import reactor.core.publisher.Flux;
import java.util.function.Function;
import com.google.protobuf.Message;
import java.util.stream.Collectors;
import io.grpc.stub.StreamObserver;

import com.bluecc.hubs.stub.ProductData;

public class ProductDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(Product.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from product")
        List<Product> listProduct();
        @SqlQuery("select * from product where product_id=:id")
        Product getProduct(@Bind("id") String id);

        @SqlQuery("select count(*) from product")
        int countProduct();

        // for relations
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "ppc")
        default Map<String, Product> chainPrimaryProductCategory(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainPrimaryProductCategory(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "ppc")
        default Map<String, Product> chainPrimaryProductCategory(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRIMARY_PRODUCT_CATEGORY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("ppc_product_category_id", String.class) != null) {
                            p.getRelPrimaryProductCategory()
                                    .add(rr.getRow(ProductCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = Facility.class, prefix = "fa")
        default Map<String, Product> chainFacility(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainFacility(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = Facility.class, prefix = "fa")
        default Map<String, Product> chainFacility(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FACILITY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("fa_facility_id", String.class) != null) {
                            p.getRelFacility()
                                    .add(rr.getRow(Facility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "cbul")
        default Map<String, Product> chainCreatedByUserLogin(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainCreatedByUserLogin(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "cbul")
        default Map<String, Product> chainCreatedByUserLogin(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_USER_LOGIN);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("cbul_user_login_id", String.class) != null) {
                            p.getRelCreatedByUserLogin()
                                    .add(rr.getRow(UserLogin.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "lmbul")
        default Map<String, Product> chainLastModifiedByUserLogin(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByUserLogin(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "lmbul")
        default Map<String, Product> chainLastModifiedByUserLogin(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_USER_LOGIN);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("lmbul_user_login_id", String.class) != null) {
                            p.getRelLastModifiedByUserLogin()
                                    .add(rr.getRow(UserLogin.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ShipmentBoxType.class, prefix = "dsbt")
        default Map<String, Product> chainDefaultShipmentBoxType(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainDefaultShipmentBoxType(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ShipmentBoxType.class, prefix = "dsbt")
        default Map<String, Product> chainDefaultShipmentBoxType(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(DEFAULT_SHIPMENT_BOX_TYPE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("dsbt_shipment_box_type_id", String.class) != null) {
                            p.getRelDefaultShipmentBoxType()
                                    .add(rr.getRow(ShipmentBoxType.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = Agreement.class, prefix = "ag")
        default Map<String, Product> chainAgreement(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainAgreement(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = Agreement.class, prefix = "ag")
        default Map<String, Product> chainAgreement(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(AGREEMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("ag_product_id", String.class) != null) {
                            p.getRelAgreement()
                                    .add(rr.getRow(Agreement.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = AgreementProductAppl.class, prefix = "apa")
        default Map<String, Product> chainAgreementProductAppl(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainAgreementProductAppl(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = AgreementProductAppl.class, prefix = "apa")
        default Map<String, Product> chainAgreementProductAppl(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(AGREEMENT_PRODUCT_APPL);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("apa_product_id", String.class) != null) {
                            p.getRelAgreementProductAppl()
                                    .add(rr.getRow(AgreementProductAppl.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = CustRequestItem.class, prefix = "cri")
        default Map<String, Product> chainCustRequestItem(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainCustRequestItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = CustRequestItem.class, prefix = "cri")
        default Map<String, Product> chainCustRequestItem(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CUST_REQUEST_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("cri_product_id", String.class) != null) {
                            p.getRelCustRequestItem()
                                    .add(rr.getRow(CustRequestItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "iofa")
        default Map<String, Product> chainInstanceOfFixedAsset(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainInstanceOfFixedAsset(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "iofa")
        default Map<String, Product> chainInstanceOfFixedAsset(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INSTANCE_OF_FIXED_ASSET);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("iofa_instance_of_product_id", String.class) != null) {
                            p.getRelInstanceOfFixedAsset()
                                    .add(rr.getRow(FixedAsset.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = FixedAssetProduct.class, prefix = "fap")
        default Map<String, Product> chainFixedAssetProduct(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainFixedAssetProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = FixedAssetProduct.class, prefix = "fap")
        default Map<String, Product> chainFixedAssetProduct(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIXED_ASSET_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("fap_product_id", String.class) != null) {
                            p.getRelFixedAssetProduct()
                                    .add(rr.getRow(FixedAssetProduct.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        default Map<String, Product> chainInventoryItem(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainInventoryItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        default Map<String, Product> chainInventoryItem(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVENTORY_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("ii_product_id", String.class) != null) {
                            p.getRelInventoryItem()
                                    .add(rr.getRow(InventoryItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        default Map<String, Product> chainInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainInvoiceItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        default Map<String, Product> chainInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVOICE_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("ii_product_id", String.class) != null) {
                            p.getRelInvoiceItem()
                                    .add(rr.getRow(InvoiceItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        default Map<String, Product> chainOrderItem(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainOrderItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        default Map<String, Product> chainOrderItem(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("oi_product_id", String.class) != null) {
                            p.getRelOrderItem()
                                    .add(rr.getRow(OrderItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductAssoc.class, prefix = "mpa")
        default Map<String, Product> chainMainProductAssoc(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainMainProductAssoc(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductAssoc.class, prefix = "mpa")
        default Map<String, Product> chainMainProductAssoc(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(MAIN_PRODUCT_ASSOC);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("mpa_product_id", String.class) != null) {
                            p.getRelMainProductAssoc()
                                    .add(rr.getRow(ProductAssoc.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductAssoc.class, prefix = "apa")
        default Map<String, Product> chainAssocProductAssoc(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainAssocProductAssoc(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductAssoc.class, prefix = "apa")
        default Map<String, Product> chainAssocProductAssoc(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ASSOC_PRODUCT_ASSOC);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("apa_product_id_to", String.class) != null) {
                            p.getRelAssocProductAssoc()
                                    .add(rr.getRow(ProductAssoc.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        default Map<String, Product> chainProductCategoryMember(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductCategoryMember(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        default Map<String, Product> chainProductCategoryMember(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_CATEGORY_MEMBER);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("pcm_product_id", String.class) != null) {
                            p.getRelProductCategoryMember()
                                    .add(rr.getRow(ProductCategoryMember.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductConfig.class, prefix = "ppc")
        default Map<String, Product> chainProductProductConfig(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductProductConfig(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductConfig.class, prefix = "ppc")
        default Map<String, Product> chainProductProductConfig(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_PRODUCT_CONFIG);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("ppc_product_id", String.class) != null) {
                            p.getRelProductProductConfig()
                                    .add(rr.getRow(ProductConfig.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductConfigProduct.class, prefix = "ppcp")
        default Map<String, Product> chainProductProductConfigProduct(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductProductConfigProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductConfigProduct.class, prefix = "ppcp")
        default Map<String, Product> chainProductProductConfigProduct(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_PRODUCT_CONFIG_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("ppcp_product_id", String.class) != null) {
                            p.getRelProductProductConfigProduct()
                                    .add(rr.getRow(ProductConfigProduct.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductContent.class, prefix = "pc")
        default Map<String, Product> chainProductContent(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductContent(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductContent.class, prefix = "pc")
        default Map<String, Product> chainProductContent(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_CONTENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("pc_product_id", String.class) != null) {
                            p.getRelProductContent()
                                    .add(rr.getRow(ProductContent.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductFacility.class, prefix = "pf")
        default Map<String, Product> chainProductFacility(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductFacility(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductFacility.class, prefix = "pf")
        default Map<String, Product> chainProductFacility(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_FACILITY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("pf_product_id", String.class) != null) {
                            p.getRelProductFacility()
                                    .add(rr.getRow(ProductFacility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductFacilityAssoc.class, prefix = "pfa")
        default Map<String, Product> chainProductFacilityAssoc(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductFacilityAssoc(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductFacilityAssoc.class, prefix = "pfa")
        default Map<String, Product> chainProductFacilityAssoc(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_FACILITY_ASSOC);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("pfa_product_id", String.class) != null) {
                            p.getRelProductFacilityAssoc()
                                    .add(rr.getRow(ProductFacilityAssoc.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductFacilityLocation.class, prefix = "pfl")
        default Map<String, Product> chainProductFacilityLocation(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductFacilityLocation(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductFacilityLocation.class, prefix = "pfl")
        default Map<String, Product> chainProductFacilityLocation(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_FACILITY_LOCATION);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("pfl_product_id", String.class) != null) {
                            p.getRelProductFacilityLocation()
                                    .add(rr.getRow(ProductFacilityLocation.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductFeatureAppl.class, prefix = "pfa")
        default Map<String, Product> chainProductFeatureAppl(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductFeatureAppl(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductFeatureAppl.class, prefix = "pfa")
        default Map<String, Product> chainProductFeatureAppl(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_FEATURE_APPL);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("pfa_product_id", String.class) != null) {
                            p.getRelProductFeatureAppl()
                                    .add(rr.getRow(ProductFeatureAppl.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductKeyword.class, prefix = "pk")
        default Map<String, Product> chainProductKeyword(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductKeyword(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductKeyword.class, prefix = "pk")
        default Map<String, Product> chainProductKeyword(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_KEYWORD);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("pk_product_id", String.class) != null) {
                            p.getRelProductKeyword()
                                    .add(rr.getRow(ProductKeyword.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductPrice.class, prefix = "pp")
        default Map<String, Product> chainProductPrice(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductPrice(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductPrice.class, prefix = "pp")
        default Map<String, Product> chainProductPrice(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_PRICE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("pp_product_id", String.class) != null) {
                            p.getRelProductPrice()
                                    .add(rr.getRow(ProductPrice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductPromoProduct.class, prefix = "ppp")
        default Map<String, Product> chainProductPromoProduct(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductPromoProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductPromoProduct.class, prefix = "ppp")
        default Map<String, Product> chainProductPromoProduct(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_PROMO_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("ppp_product_id", String.class) != null) {
                            p.getRelProductPromoProduct()
                                    .add(rr.getRow(ProductPromoProduct.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductReview.class, prefix = "pr")
        default Map<String, Product> chainProductReview(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductReview(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductReview.class, prefix = "pr")
        default Map<String, Product> chainProductReview(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_REVIEW);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("pr_product_id", String.class) != null) {
                            p.getRelProductReview()
                                    .add(rr.getRow(ProductReview.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductStoreSurveyAppl.class, prefix = "pssa")
        default Map<String, Product> chainProductStoreSurveyAppl(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductStoreSurveyAppl(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductStoreSurveyAppl.class, prefix = "pssa")
        default Map<String, Product> chainProductStoreSurveyAppl(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_SURVEY_APPL);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("pssa_product_id", String.class) != null) {
                            p.getRelProductStoreSurveyAppl()
                                    .add(rr.getRow(ProductStoreSurveyAppl.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductSubscriptionResource.class, prefix = "psr")
        default Map<String, Product> chainProductSubscriptionResource(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainProductSubscriptionResource(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ProductSubscriptionResource.class, prefix = "psr")
        default Map<String, Product> chainProductSubscriptionResource(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_SUBSCRIPTION_RESOURCE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("psr_product_id", String.class) != null) {
                            p.getRelProductSubscriptionResource()
                                    .add(rr.getRow(ProductSubscriptionResource.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = QuoteItem.class, prefix = "qi")
        default Map<String, Product> chainQuoteItem(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainQuoteItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = QuoteItem.class, prefix = "qi")
        default Map<String, Product> chainQuoteItem(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(QUOTE_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("qi_product_id", String.class) != null) {
                            p.getRelQuoteItem()
                                    .add(rr.getRow(QuoteItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ShipmentItem.class, prefix = "si")
        default Map<String, Product> chainShipmentItem(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainShipmentItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ShipmentItem.class, prefix = "si")
        default Map<String, Product> chainShipmentItem(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("si_product_id", String.class) != null) {
                            p.getRelShipmentItem()
                                    .add(rr.getRow(ShipmentItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ShipmentPackageContent.class, prefix = "sspc")
        default Map<String, Product> chainSubShipmentPackageContent(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainSubShipmentPackageContent(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ShipmentPackageContent.class, prefix = "sspc")
        default Map<String, Product> chainSubShipmentPackageContent(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SUB_SHIPMENT_PACKAGE_CONTENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("sspc_sub_product_id", String.class) != null) {
                            p.getRelSubShipmentPackageContent()
                                    .add(rr.getRow(ShipmentPackageContent.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "sr")
        default Map<String, Product> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainShipmentReceipt(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "sr")
        default Map<String, Product> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_RECEIPT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("sr_product_id", String.class) != null) {
                            p.getRelShipmentReceipt()
                                    .add(rr.getRow(ShipmentReceipt.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = SupplierProduct.class, prefix = "sp")
        default Map<String, Product> chainSupplierProduct(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainSupplierProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = SupplierProduct.class, prefix = "sp")
        default Map<String, Product> chainSupplierProduct(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SUPPLIER_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("sp_product_id", String.class) != null) {
                            p.getRelSupplierProduct()
                                    .add(rr.getRow(SupplierProduct.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = WorkEffortGoodStandard.class, prefix = "wegs")
        default Map<String, Product> chainWorkEffortGoodStandard(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainWorkEffortGoodStandard(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = WorkEffortGoodStandard.class, prefix = "wegs")
        default Map<String, Product> chainWorkEffortGoodStandard(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WORK_EFFORT_GOOD_STANDARD);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("wegs_product_id", String.class) != null) {
                            p.getRelWorkEffortGoodStandard()
                                    .add(rr.getRow(WorkEffortGoodStandard.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = Tenant.class, prefix = "te")
        default Map<String, Product> chainTenant(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        @RegisterBeanMapper(value = Tenant.class, prefix = "te")
        default Map<String, Product> chainTenant(ProtoMeta protoMeta,
                                               Map<String, Product> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Product", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Product p = map.computeIfAbsent(rr.getColumn("pr_product_id", String.class),
                                id -> rr.getRow(Product.class));
                        if (rr.getColumn("te_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, Product>> primaryProductCategory(Dao dao, boolean succ) {
        return e -> dao.chainPrimaryProductCategory(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> primaryProductCategory(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPrimaryProductCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> facility(Dao dao, boolean succ) {
        return e -> dao.chainFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> facility(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> createdByUserLogin(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByUserLogin(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> createdByUserLogin(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByUserLogin(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> lastModifiedByUserLogin(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByUserLogin(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> lastModifiedByUserLogin(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByUserLogin(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> defaultShipmentBoxType(Dao dao, boolean succ) {
        return e -> dao.chainDefaultShipmentBoxType(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> defaultShipmentBoxType(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainDefaultShipmentBoxType(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> agreement(Dao dao, boolean succ) {
        return e -> dao.chainAgreement(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> agreement(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainAgreement(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> agreementProductAppl(Dao dao, boolean succ) {
        return e -> dao.chainAgreementProductAppl(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> agreementProductAppl(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainAgreementProductAppl(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> custRequestItem(Dao dao, boolean succ) {
        return e -> dao.chainCustRequestItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> custRequestItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCustRequestItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> instanceOfFixedAsset(Dao dao, boolean succ) {
        return e -> dao.chainInstanceOfFixedAsset(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> instanceOfFixedAsset(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInstanceOfFixedAsset(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> fixedAssetProduct(Dao dao, boolean succ) {
        return e -> dao.chainFixedAssetProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> fixedAssetProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFixedAssetProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> inventoryItem(Dao dao, boolean succ) {
        return e -> dao.chainInventoryItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> inventoryItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInventoryItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> invoiceItem(Dao dao, boolean succ) {
        return e -> dao.chainInvoiceItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> invoiceItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInvoiceItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> orderItem(Dao dao, boolean succ) {
        return e -> dao.chainOrderItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> orderItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> mainProductAssoc(Dao dao, boolean succ) {
        return e -> dao.chainMainProductAssoc(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> mainProductAssoc(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainMainProductAssoc(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> assocProductAssoc(Dao dao, boolean succ) {
        return e -> dao.chainAssocProductAssoc(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> assocProductAssoc(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainAssocProductAssoc(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productCategoryMember(Dao dao, boolean succ) {
        return e -> dao.chainProductCategoryMember(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productCategoryMember(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductCategoryMember(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productProductConfig(Dao dao, boolean succ) {
        return e -> dao.chainProductProductConfig(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productProductConfig(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductProductConfig(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productProductConfigProduct(Dao dao, boolean succ) {
        return e -> dao.chainProductProductConfigProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productProductConfigProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductProductConfigProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productContent(Dao dao, boolean succ) {
        return e -> dao.chainProductContent(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productContent(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductContent(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productFacility(Dao dao, boolean succ) {
        return e -> dao.chainProductFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productFacility(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productFacilityAssoc(Dao dao, boolean succ) {
        return e -> dao.chainProductFacilityAssoc(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productFacilityAssoc(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductFacilityAssoc(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productFacilityLocation(Dao dao, boolean succ) {
        return e -> dao.chainProductFacilityLocation(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productFacilityLocation(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductFacilityLocation(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productFeatureAppl(Dao dao, boolean succ) {
        return e -> dao.chainProductFeatureAppl(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productFeatureAppl(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductFeatureAppl(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productKeyword(Dao dao, boolean succ) {
        return e -> dao.chainProductKeyword(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productKeyword(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductKeyword(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productPrice(Dao dao, boolean succ) {
        return e -> dao.chainProductPrice(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productPrice(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductPrice(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productPromoProduct(Dao dao, boolean succ) {
        return e -> dao.chainProductPromoProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productPromoProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductPromoProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productReview(Dao dao, boolean succ) {
        return e -> dao.chainProductReview(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productReview(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductReview(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productStoreSurveyAppl(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreSurveyAppl(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productStoreSurveyAppl(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreSurveyAppl(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> productSubscriptionResource(Dao dao, boolean succ) {
        return e -> dao.chainProductSubscriptionResource(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> productSubscriptionResource(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductSubscriptionResource(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> quoteItem(Dao dao, boolean succ) {
        return e -> dao.chainQuoteItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> quoteItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainQuoteItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> shipmentItem(Dao dao, boolean succ) {
        return e -> dao.chainShipmentItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> shipmentItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> subShipmentPackageContent(Dao dao, boolean succ) {
        return e -> dao.chainSubShipmentPackageContent(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> subShipmentPackageContent(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainSubShipmentPackageContent(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> shipmentReceipt(Dao dao, boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> shipmentReceipt(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> supplierProduct(Dao dao, boolean succ) {
        return e -> dao.chainSupplierProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> supplierProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainSupplierProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> workEffortGoodStandard(Dao dao, boolean succ) {
        return e -> dao.chainWorkEffortGoodStandard(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> workEffortGoodStandard(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainWorkEffortGoodStandard(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Product>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, Product>> tenant(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, Product> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, Product> chainQuery(IProc.ProcContext c, Set<String> incls) {
        Map<String, Product> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, Product>> chain = tenant(dao, false);
         
        if (incls.contains(PRIMARY_PRODUCT_CATEGORY)) {
            chain = chain.andThen(primaryProductCategory(dao, true));
        }
         
        if (incls.contains(FACILITY)) {
            chain = chain.andThen(facility(dao, true));
        }
         
        if (incls.contains(CREATED_BY_USER_LOGIN)) {
            chain = chain.andThen(createdByUserLogin(dao, true));
        }
         
        if (incls.contains(LAST_MODIFIED_BY_USER_LOGIN)) {
            chain = chain.andThen(lastModifiedByUserLogin(dao, true));
        }
         
        if (incls.contains(DEFAULT_SHIPMENT_BOX_TYPE)) {
            chain = chain.andThen(defaultShipmentBoxType(dao, true));
        }
         
        if (incls.contains(AGREEMENT)) {
            chain = chain.andThen(agreement(dao, true));
        }
         
        if (incls.contains(AGREEMENT_PRODUCT_APPL)) {
            chain = chain.andThen(agreementProductAppl(dao, true));
        }
         
        if (incls.contains(CUST_REQUEST_ITEM)) {
            chain = chain.andThen(custRequestItem(dao, true));
        }
         
        if (incls.contains(INSTANCE_OF_FIXED_ASSET)) {
            chain = chain.andThen(instanceOfFixedAsset(dao, true));
        }
         
        if (incls.contains(FIXED_ASSET_PRODUCT)) {
            chain = chain.andThen(fixedAssetProduct(dao, true));
        }
         
        if (incls.contains(INVENTORY_ITEM)) {
            chain = chain.andThen(inventoryItem(dao, true));
        }
         
        if (incls.contains(INVOICE_ITEM)) {
            chain = chain.andThen(invoiceItem(dao, true));
        }
         
        if (incls.contains(ORDER_ITEM)) {
            chain = chain.andThen(orderItem(dao, true));
        }
         
        if (incls.contains(MAIN_PRODUCT_ASSOC)) {
            chain = chain.andThen(mainProductAssoc(dao, true));
        }
         
        if (incls.contains(ASSOC_PRODUCT_ASSOC)) {
            chain = chain.andThen(assocProductAssoc(dao, true));
        }
         
        if (incls.contains(PRODUCT_CATEGORY_MEMBER)) {
            chain = chain.andThen(productCategoryMember(dao, true));
        }
         
        if (incls.contains(PRODUCT_PRODUCT_CONFIG)) {
            chain = chain.andThen(productProductConfig(dao, true));
        }
         
        if (incls.contains(PRODUCT_PRODUCT_CONFIG_PRODUCT)) {
            chain = chain.andThen(productProductConfigProduct(dao, true));
        }
         
        if (incls.contains(PRODUCT_CONTENT)) {
            chain = chain.andThen(productContent(dao, true));
        }
         
        if (incls.contains(PRODUCT_FACILITY)) {
            chain = chain.andThen(productFacility(dao, true));
        }
         
        if (incls.contains(PRODUCT_FACILITY_ASSOC)) {
            chain = chain.andThen(productFacilityAssoc(dao, true));
        }
         
        if (incls.contains(PRODUCT_FACILITY_LOCATION)) {
            chain = chain.andThen(productFacilityLocation(dao, true));
        }
         
        if (incls.contains(PRODUCT_FEATURE_APPL)) {
            chain = chain.andThen(productFeatureAppl(dao, true));
        }
         
        if (incls.contains(PRODUCT_KEYWORD)) {
            chain = chain.andThen(productKeyword(dao, true));
        }
         
        if (incls.contains(PRODUCT_PRICE)) {
            chain = chain.andThen(productPrice(dao, true));
        }
         
        if (incls.contains(PRODUCT_PROMO_PRODUCT)) {
            chain = chain.andThen(productPromoProduct(dao, true));
        }
         
        if (incls.contains(PRODUCT_REVIEW)) {
            chain = chain.andThen(productReview(dao, true));
        }
         
        if (incls.contains(PRODUCT_STORE_SURVEY_APPL)) {
            chain = chain.andThen(productStoreSurveyAppl(dao, true));
        }
         
        if (incls.contains(PRODUCT_SUBSCRIPTION_RESOURCE)) {
            chain = chain.andThen(productSubscriptionResource(dao, true));
        }
         
        if (incls.contains(QUOTE_ITEM)) {
            chain = chain.andThen(quoteItem(dao, true));
        }
         
        if (incls.contains(SHIPMENT_ITEM)) {
            chain = chain.andThen(shipmentItem(dao, true));
        }
         
        if (incls.contains(SUB_SHIPMENT_PACKAGE_CONTENT)) {
            chain = chain.andThen(subShipmentPackageContent(dao, true));
        }
         
        if (incls.contains(SHIPMENT_RECEIPT)) {
            chain = chain.andThen(shipmentReceipt(dao, true));
        }
         
        if (incls.contains(SUPPLIER_PRODUCT)) {
            chain = chain.andThen(supplierProduct(dao, true));
        }
         
        if (incls.contains(WORK_EFFORT_GOOD_STANDARD)) {
            chain = chain.andThen(workEffortGoodStandard(dao, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<ProductData> responseObserver) {
        Map<String, Product> dataMap = chainQuery(c, incls);
        dataMap.values().stream().map(data -> {
            ProductData.Builder productData = data.toHeadBuilder();
             
            data.getRelPrimaryProductCategory().forEach(e -> 
                productData.setPrimaryProductCategory(e.toHeadBuilder())); 
            data.getRelFacility().forEach(e -> 
                productData.setFacility(e.toDataBuilder())); 
            data.getRelCreatedByUserLogin().forEach(e -> 
                productData.setCreatedByUserLogin(e.toHeadBuilder())); 
            data.getRelLastModifiedByUserLogin().forEach(e -> 
                productData.setLastModifiedByUserLogin(e.toHeadBuilder())); 
            data.getRelDefaultShipmentBoxType().forEach(e -> 
                productData.setDefaultShipmentBoxType(e.toDataBuilder())); 
            data.getRelAgreement().forEach(e -> 
                productData.addAgreement(e.toDataBuilder())); 
            data.getRelAgreementProductAppl().forEach(e -> 
                productData.addAgreementProductAppl(e.toDataBuilder())); 
            data.getRelCustRequestItem().forEach(e -> 
                productData.addCustRequestItem(e.toDataBuilder())); 
            data.getRelInstanceOfFixedAsset().forEach(e -> 
                productData.addInstanceOfFixedAsset(e.toHeadBuilder())); 
            data.getRelFixedAssetProduct().forEach(e -> 
                productData.addFixedAssetProduct(e.toDataBuilder())); 
            data.getRelInventoryItem().forEach(e -> 
                productData.addInventoryItem(e.toHeadBuilder())); 
            data.getRelInvoiceItem().forEach(e -> 
                productData.addInvoiceItem(e.toHeadBuilder())); 
            data.getRelOrderItem().forEach(e -> 
                productData.addOrderItem(e.toHeadBuilder())); 
            data.getRelMainProductAssoc().forEach(e -> 
                productData.addMainProductAssoc(e.toDataBuilder())); 
            data.getRelAssocProductAssoc().forEach(e -> 
                productData.addAssocProductAssoc(e.toDataBuilder())); 
            data.getRelProductCategoryMember().forEach(e -> 
                productData.addProductCategoryMember(e.toHeadBuilder())); 
            data.getRelProductProductConfig().forEach(e -> 
                productData.addProductProductConfig(e.toDataBuilder())); 
            data.getRelProductProductConfigProduct().forEach(e -> 
                productData.addProductProductConfigProduct(e.toDataBuilder())); 
            data.getRelProductContent().forEach(e -> 
                productData.addProductContent(e.toDataBuilder())); 
            data.getRelProductFacility().forEach(e -> 
                productData.addProductFacility(e.toDataBuilder())); 
            data.getRelProductFacilityAssoc().forEach(e -> 
                productData.addProductFacilityAssoc(e.toDataBuilder())); 
            data.getRelProductFacilityLocation().forEach(e -> 
                productData.addProductFacilityLocation(e.toDataBuilder())); 
            data.getRelProductFeatureAppl().forEach(e -> 
                productData.addProductFeatureAppl(e.toDataBuilder())); 
            data.getRelProductKeyword().forEach(e -> 
                productData.addProductKeyword(e.toDataBuilder())); 
            data.getRelProductPrice().forEach(e -> 
                productData.addProductPrice(e.toDataBuilder())); 
            data.getRelProductPromoProduct().forEach(e -> 
                productData.addProductPromoProduct(e.toDataBuilder())); 
            data.getRelProductReview().forEach(e -> 
                productData.addProductReview(e.toDataBuilder())); 
            data.getRelProductStoreSurveyAppl().forEach(e -> 
                productData.addProductStoreSurveyAppl(e.toDataBuilder())); 
            data.getRelProductSubscriptionResource().forEach(e -> 
                productData.addProductSubscriptionResource(e.toDataBuilder())); 
            data.getRelQuoteItem().forEach(e -> 
                productData.addQuoteItem(e.toDataBuilder())); 
            data.getRelShipmentItem().forEach(e -> 
                productData.addShipmentItem(e.toDataBuilder())); 
            data.getRelSubShipmentPackageContent().forEach(e -> 
                productData.addSubShipmentPackageContent(e.toDataBuilder())); 
            data.getRelShipmentReceipt().forEach(e -> 
                productData.addShipmentReceipt(e.toDataBuilder())); 
            data.getRelSupplierProduct().forEach(e -> 
                productData.addSupplierProduct(e.toDataBuilder())); 
            data.getRelWorkEffortGoodStandard().forEach(e -> 
                productData.addWorkEffortGoodStandard(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                productData.setTenant(e.toDataBuilder()));
            return productData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public Product get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getProduct(id);
    }

    public List<Product> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listProduct();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countProduct();
    }


    public void store(Product product){
        store(product, true);
    }

    public void store(Product product, boolean genId){
        process(c ->{
            if(genId){
                product.setProductId(sequence.nextStringId());
            }
            storeOrUpdate(c, product.toData());
        });
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final Product rec;
        final Message p1;
        Product persistObject;

        Agent(IProc.ProcContext ctx, Product rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public Product getRecord(){
            return rec;
        }

        public Product merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<ProductCategory> getPrimaryProductCategory(){
            return getRelationValues(ctx, p1, "primary_product_category", ProductCategory.class);
        }

        public List<ProductCategory> mergePrimaryProductCategory(){
            return getPrimaryProductCategory().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPrimaryProductCategory().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Facility> getFacility(){
            return getRelationValues(ctx, p1, "facility", Facility.class);
        }

        public List<Facility> mergeFacility(){
            return getFacility().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFacility().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<UserLogin> getCreatedByUserLogin(){
            return getRelationValues(ctx, p1, "created_by_user_login", UserLogin.class);
        }

        public List<UserLogin> mergeCreatedByUserLogin(){
            return getCreatedByUserLogin().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByUserLogin().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<UserLogin> getLastModifiedByUserLogin(){
            return getRelationValues(ctx, p1, "last_modified_by_user_login", UserLogin.class);
        }

        public List<UserLogin> mergeLastModifiedByUserLogin(){
            return getLastModifiedByUserLogin().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByUserLogin().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentBoxType> getDefaultShipmentBoxType(){
            return getRelationValues(ctx, p1, "default_shipment_box_type", ShipmentBoxType.class);
        }

        public List<ShipmentBoxType> mergeDefaultShipmentBoxType(){
            return getDefaultShipmentBoxType().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelDefaultShipmentBoxType().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Agreement> getAgreement(){
            return getRelationValues(ctx, p1, "agreement", Agreement.class);
        }

        public List<Agreement> mergeAgreement(){
            return getAgreement().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAgreement().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<AgreementProductAppl> getAgreementProductAppl(){
            return getRelationValues(ctx, p1, "agreement_product_appl", AgreementProductAppl.class);
        }

        public List<AgreementProductAppl> mergeAgreementProductAppl(){
            return getAgreementProductAppl().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAgreementProductAppl().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CustRequestItem> getCustRequestItem(){
            return getRelationValues(ctx, p1, "cust_request_item", CustRequestItem.class);
        }

        public List<CustRequestItem> mergeCustRequestItem(){
            return getCustRequestItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCustRequestItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FixedAsset> getInstanceOfFixedAsset(){
            return getRelationValues(ctx, p1, "instance_of_fixed_asset", FixedAsset.class);
        }

        public List<FixedAsset> mergeInstanceOfFixedAsset(){
            return getInstanceOfFixedAsset().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInstanceOfFixedAsset().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FixedAssetProduct> getFixedAssetProduct(){
            return getRelationValues(ctx, p1, "fixed_asset_product", FixedAssetProduct.class);
        }

        public List<FixedAssetProduct> mergeFixedAssetProduct(){
            return getFixedAssetProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFixedAssetProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InventoryItem> getInventoryItem(){
            return getRelationValues(ctx, p1, "inventory_item", InventoryItem.class);
        }

        public List<InventoryItem> mergeInventoryItem(){
            return getInventoryItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInventoryItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InvoiceItem> getInvoiceItem(){
            return getRelationValues(ctx, p1, "invoice_item", InvoiceItem.class);
        }

        public List<InvoiceItem> mergeInvoiceItem(){
            return getInvoiceItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInvoiceItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItem> getOrderItem(){
            return getRelationValues(ctx, p1, "order_item", OrderItem.class);
        }

        public List<OrderItem> mergeOrderItem(){
            return getOrderItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductAssoc> getMainProductAssoc(){
            return getRelationValues(ctx, p1, "main_product_assoc", ProductAssoc.class);
        }

        public List<ProductAssoc> mergeMainProductAssoc(){
            return getMainProductAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelMainProductAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductAssoc> getAssocProductAssoc(){
            return getRelationValues(ctx, p1, "assoc_product_assoc", ProductAssoc.class);
        }

        public List<ProductAssoc> mergeAssocProductAssoc(){
            return getAssocProductAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAssocProductAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategoryMember> getProductCategoryMember(){
            return getRelationValues(ctx, p1, "product_category_member", ProductCategoryMember.class);
        }

        public List<ProductCategoryMember> mergeProductCategoryMember(){
            return getProductCategoryMember().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductCategoryMember().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductConfig> getProductProductConfig(){
            return getRelationValues(ctx, p1, "product_product_config", ProductConfig.class);
        }

        public List<ProductConfig> mergeProductProductConfig(){
            return getProductProductConfig().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductProductConfig().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductConfigProduct> getProductProductConfigProduct(){
            return getRelationValues(ctx, p1, "product_product_config_product", ProductConfigProduct.class);
        }

        public List<ProductConfigProduct> mergeProductProductConfigProduct(){
            return getProductProductConfigProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductProductConfigProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductContent> getProductContent(){
            return getRelationValues(ctx, p1, "product_content", ProductContent.class);
        }

        public List<ProductContent> mergeProductContent(){
            return getProductContent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductContent().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFacility> getProductFacility(){
            return getRelationValues(ctx, p1, "product_facility", ProductFacility.class);
        }

        public List<ProductFacility> mergeProductFacility(){
            return getProductFacility().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductFacility().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFacilityAssoc> getProductFacilityAssoc(){
            return getRelationValues(ctx, p1, "product_facility_assoc", ProductFacilityAssoc.class);
        }

        public List<ProductFacilityAssoc> mergeProductFacilityAssoc(){
            return getProductFacilityAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductFacilityAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFacilityLocation> getProductFacilityLocation(){
            return getRelationValues(ctx, p1, "product_facility_location", ProductFacilityLocation.class);
        }

        public List<ProductFacilityLocation> mergeProductFacilityLocation(){
            return getProductFacilityLocation().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductFacilityLocation().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFeatureAppl> getProductFeatureAppl(){
            return getRelationValues(ctx, p1, "product_feature_appl", ProductFeatureAppl.class);
        }

        public List<ProductFeatureAppl> mergeProductFeatureAppl(){
            return getProductFeatureAppl().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductFeatureAppl().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductKeyword> getProductKeyword(){
            return getRelationValues(ctx, p1, "product_keyword", ProductKeyword.class);
        }

        public List<ProductKeyword> mergeProductKeyword(){
            return getProductKeyword().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductKeyword().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPrice> getProductPrice(){
            return getRelationValues(ctx, p1, "product_price", ProductPrice.class);
        }

        public List<ProductPrice> mergeProductPrice(){
            return getProductPrice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductPrice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromoProduct> getProductPromoProduct(){
            return getRelationValues(ctx, p1, "product_promo_product", ProductPromoProduct.class);
        }

        public List<ProductPromoProduct> mergeProductPromoProduct(){
            return getProductPromoProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductPromoProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductReview> getProductReview(){
            return getRelationValues(ctx, p1, "product_review", ProductReview.class);
        }

        public List<ProductReview> mergeProductReview(){
            return getProductReview().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductReview().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreSurveyAppl> getProductStoreSurveyAppl(){
            return getRelationValues(ctx, p1, "product_store_survey_appl", ProductStoreSurveyAppl.class);
        }

        public List<ProductStoreSurveyAppl> mergeProductStoreSurveyAppl(){
            return getProductStoreSurveyAppl().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreSurveyAppl().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductSubscriptionResource> getProductSubscriptionResource(){
            return getRelationValues(ctx, p1, "product_subscription_resource", ProductSubscriptionResource.class);
        }

        public List<ProductSubscriptionResource> mergeProductSubscriptionResource(){
            return getProductSubscriptionResource().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductSubscriptionResource().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<QuoteItem> getQuoteItem(){
            return getRelationValues(ctx, p1, "quote_item", QuoteItem.class);
        }

        public List<QuoteItem> mergeQuoteItem(){
            return getQuoteItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelQuoteItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentItem> getShipmentItem(){
            return getRelationValues(ctx, p1, "shipment_item", ShipmentItem.class);
        }

        public List<ShipmentItem> mergeShipmentItem(){
            return getShipmentItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentPackageContent> getSubShipmentPackageContent(){
            return getRelationValues(ctx, p1, "sub_shipment_package_content", ShipmentPackageContent.class);
        }

        public List<ShipmentPackageContent> mergeSubShipmentPackageContent(){
            return getSubShipmentPackageContent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelSubShipmentPackageContent().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentReceipt> getShipmentReceipt(){
            return getRelationValues(ctx, p1, "shipment_receipt", ShipmentReceipt.class);
        }

        public List<ShipmentReceipt> mergeShipmentReceipt(){
            return getShipmentReceipt().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentReceipt().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<SupplierProduct> getSupplierProduct(){
            return getRelationValues(ctx, p1, "supplier_product", SupplierProduct.class);
        }

        public List<SupplierProduct> mergeSupplierProduct(){
            return getSupplierProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelSupplierProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WorkEffortGoodStandard> getWorkEffortGoodStandard(){
            return getRelationValues(ctx, p1, "work_effort_good_standard", WorkEffortGoodStandard.class);
        }

        public List<WorkEffortGoodStandard> mergeWorkEffortGoodStandard(){
            return getWorkEffortGoodStandard().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelWorkEffortGoodStandard().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Tenant> getTenant(){
            return getRelationValues(ctx, p1, "tenant", Tenant.class);
        }

        public List<Tenant> mergeTenant(){
            return getTenant().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelTenant().add(c))
                    .collect(Collectors.toList());
        }
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        ProductData p = ProductData.newBuilder()
                .setProductId(key)
                .build();
        Product rec = findOne(ctx, p, Product.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, Product rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PRIMARY_PRODUCT_CATEGORY="primary_product_category";
         
    public static final String FACILITY="facility";
         
    public static final String CREATED_BY_USER_LOGIN="created_by_user_login";
         
    public static final String LAST_MODIFIED_BY_USER_LOGIN="last_modified_by_user_login";
         
    public static final String DEFAULT_SHIPMENT_BOX_TYPE="default_shipment_box_type";
         
    public static final String AGREEMENT="agreement";
         
    public static final String AGREEMENT_PRODUCT_APPL="agreement_product_appl";
         
    public static final String CUST_REQUEST_ITEM="cust_request_item";
         
    public static final String INSTANCE_OF_FIXED_ASSET="instance_of_fixed_asset";
         
    public static final String FIXED_ASSET_PRODUCT="fixed_asset_product";
         
    public static final String INVENTORY_ITEM="inventory_item";
         
    public static final String INVOICE_ITEM="invoice_item";
         
    public static final String ORDER_ITEM="order_item";
         
    public static final String MAIN_PRODUCT_ASSOC="main_product_assoc";
         
    public static final String ASSOC_PRODUCT_ASSOC="assoc_product_assoc";
         
    public static final String PRODUCT_CATEGORY_MEMBER="product_category_member";
         
    public static final String PRODUCT_PRODUCT_CONFIG="product_product_config";
         
    public static final String PRODUCT_PRODUCT_CONFIG_PRODUCT="product_product_config_product";
         
    public static final String PRODUCT_CONTENT="product_content";
         
    public static final String PRODUCT_FACILITY="product_facility";
         
    public static final String PRODUCT_FACILITY_ASSOC="product_facility_assoc";
         
    public static final String PRODUCT_FACILITY_LOCATION="product_facility_location";
         
    public static final String PRODUCT_FEATURE_APPL="product_feature_appl";
         
    public static final String PRODUCT_KEYWORD="product_keyword";
         
    public static final String PRODUCT_PRICE="product_price";
         
    public static final String PRODUCT_PROMO_PRODUCT="product_promo_product";
         
    public static final String PRODUCT_REVIEW="product_review";
         
    public static final String PRODUCT_STORE_SURVEY_APPL="product_store_survey_appl";
         
    public static final String PRODUCT_SUBSCRIPTION_RESOURCE="product_subscription_resource";
         
    public static final String QUOTE_ITEM="quote_item";
         
    public static final String SHIPMENT_ITEM="shipment_item";
         
    public static final String SUB_SHIPMENT_PACKAGE_CONTENT="sub_shipment_package_content";
         
    public static final String SHIPMENT_RECEIPT="shipment_receipt";
         
    public static final String SUPPLIER_PRODUCT="supplier_product";
         
    public static final String WORK_EFFORT_GOOD_STANDARD="work_effort_good_standard";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProductRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProductData p = ProductData.newBuilder()
                    .setProductId(key)
                    .build();
            List<ProductData.Builder> ds = find(ctx, p, Product.class).stream()
                    .map(e -> {
                        ProductData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set primary_product_category to head entity                        
                        if(relationsDemand.contains("primary_product_category")) {
                            getRelationValues(ctx, p1, "primary_product_category",
                                            ProductCategory.class)
                                    .forEach(el -> pb.setPrimaryProductCategory(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set facility to head entity                        
                        if(relationsDemand.contains("facility")) {
                            getRelationValues(ctx, p1, "facility",
                                            Facility.class)
                                    .forEach(el -> pb.setFacility(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_user_login to head entity                        
                        if(relationsDemand.contains("created_by_user_login")) {
                            getRelationValues(ctx, p1, "created_by_user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.setCreatedByUserLogin(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_user_login to head entity                        
                        if(relationsDemand.contains("last_modified_by_user_login")) {
                            getRelationValues(ctx, p1, "last_modified_by_user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.setLastModifiedByUserLogin(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set default_shipment_box_type to head entity                        
                        if(relationsDemand.contains("default_shipment_box_type")) {
                            getRelationValues(ctx, p1, "default_shipment_box_type",
                                            ShipmentBoxType.class)
                                    .forEach(el -> pb.setDefaultShipmentBoxType(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set agreement to head entity                        
                        if(relationsDemand.contains("agreement")) {
                            getRelationValues(ctx, p1, "agreement",
                                            Agreement.class)
                                    .forEach(el -> pb.addAgreement(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set agreement_product_appl to head entity                        
                        if(relationsDemand.contains("agreement_product_appl")) {
                            getRelationValues(ctx, p1, "agreement_product_appl",
                                            AgreementProductAppl.class)
                                    .forEach(el -> pb.addAgreementProductAppl(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set cust_request_item to head entity                        
                        if(relationsDemand.contains("cust_request_item")) {
                            getRelationValues(ctx, p1, "cust_request_item",
                                            CustRequestItem.class)
                                    .forEach(el -> pb.addCustRequestItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set instance_of_fixed_asset to head entity                        
                        if(relationsDemand.contains("instance_of_fixed_asset")) {
                            getRelationValues(ctx, p1, "instance_of_fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.addInstanceOfFixedAsset(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set fixed_asset_product to head entity                        
                        if(relationsDemand.contains("fixed_asset_product")) {
                            getRelationValues(ctx, p1, "fixed_asset_product",
                                            FixedAssetProduct.class)
                                    .forEach(el -> pb.addFixedAssetProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set inventory_item to head entity                        
                        if(relationsDemand.contains("inventory_item")) {
                            getRelationValues(ctx, p1, "inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.addInventoryItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set invoice_item to head entity                        
                        if(relationsDemand.contains("invoice_item")) {
                            getRelationValues(ctx, p1, "invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.addInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set order_item to head entity                        
                        if(relationsDemand.contains("order_item")) {
                            getRelationValues(ctx, p1, "order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.addOrderItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set main_product_assoc to head entity                        
                        if(relationsDemand.contains("main_product_assoc")) {
                            getRelationValues(ctx, p1, "main_product_assoc",
                                            ProductAssoc.class)
                                    .forEach(el -> pb.addMainProductAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set assoc_product_assoc to head entity                        
                        if(relationsDemand.contains("assoc_product_assoc")) {
                            getRelationValues(ctx, p1, "assoc_product_assoc",
                                            ProductAssoc.class)
                                    .forEach(el -> pb.addAssocProductAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_category_member to head entity                        
                        if(relationsDemand.contains("product_category_member")) {
                            getRelationValues(ctx, p1, "product_category_member",
                                            ProductCategoryMember.class)
                                    .forEach(el -> pb.addProductCategoryMember(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_product_config to head entity                        
                        if(relationsDemand.contains("product_product_config")) {
                            getRelationValues(ctx, p1, "product_product_config",
                                            ProductConfig.class)
                                    .forEach(el -> pb.addProductProductConfig(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_product_config_product to head entity                        
                        if(relationsDemand.contains("product_product_config_product")) {
                            getRelationValues(ctx, p1, "product_product_config_product",
                                            ProductConfigProduct.class)
                                    .forEach(el -> pb.addProductProductConfigProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_content to head entity                        
                        if(relationsDemand.contains("product_content")) {
                            getRelationValues(ctx, p1, "product_content",
                                            ProductContent.class)
                                    .forEach(el -> pb.addProductContent(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_facility to head entity                        
                        if(relationsDemand.contains("product_facility")) {
                            getRelationValues(ctx, p1, "product_facility",
                                            ProductFacility.class)
                                    .forEach(el -> pb.addProductFacility(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_facility_assoc to head entity                        
                        if(relationsDemand.contains("product_facility_assoc")) {
                            getRelationValues(ctx, p1, "product_facility_assoc",
                                            ProductFacilityAssoc.class)
                                    .forEach(el -> pb.addProductFacilityAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_facility_location to head entity                        
                        if(relationsDemand.contains("product_facility_location")) {
                            getRelationValues(ctx, p1, "product_facility_location",
                                            ProductFacilityLocation.class)
                                    .forEach(el -> pb.addProductFacilityLocation(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_feature_appl to head entity                        
                        if(relationsDemand.contains("product_feature_appl")) {
                            getRelationValues(ctx, p1, "product_feature_appl",
                                            ProductFeatureAppl.class)
                                    .forEach(el -> pb.addProductFeatureAppl(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_keyword to head entity                        
                        if(relationsDemand.contains("product_keyword")) {
                            getRelationValues(ctx, p1, "product_keyword",
                                            ProductKeyword.class)
                                    .forEach(el -> pb.addProductKeyword(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_price to head entity                        
                        if(relationsDemand.contains("product_price")) {
                            getRelationValues(ctx, p1, "product_price",
                                            ProductPrice.class)
                                    .forEach(el -> pb.addProductPrice(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_promo_product to head entity                        
                        if(relationsDemand.contains("product_promo_product")) {
                            getRelationValues(ctx, p1, "product_promo_product",
                                            ProductPromoProduct.class)
                                    .forEach(el -> pb.addProductPromoProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_review to head entity                        
                        if(relationsDemand.contains("product_review")) {
                            getRelationValues(ctx, p1, "product_review",
                                            ProductReview.class)
                                    .forEach(el -> pb.addProductReview(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_survey_appl to head entity                        
                        if(relationsDemand.contains("product_store_survey_appl")) {
                            getRelationValues(ctx, p1, "product_store_survey_appl",
                                            ProductStoreSurveyAppl.class)
                                    .forEach(el -> pb.addProductStoreSurveyAppl(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_subscription_resource to head entity                        
                        if(relationsDemand.contains("product_subscription_resource")) {
                            getRelationValues(ctx, p1, "product_subscription_resource",
                                            ProductSubscriptionResource.class)
                                    .forEach(el -> pb.addProductSubscriptionResource(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set quote_item to head entity                        
                        if(relationsDemand.contains("quote_item")) {
                            getRelationValues(ctx, p1, "quote_item",
                                            QuoteItem.class)
                                    .forEach(el -> pb.addQuoteItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_item to head entity                        
                        if(relationsDemand.contains("shipment_item")) {
                            getRelationValues(ctx, p1, "shipment_item",
                                            ShipmentItem.class)
                                    .forEach(el -> pb.addShipmentItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set sub_shipment_package_content to head entity                        
                        if(relationsDemand.contains("sub_shipment_package_content")) {
                            getRelationValues(ctx, p1, "sub_shipment_package_content",
                                            ShipmentPackageContent.class)
                                    .forEach(el -> pb.addSubShipmentPackageContent(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_receipt to head entity                        
                        if(relationsDemand.contains("shipment_receipt")) {
                            getRelationValues(ctx, p1, "shipment_receipt",
                                            ShipmentReceipt.class)
                                    .forEach(el -> pb.addShipmentReceipt(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set supplier_product to head entity                        
                        if(relationsDemand.contains("supplier_product")) {
                            getRelationValues(ctx, p1, "supplier_product",
                                            SupplierProduct.class)
                                    .forEach(el -> pb.addSupplierProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set work_effort_good_standard to head entity                        
                        if(relationsDemand.contains("work_effort_good_standard")) {
                            getRelationValues(ctx, p1, "work_effort_good_standard",
                                            WorkEffortGoodStandard.class)
                                    .forEach(el -> pb.addWorkEffortGoodStandard(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set tenant to head entity                        
                        if(relationsDemand.contains("tenant")) {
                            getRelationValues(ctx, p1, "tenant",
                                            Tenant.class)
                                    .forEach(el -> pb.setTenant(
                                             el.toDataBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
    public Product.ProductBuilder seed(){
        return Product.builder()
                .productId(sequence.nextStringId());
    }
}
