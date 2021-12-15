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
import com.bluecc.hubs.stub.FixedAssetData;

public class FixedAssetDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(FixedAsset.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from fixed_asset")
        List<FixedAsset> listFixedAsset();
        @SqlQuery("select * from fixed_asset where fixed_asset_id=:id")
        FixedAsset getFixedAsset(@Bind("id") String id);

        @SqlQuery("select count(*) from fixed_asset")
        int countFixedAsset();

        // for relations
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "pfa")
        default Map<String, FixedAsset> chainParentFixedAsset(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainParentFixedAsset(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "pfa")
        default Map<String, FixedAsset> chainParentFixedAsset(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARENT_FIXED_ASSET);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("pfa_fixed_asset_id", String.class) != null) {
                            p.getRelParentFixedAsset()
                                    .add(rr.getRow(FixedAsset.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = Product.class, prefix = "iop")
        default Map<String, FixedAsset> chainInstanceOfProduct(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainInstanceOfProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = Product.class, prefix = "iop")
        default Map<String, FixedAsset> chainInstanceOfProduct(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INSTANCE_OF_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("iop_product_id", String.class) != null) {
                            p.getRelInstanceOfProduct()
                                    .add(rr.getRow(Product.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        default Map<String, FixedAsset> chainParty(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        default Map<String, FixedAsset> chainParty(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("pa_party_id", String.class) != null) {
                            p.getRelParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = PartyRole.class, prefix = "pr")
        default Map<String, FixedAsset> chainPartyRole(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainPartyRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = PartyRole.class, prefix = "pr")
        default Map<String, FixedAsset> chainPartyRole(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("pr_party_id", String.class) != null) {
                            p.getRelPartyRole()
                                    .add(rr.getRow(PartyRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "aoh")
        default Map<String, FixedAsset> chainAcquireOrderHeader(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainAcquireOrderHeader(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "aoh")
        default Map<String, FixedAsset> chainAcquireOrderHeader(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACQUIRE_ORDER_HEADER);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("aoh_order_id", String.class) != null) {
                            p.getRelAcquireOrderHeader()
                                    .add(rr.getRow(OrderHeader.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "aoi")
        default Map<String, FixedAsset> chainAcquireOrderItem(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainAcquireOrderItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "aoi")
        default Map<String, FixedAsset> chainAcquireOrderItem(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACQUIRE_ORDER_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("aoi_order_id", String.class) != null) {
                            p.getRelAcquireOrderItem()
                                    .add(rr.getRow(OrderItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = FacilityLocation.class, prefix = "lafl")
        default Map<String, FixedAsset> chainLocatedAtFacilityLocation(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainLocatedAtFacilityLocation(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = FacilityLocation.class, prefix = "lafl")
        default Map<String, FixedAsset> chainLocatedAtFacilityLocation(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LOCATED_AT_FACILITY_LOCATION);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("lafl_facility_id", String.class) != null) {
                            p.getRelLocatedAtFacilityLocation()
                                    .add(rr.getRow(FacilityLocation.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "at")
        default Map<String, FixedAsset> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainAcctgTrans(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "at")
        default Map<String, FixedAsset> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACCTG_TRANS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("at_fixed_asset_id", String.class) != null) {
                            p.getRelAcctgTrans()
                                    .add(rr.getRow(AcctgTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "cfa")
        default Map<String, FixedAsset> chainChildFixedAsset(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainChildFixedAsset(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "cfa")
        default Map<String, FixedAsset> chainChildFixedAsset(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHILD_FIXED_ASSET);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("cfa_parent_fixed_asset_id", String.class) != null) {
                            p.getRelChildFixedAsset()
                                    .add(rr.getRow(FixedAsset.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = FixedAssetGeoPoint.class, prefix = "fagp")
        default Map<String, FixedAsset> chainFixedAssetGeoPoint(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainFixedAssetGeoPoint(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = FixedAssetGeoPoint.class, prefix = "fagp")
        default Map<String, FixedAsset> chainFixedAssetGeoPoint(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIXED_ASSET_GEO_POINT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("fagp_fixed_asset_id", String.class) != null) {
                            p.getRelFixedAssetGeoPoint()
                                    .add(rr.getRow(FixedAssetGeoPoint.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = FixedAssetProduct.class, prefix = "fap")
        default Map<String, FixedAsset> chainFixedAssetProduct(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainFixedAssetProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = FixedAssetProduct.class, prefix = "fap")
        default Map<String, FixedAsset> chainFixedAssetProduct(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIXED_ASSET_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("fap_fixed_asset_id", String.class) != null) {
                            p.getRelFixedAssetProduct()
                                    .add(rr.getRow(FixedAssetProduct.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "faii")
        default Map<String, FixedAsset> chainFixedAssetInventoryItem(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainFixedAssetInventoryItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "faii")
        default Map<String, FixedAsset> chainFixedAssetInventoryItem(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIXED_ASSET_INVENTORY_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("faii_fixed_asset_id", String.class) != null) {
                            p.getRelFixedAssetInventoryItem()
                                    .add(rr.getRow(InventoryItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        default Map<String, FixedAsset> chainWorkEffort(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               boolean succInvoke) {
            return chainWorkEffort(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fa")
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        default Map<String, FixedAsset> chainWorkEffort(ProtoMeta protoMeta,
                                               Map<String, FixedAsset> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FixedAsset", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WORK_EFFORT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        FixedAsset p = map.computeIfAbsent(rr.getColumn("fa_fixed_asset_id", String.class),
                                id -> rr.getRow(FixedAsset.class));
                        if (rr.getColumn("we_fixed_asset_id", String.class) != null) {
                            p.getRelWorkEffort()
                                    .add(rr.getRow(WorkEffort.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, FixedAsset>> parentFixedAsset(Dao dao, boolean succ) {
        return e -> dao.chainParentFixedAsset(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> parentFixedAsset(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainParentFixedAsset(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FixedAsset>> instanceOfProduct(Dao dao, boolean succ) {
        return e -> dao.chainInstanceOfProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> instanceOfProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInstanceOfProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FixedAsset>> party(Dao dao, boolean succ) {
        return e -> dao.chainParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> party(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FixedAsset>> partyRole(Dao dao, boolean succ) {
        return e -> dao.chainPartyRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> partyRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FixedAsset>> acquireOrderHeader(Dao dao, boolean succ) {
        return e -> dao.chainAcquireOrderHeader(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> acquireOrderHeader(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainAcquireOrderHeader(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FixedAsset>> acquireOrderItem(Dao dao, boolean succ) {
        return e -> dao.chainAcquireOrderItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> acquireOrderItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainAcquireOrderItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FixedAsset>> locatedAtFacilityLocation(Dao dao, boolean succ) {
        return e -> dao.chainLocatedAtFacilityLocation(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> locatedAtFacilityLocation(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainLocatedAtFacilityLocation(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FixedAsset>> acctgTrans(Dao dao, boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> acctgTrans(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FixedAsset>> childFixedAsset(Dao dao, boolean succ) {
        return e -> dao.chainChildFixedAsset(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> childFixedAsset(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainChildFixedAsset(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FixedAsset>> fixedAssetGeoPoint(Dao dao, boolean succ) {
        return e -> dao.chainFixedAssetGeoPoint(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> fixedAssetGeoPoint(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFixedAssetGeoPoint(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FixedAsset>> fixedAssetProduct(Dao dao, boolean succ) {
        return e -> dao.chainFixedAssetProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> fixedAssetProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFixedAssetProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FixedAsset>> fixedAssetInventoryItem(Dao dao, boolean succ) {
        return e -> dao.chainFixedAssetInventoryItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> fixedAssetInventoryItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFixedAssetInventoryItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FixedAsset>> workEffort(Dao dao, boolean succ) {
        return e -> dao.chainWorkEffort(protoMeta, e, succ);
    }

    public Consumer<Map<String, FixedAsset>> workEffort(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainWorkEffort(protoMeta, e, whereClause, binds, succ);
    }
    

    public FixedAsset get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getFixedAsset(id);
    }

    public List<FixedAsset> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listFixedAsset();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countFixedAsset();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final FixedAsset rec;
        final Message p1;
        FixedAsset persistObject;

        Agent(IProc.ProcContext ctx, FixedAsset rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public FixedAsset getRecord(){
            return rec;
        }

        public FixedAsset merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<FixedAsset> getParentFixedAsset(){
            return getRelationValues(ctx, p1, "parent_fixed_asset", FixedAsset.class);
        }

        public List<FixedAsset> mergeParentFixedAsset(){
            return getParentFixedAsset().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelParentFixedAsset().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Product> getInstanceOfProduct(){
            return getRelationValues(ctx, p1, "instance_of_product", Product.class);
        }

        public List<Product> mergeInstanceOfProduct(){
            return getInstanceOfProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInstanceOfProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Party> getParty(){
            return getRelationValues(ctx, p1, "party", Party.class);
        }

        public List<Party> mergeParty(){
            return getParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyRole> getPartyRole(){
            return getRelationValues(ctx, p1, "party_role", PartyRole.class);
        }

        public List<PartyRole> mergePartyRole(){
            return getPartyRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderHeader> getAcquireOrderHeader(){
            return getRelationValues(ctx, p1, "acquire_order_header", OrderHeader.class);
        }

        public List<OrderHeader> mergeAcquireOrderHeader(){
            return getAcquireOrderHeader().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcquireOrderHeader().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItem> getAcquireOrderItem(){
            return getRelationValues(ctx, p1, "acquire_order_item", OrderItem.class);
        }

        public List<OrderItem> mergeAcquireOrderItem(){
            return getAcquireOrderItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcquireOrderItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FacilityLocation> getLocatedAtFacilityLocation(){
            return getRelationValues(ctx, p1, "located_at_facility_location", FacilityLocation.class);
        }

        public List<FacilityLocation> mergeLocatedAtFacilityLocation(){
            return getLocatedAtFacilityLocation().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLocatedAtFacilityLocation().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<AcctgTrans> getAcctgTrans(){
            return getRelationValues(ctx, p1, "acctg_trans", AcctgTrans.class);
        }

        public List<AcctgTrans> mergeAcctgTrans(){
            return getAcctgTrans().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcctgTrans().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FixedAsset> getChildFixedAsset(){
            return getRelationValues(ctx, p1, "child_fixed_asset", FixedAsset.class);
        }

        public List<FixedAsset> mergeChildFixedAsset(){
            return getChildFixedAsset().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChildFixedAsset().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FixedAssetGeoPoint> getFixedAssetGeoPoint(){
            return getRelationValues(ctx, p1, "fixed_asset_geo_point", FixedAssetGeoPoint.class);
        }

        public List<FixedAssetGeoPoint> mergeFixedAssetGeoPoint(){
            return getFixedAssetGeoPoint().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFixedAssetGeoPoint().add(c))
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
         
        public List<InventoryItem> getFixedAssetInventoryItem(){
            return getRelationValues(ctx, p1, "fixed_asset_inventory_item", InventoryItem.class);
        }

        public List<InventoryItem> mergeFixedAssetInventoryItem(){
            return getFixedAssetInventoryItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFixedAssetInventoryItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WorkEffort> getWorkEffort(){
            return getRelationValues(ctx, p1, "work_effort", WorkEffort.class);
        }

        public List<WorkEffort> mergeWorkEffort(){
            return getWorkEffort().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelWorkEffort().add(c))
                    .collect(Collectors.toList());
        }
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        FixedAssetData p = FixedAssetData.newBuilder()
                .setFixedAssetId(key)
                .build();
        FixedAsset rec = findOne(ctx, p, FixedAsset.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, FixedAsset rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PARENT_FIXED_ASSET="parent_fixed_asset";
         
    public static final String INSTANCE_OF_PRODUCT="instance_of_product";
         
    public static final String PARTY="party";
         
    public static final String PARTY_ROLE="party_role";
         
    public static final String ACQUIRE_ORDER_HEADER="acquire_order_header";
         
    public static final String ACQUIRE_ORDER_ITEM="acquire_order_item";
         
    public static final String LOCATED_AT_FACILITY_LOCATION="located_at_facility_location";
         
    public static final String ACCTG_TRANS="acctg_trans";
         
    public static final String CHILD_FIXED_ASSET="child_fixed_asset";
         
    public static final String FIXED_ASSET_GEO_POINT="fixed_asset_geo_point";
         
    public static final String FIXED_ASSET_PRODUCT="fixed_asset_product";
         
    public static final String FIXED_ASSET_INVENTORY_ITEM="fixed_asset_inventory_item";
         
    public static final String WORK_EFFORT="work_effort";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryFixedAssetRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            FixedAssetData p = FixedAssetData.newBuilder()
                    .setFixedAssetId(key)
                    .build();
            List<FixedAssetData.Builder> ds = find(ctx, p, FixedAsset.class).stream()
                    .map(e -> {
                        FixedAssetData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set parent_fixed_asset to head entity                        
                        if(relationsDemand.contains("parent_fixed_asset")) {
                            getRelationValues(ctx, p1, "parent_fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.setParentFixedAsset(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set instance_of_product to head entity                        
                        if(relationsDemand.contains("instance_of_product")) {
                            getRelationValues(ctx, p1, "instance_of_product",
                                            Product.class)
                                    .forEach(el -> pb.setInstanceOfProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set party to head entity                        
                        if(relationsDemand.contains("party")) {
                            getRelationValues(ctx, p1, "party",
                                            Party.class)
                                    .forEach(el -> pb.setParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set party_role to head entity                        
                        if(relationsDemand.contains("party_role")) {
                            getRelationValues(ctx, p1, "party_role",
                                            PartyRole.class)
                                    .forEach(el -> pb.setPartyRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set acquire_order_header to head entity                        
                        if(relationsDemand.contains("acquire_order_header")) {
                            getRelationValues(ctx, p1, "acquire_order_header",
                                            OrderHeader.class)
                                    .forEach(el -> pb.setAcquireOrderHeader(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set acquire_order_item to head entity                        
                        if(relationsDemand.contains("acquire_order_item")) {
                            getRelationValues(ctx, p1, "acquire_order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.setAcquireOrderItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set located_at_facility_location to head entity                        
                        if(relationsDemand.contains("located_at_facility_location")) {
                            getRelationValues(ctx, p1, "located_at_facility_location",
                                            FacilityLocation.class)
                                    .forEach(el -> pb.setLocatedAtFacilityLocation(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set acctg_trans to head entity                        
                        if(relationsDemand.contains("acctg_trans")) {
                            getRelationValues(ctx, p1, "acctg_trans",
                                            AcctgTrans.class)
                                    .forEach(el -> pb.addAcctgTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set child_fixed_asset to head entity                        
                        if(relationsDemand.contains("child_fixed_asset")) {
                            getRelationValues(ctx, p1, "child_fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.addChildFixedAsset(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set fixed_asset_geo_point to head entity                        
                        if(relationsDemand.contains("fixed_asset_geo_point")) {
                            getRelationValues(ctx, p1, "fixed_asset_geo_point",
                                            FixedAssetGeoPoint.class)
                                    .forEach(el -> pb.addFixedAssetGeoPoint(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fixed_asset_product to head entity                        
                        if(relationsDemand.contains("fixed_asset_product")) {
                            getRelationValues(ctx, p1, "fixed_asset_product",
                                            FixedAssetProduct.class)
                                    .forEach(el -> pb.addFixedAssetProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fixed_asset_inventory_item to head entity                        
                        if(relationsDemand.contains("fixed_asset_inventory_item")) {
                            getRelationValues(ctx, p1, "fixed_asset_inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.addFixedAssetInventoryItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set work_effort to head entity                        
                        if(relationsDemand.contains("work_effort")) {
                            getRelationValues(ctx, p1, "work_effort",
                                            WorkEffort.class)
                                    .forEach(el -> pb.addWorkEffort(
                                             el.toDataBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
    public FixedAsset.FixedAssetBuilder seed(){
        return FixedAsset.builder()
                .fixedAssetId(sequence.nextStringId());
    }
}
