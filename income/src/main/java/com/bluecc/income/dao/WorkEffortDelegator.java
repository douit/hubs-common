package com.bluecc.income.dao;

import com.bluecc.hubs.stub.EntityBucket;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.hubs.stub.QueryProfile;
import com.bluecc.income.exchange.IDelegator;
import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.procs.Buckets;
import com.bluecc.income.procs.SelectorBindings;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.SqlObject;

import com.bluecc.income.exchange.GsonConverters;
import com.linecorp.armeria.server.annotation.*;

import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.function.Consumer;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;
import com.bluecc.income.procs.Buckets;

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
import com.bluecc.income.exchange.IChainQuery;

import com.bluecc.hubs.stub.WorkEffortData;

public class WorkEffortDelegator extends AbstractProcs implements IChainQuery<WorkEffort>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(WorkEffort.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from work_effort")
        List<WorkEffort> listWorkEffort();
        @SqlQuery("select * from work_effort where work_effort_id=:id")
        WorkEffort getWorkEffort(@Bind("id") String id);

        @SqlQuery("select count(*) from work_effort")
        int countWorkEffort();

        // for relations
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "pweo")
        default Map<String, WorkEffort> chainParentWorkEffort(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainParentWorkEffort(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "pweo")
        default Map<String, WorkEffort> chainParentWorkEffort(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARENT_WORK_EFFORT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("pweo_work_effort_id", String.class) != null) {
                            p.getRelParentWorkEffort()
                                    .add(rr.getRow(WorkEffort.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fao")
        default Map<String, WorkEffort> chainFixedAsset(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainFixedAsset(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fao")
        default Map<String, WorkEffort> chainFixedAsset(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIXED_ASSET);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("fao_fixed_asset_id", String.class) != null) {
                            p.getRelFixedAsset()
                                    .add(rr.getRow(FixedAsset.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = Facility.class, prefix = "fao")
        default Map<String, WorkEffort> chainFacility(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainFacility(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = Facility.class, prefix = "fao")
        default Map<String, WorkEffort> chainFacility(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FACILITY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("fao_facility_id", String.class) != null) {
                            p.getRelFacility()
                                    .add(rr.getRow(Facility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = RecurrenceInfo.class, prefix = "rio")
        default Map<String, WorkEffort> chainRecurrenceInfo(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainRecurrenceInfo(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = RecurrenceInfo.class, prefix = "rio")
        default Map<String, WorkEffort> chainRecurrenceInfo(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(RECURRENCE_INFO);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("rio_recurrence_info_id", String.class) != null) {
                            p.getRelRecurrenceInfo()
                                    .add(rr.getRow(RecurrenceInfo.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = TemporalExpression.class, prefix = "teo")
        default Map<String, WorkEffort> chainTemporalExpression(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainTemporalExpression(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = TemporalExpression.class, prefix = "teo")
        default Map<String, WorkEffort> chainTemporalExpression(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TEMPORAL_EXPRESSION);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("teo_temp_expr_id", String.class) != null) {
                            p.getRelTemporalExpression()
                                    .add(rr.getRow(TemporalExpression.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = CustomMethod.class, prefix = "cmo")
        default Map<String, WorkEffort> chainCustomMethod(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainCustomMethod(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = CustomMethod.class, prefix = "cmo")
        default Map<String, WorkEffort> chainCustomMethod(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CUSTOM_METHOD);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("cmo_custom_method_id", String.class) != null) {
                            p.getRelCustomMethod()
                                    .add(rr.getRow(CustomMethod.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "atm")
        default Map<String, WorkEffort> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainAcctgTrans(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "atm")
        default Map<String, WorkEffort> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACCTG_TRANS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("atm_work_effort_id", String.class) != null) {
                            p.getRelAcctgTrans()
                                    .add(rr.getRow(AcctgTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = InventoryItemDetail.class, prefix = "iidm")
        default Map<String, WorkEffort> chainInventoryItemDetail(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainInventoryItemDetail(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = InventoryItemDetail.class, prefix = "iidm")
        default Map<String, WorkEffort> chainInventoryItemDetail(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVENTORY_ITEM_DETAIL);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("iidm_work_effort_id", String.class) != null) {
                            p.getRelInventoryItemDetail()
                                    .add(rr.getRow(InventoryItemDetail.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = ProductAssoc.class, prefix = "rpam")
        default Map<String, WorkEffort> chainRoutingProductAssoc(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainRoutingProductAssoc(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = ProductAssoc.class, prefix = "rpam")
        default Map<String, WorkEffort> chainRoutingProductAssoc(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ROUTING_PRODUCT_ASSOC);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("rpam_routing_work_effort_id", String.class) != null) {
                            p.getRelRoutingProductAssoc()
                                    .add(rr.getRow(ProductAssoc.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = QuoteItem.class, prefix = "qim")
        default Map<String, WorkEffort> chainQuoteItem(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainQuoteItem(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = QuoteItem.class, prefix = "qim")
        default Map<String, WorkEffort> chainQuoteItem(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(QUOTE_ITEM);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("qim_work_effort_id", String.class) != null) {
                            p.getRelQuoteItem()
                                    .add(rr.getRow(QuoteItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = RateAmount.class, prefix = "ram")
        default Map<String, WorkEffort> chainRateAmount(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainRateAmount(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = RateAmount.class, prefix = "ram")
        default Map<String, WorkEffort> chainRateAmount(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(RATE_AMOUNT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("ram_work_effort_id", String.class) != null) {
                            p.getRelRateAmount()
                                    .add(rr.getRow(RateAmount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = Shipment.class, prefix = "essm")
        default Map<String, WorkEffort> chainEstimatedShipShipment(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainEstimatedShipShipment(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = Shipment.class, prefix = "essm")
        default Map<String, WorkEffort> chainEstimatedShipShipment(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ESTIMATED_SHIP_SHIPMENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("essm_estimated_ship_work_eff_id", String.class) != null) {
                            p.getRelEstimatedShipShipment()
                                    .add(rr.getRow(Shipment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = Shipment.class, prefix = "easm")
        default Map<String, WorkEffort> chainEstimatedArrivalShipment(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainEstimatedArrivalShipment(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = Shipment.class, prefix = "easm")
        default Map<String, WorkEffort> chainEstimatedArrivalShipment(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ESTIMATED_ARRIVAL_SHIPMENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("easm_estimated_arrival_work_eff_id", String.class) != null) {
                            p.getRelEstimatedArrivalShipment()
                                    .add(rr.getRow(Shipment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "cwem")
        default Map<String, WorkEffort> chainChildWorkEffort(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainChildWorkEffort(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "cwem")
        default Map<String, WorkEffort> chainChildWorkEffort(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHILD_WORK_EFFORT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("cwem_work_effort_parent_id", String.class) != null) {
                            p.getRelChildWorkEffort()
                                    .add(rr.getRow(WorkEffort.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffortAssoc.class, prefix = "fweam")
        default Map<String, WorkEffort> chainFromWorkEffortAssoc(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainFromWorkEffortAssoc(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffortAssoc.class, prefix = "fweam")
        default Map<String, WorkEffort> chainFromWorkEffortAssoc(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_WORK_EFFORT_ASSOC);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("fweam_work_effort_id_from", String.class) != null) {
                            p.getRelFromWorkEffortAssoc()
                                    .add(rr.getRow(WorkEffortAssoc.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffortAssoc.class, prefix = "tweam")
        default Map<String, WorkEffort> chainToWorkEffortAssoc(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainToWorkEffortAssoc(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffortAssoc.class, prefix = "tweam")
        default Map<String, WorkEffort> chainToWorkEffortAssoc(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_WORK_EFFORT_ASSOC);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("tweam_work_effort_id_to", String.class) != null) {
                            p.getRelToWorkEffortAssoc()
                                    .add(rr.getRow(WorkEffortAssoc.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffortFixedAssetAssign.class, prefix = "wefaam")
        default Map<String, WorkEffort> chainWorkEffortFixedAssetAssign(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainWorkEffortFixedAssetAssign(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffortFixedAssetAssign.class, prefix = "wefaam")
        default Map<String, WorkEffort> chainWorkEffortFixedAssetAssign(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WORK_EFFORT_FIXED_ASSET_ASSIGN);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("wefaam_work_effort_id", String.class) != null) {
                            p.getRelWorkEffortFixedAssetAssign()
                                    .add(rr.getRow(WorkEffortFixedAssetAssign.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffortGoodStandard.class, prefix = "wegsm")
        default Map<String, WorkEffort> chainWorkEffortGoodStandard(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainWorkEffortGoodStandard(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffortGoodStandard.class, prefix = "wegsm")
        default Map<String, WorkEffort> chainWorkEffortGoodStandard(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WORK_EFFORT_GOOD_STANDARD);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("wegsm_work_effort_id", String.class) != null) {
                            p.getRelWorkEffortGoodStandard()
                                    .add(rr.getRow(WorkEffortGoodStandard.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffortPartyAssignment.class, prefix = "wepam")
        default Map<String, WorkEffort> chainWorkEffortPartyAssignment(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainWorkEffortPartyAssignment(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffortPartyAssignment.class, prefix = "wepam")
        default Map<String, WorkEffort> chainWorkEffortPartyAssignment(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WORK_EFFORT_PARTY_ASSIGNMENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("wepam_work_effort_id", String.class) != null) {
                            p.getRelWorkEffortPartyAssignment()
                                    .add(rr.getRow(WorkEffortPartyAssignment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffortSkillStandard.class, prefix = "wessm")
        default Map<String, WorkEffort> chainWorkEffortSkillStandard(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainWorkEffortSkillStandard(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = WorkEffortSkillStandard.class, prefix = "wessm")
        default Map<String, WorkEffort> chainWorkEffortSkillStandard(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WORK_EFFORT_SKILL_STANDARD);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("wessm_work_effort_id", String.class) != null) {
                            p.getRelWorkEffortSkillStandard()
                                    .add(rr.getRow(WorkEffortSkillStandard.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, WorkEffort> chainTenant(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WorkEffort.class, prefix = "we")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, WorkEffort> chainTenant(ProtoMeta protoMeta,
                                               Map<String, WorkEffort> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WorkEffort", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WorkEffort p = map.computeIfAbsent(rr.getColumn("we_work_effort_id", String.class),
                                id -> rr.getRow(WorkEffort.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, WorkEffort>> parentWorkEffort(Dao dao, boolean succ) {
        return e -> dao.chainParentWorkEffort(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> parentWorkEffort(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainParentWorkEffort(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> fixedAsset(Dao dao, boolean succ) {
        return e -> dao.chainFixedAsset(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> fixedAsset(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFixedAsset(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> facility(Dao dao, boolean succ) {
        return e -> dao.chainFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> facility(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> recurrenceInfo(Dao dao, boolean succ) {
        return e -> dao.chainRecurrenceInfo(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> recurrenceInfo(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainRecurrenceInfo(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> temporalExpression(Dao dao, boolean succ) {
        return e -> dao.chainTemporalExpression(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> temporalExpression(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTemporalExpression(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> customMethod(Dao dao, boolean succ) {
        return e -> dao.chainCustomMethod(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> customMethod(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCustomMethod(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> acctgTrans(Dao dao, boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> acctgTrans(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> inventoryItemDetail(Dao dao, boolean succ) {
        return e -> dao.chainInventoryItemDetail(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> inventoryItemDetail(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainInventoryItemDetail(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> routingProductAssoc(Dao dao, boolean succ) {
        return e -> dao.chainRoutingProductAssoc(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> routingProductAssoc(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainRoutingProductAssoc(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> quoteItem(Dao dao, boolean succ) {
        return e -> dao.chainQuoteItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> quoteItem(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainQuoteItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> rateAmount(Dao dao, boolean succ) {
        return e -> dao.chainRateAmount(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> rateAmount(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainRateAmount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> estimatedShipShipment(Dao dao, boolean succ) {
        return e -> dao.chainEstimatedShipShipment(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> estimatedShipShipment(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainEstimatedShipShipment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> estimatedArrivalShipment(Dao dao, boolean succ) {
        return e -> dao.chainEstimatedArrivalShipment(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> estimatedArrivalShipment(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainEstimatedArrivalShipment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> childWorkEffort(Dao dao, boolean succ) {
        return e -> dao.chainChildWorkEffort(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> childWorkEffort(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainChildWorkEffort(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> fromWorkEffortAssoc(Dao dao, boolean succ) {
        return e -> dao.chainFromWorkEffortAssoc(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> fromWorkEffortAssoc(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFromWorkEffortAssoc(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> toWorkEffortAssoc(Dao dao, boolean succ) {
        return e -> dao.chainToWorkEffortAssoc(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> toWorkEffortAssoc(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainToWorkEffortAssoc(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> workEffortFixedAssetAssign(Dao dao, boolean succ) {
        return e -> dao.chainWorkEffortFixedAssetAssign(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> workEffortFixedAssetAssign(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainWorkEffortFixedAssetAssign(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> workEffortGoodStandard(Dao dao, boolean succ) {
        return e -> dao.chainWorkEffortGoodStandard(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> workEffortGoodStandard(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainWorkEffortGoodStandard(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> workEffortPartyAssignment(Dao dao, boolean succ) {
        return e -> dao.chainWorkEffortPartyAssignment(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> workEffortPartyAssignment(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainWorkEffortPartyAssignment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> workEffortSkillStandard(Dao dao, boolean succ) {
        return e -> dao.chainWorkEffortSkillStandard(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> workEffortSkillStandard(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainWorkEffortSkillStandard(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WorkEffort>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, WorkEffort>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, WorkEffort> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, WorkEffort> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, WorkEffort> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, WorkEffort> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, WorkEffort>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(PARENT_WORK_EFFORT)) {
            chain = chain.andThen(parentWorkEffort(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FIXED_ASSET)) {
            chain = chain.andThen(fixedAsset(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FACILITY)) {
            chain = chain.andThen(facility(dao, whereClause, binds, true));
        }
         
        if (incls.contains(RECURRENCE_INFO)) {
            chain = chain.andThen(recurrenceInfo(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TEMPORAL_EXPRESSION)) {
            chain = chain.andThen(temporalExpression(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CUSTOM_METHOD)) {
            chain = chain.andThen(customMethod(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ACCTG_TRANS)) {
            chain = chain.andThen(acctgTrans(dao, whereClause, binds, true));
        }
         
        if (incls.contains(INVENTORY_ITEM_DETAIL)) {
            chain = chain.andThen(inventoryItemDetail(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ROUTING_PRODUCT_ASSOC)) {
            chain = chain.andThen(routingProductAssoc(dao, whereClause, binds, true));
        }
         
        if (incls.contains(QUOTE_ITEM)) {
            chain = chain.andThen(quoteItem(dao, whereClause, binds, true));
        }
         
        if (incls.contains(RATE_AMOUNT)) {
            chain = chain.andThen(rateAmount(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ESTIMATED_SHIP_SHIPMENT)) {
            chain = chain.andThen(estimatedShipShipment(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ESTIMATED_ARRIVAL_SHIPMENT)) {
            chain = chain.andThen(estimatedArrivalShipment(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CHILD_WORK_EFFORT)) {
            chain = chain.andThen(childWorkEffort(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FROM_WORK_EFFORT_ASSOC)) {
            chain = chain.andThen(fromWorkEffortAssoc(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TO_WORK_EFFORT_ASSOC)) {
            chain = chain.andThen(toWorkEffortAssoc(dao, whereClause, binds, true));
        }
         
        if (incls.contains(WORK_EFFORT_FIXED_ASSET_ASSIGN)) {
            chain = chain.andThen(workEffortFixedAssetAssign(dao, whereClause, binds, true));
        }
         
        if (incls.contains(WORK_EFFORT_GOOD_STANDARD)) {
            chain = chain.andThen(workEffortGoodStandard(dao, whereClause, binds, true));
        }
         
        if (incls.contains(WORK_EFFORT_PARTY_ASSIGNMENT)) {
            chain = chain.andThen(workEffortPartyAssignment(dao, whereClause, binds, true));
        }
         
        if (incls.contains(WORK_EFFORT_SKILL_STANDARD)) {
            chain = chain.andThen(workEffortSkillStandard(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, whereClause, binds, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<WorkEffortData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<WorkEffortData> responseObserver) {

        Map<String, WorkEffort> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            WorkEffortData.Builder workEffortData = data.toHeadBuilder();
             
            data.getRelParentWorkEffort().forEach(e -> 
                workEffortData.setParentWorkEffort(e.toHeadBuilder())); 
            data.getRelFixedAsset().forEach(e -> 
                workEffortData.setFixedAsset(e.toHeadBuilder())); 
            data.getRelFacility().forEach(e -> 
                workEffortData.setFacility(e.toDataBuilder())); 
            data.getRelRecurrenceInfo().forEach(e -> 
                workEffortData.setRecurrenceInfo(e.toDataBuilder())); 
            data.getRelTemporalExpression().forEach(e -> 
                workEffortData.setTemporalExpression(e.toDataBuilder())); 
            data.getRelCustomMethod().forEach(e -> 
                workEffortData.setCustomMethod(e.toDataBuilder())); 
            data.getRelAcctgTrans().forEach(e -> 
                workEffortData.addAcctgTrans(e.toDataBuilder())); 
            data.getRelInventoryItemDetail().forEach(e -> 
                workEffortData.addInventoryItemDetail(e.toDataBuilder())); 
            data.getRelRoutingProductAssoc().forEach(e -> 
                workEffortData.addRoutingProductAssoc(e.toDataBuilder())); 
            data.getRelQuoteItem().forEach(e -> 
                workEffortData.addQuoteItem(e.toDataBuilder())); 
            data.getRelRateAmount().forEach(e -> 
                workEffortData.addRateAmount(e.toDataBuilder())); 
            data.getRelEstimatedShipShipment().forEach(e -> 
                workEffortData.addEstimatedShipShipment(e.toHeadBuilder())); 
            data.getRelEstimatedArrivalShipment().forEach(e -> 
                workEffortData.addEstimatedArrivalShipment(e.toHeadBuilder())); 
            data.getRelChildWorkEffort().forEach(e -> 
                workEffortData.addChildWorkEffort(e.toHeadBuilder())); 
            data.getRelFromWorkEffortAssoc().forEach(e -> 
                workEffortData.addFromWorkEffortAssoc(e.toDataBuilder())); 
            data.getRelToWorkEffortAssoc().forEach(e -> 
                workEffortData.addToWorkEffortAssoc(e.toDataBuilder())); 
            data.getRelWorkEffortFixedAssetAssign().forEach(e -> 
                workEffortData.addWorkEffortFixedAssetAssign(e.toDataBuilder())); 
            data.getRelWorkEffortGoodStandard().forEach(e -> 
                workEffortData.addWorkEffortGoodStandard(e.toDataBuilder())); 
            data.getRelWorkEffortPartyAssignment().forEach(e -> 
                workEffortData.addWorkEffortPartyAssignment(e.toDataBuilder())); 
            data.getRelWorkEffortSkillStandard().forEach(e -> 
                workEffortData.addWorkEffortSkillStandard(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                workEffortData.setTenant(e.toDataBuilder()));
            return workEffortData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public WorkEffort get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getWorkEffort(id);
    }

    @Get("/work_efforts/:id")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public WorkEffort get(@Param String id){
        return single(c -> get(c, id));
    }

    public List<WorkEffort> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listWorkEffort();
    }

    @Get("/work_efforts")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Collection<WorkEffort> all(){
        return collect(c -> all(c));
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countWorkEffort();
    }

    @Get("/work_efforts/count")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Integer count(){
        return single(c -> count(c));
    }

    @Post("/work_efforts")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(WorkEffort workEffort){
        return store(workEffort, true);
    }

    @Put("/work_efforts")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String storeOrUpdate(WorkEffort workEffort){
        return store(workEffort, false);
    }

    public String store(WorkEffort workEffort, boolean genId){
        process(c ->{
            if(genId){
                workEffort.setWorkEffortId(sequence.nextStringId());
            }
            storeOrUpdate(c, workEffort.toData());
        });
        return workEffort.getWorkEffortId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "WorkEffort", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final WorkEffort rec;
        final Message p1;
        WorkEffort persistObject;

        Agent(IProc.ProcContext ctx, WorkEffort rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public WorkEffort getRecord(){
            return rec;
        }

        public WorkEffort merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<WorkEffort> getParentWorkEffort(){
            return getRelationValues(ctx, p1, "parent_work_effort", WorkEffort.class);
        }

        public List<WorkEffort> mergeParentWorkEffort(){
            return getParentWorkEffort().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelParentWorkEffort().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FixedAsset> getFixedAsset(){
            return getRelationValues(ctx, p1, "fixed_asset", FixedAsset.class);
        }

        public List<FixedAsset> mergeFixedAsset(){
            return getFixedAsset().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFixedAsset().add(c))
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
         
        public List<RecurrenceInfo> getRecurrenceInfo(){
            return getRelationValues(ctx, p1, "recurrence_info", RecurrenceInfo.class);
        }

        public List<RecurrenceInfo> mergeRecurrenceInfo(){
            return getRecurrenceInfo().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelRecurrenceInfo().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<TemporalExpression> getTemporalExpression(){
            return getRelationValues(ctx, p1, "temporal_expression", TemporalExpression.class);
        }

        public List<TemporalExpression> mergeTemporalExpression(){
            return getTemporalExpression().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelTemporalExpression().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CustomMethod> getCustomMethod(){
            return getRelationValues(ctx, p1, "custom_method", CustomMethod.class);
        }

        public List<CustomMethod> mergeCustomMethod(){
            return getCustomMethod().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCustomMethod().add(c))
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
         
        public List<InventoryItemDetail> getInventoryItemDetail(){
            return getRelationValues(ctx, p1, "inventory_item_detail", InventoryItemDetail.class);
        }

        public List<InventoryItemDetail> mergeInventoryItemDetail(){
            return getInventoryItemDetail().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInventoryItemDetail().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductAssoc> getRoutingProductAssoc(){
            return getRelationValues(ctx, p1, "routing_product_assoc", ProductAssoc.class);
        }

        public List<ProductAssoc> mergeRoutingProductAssoc(){
            return getRoutingProductAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelRoutingProductAssoc().add(c))
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
         
        public List<RateAmount> getRateAmount(){
            return getRelationValues(ctx, p1, "rate_amount", RateAmount.class);
        }

        public List<RateAmount> mergeRateAmount(){
            return getRateAmount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelRateAmount().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Shipment> getEstimatedShipShipment(){
            return getRelationValues(ctx, p1, "estimated_ship_shipment", Shipment.class);
        }

        public List<Shipment> mergeEstimatedShipShipment(){
            return getEstimatedShipShipment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelEstimatedShipShipment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Shipment> getEstimatedArrivalShipment(){
            return getRelationValues(ctx, p1, "estimated_arrival_shipment", Shipment.class);
        }

        public List<Shipment> mergeEstimatedArrivalShipment(){
            return getEstimatedArrivalShipment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelEstimatedArrivalShipment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WorkEffort> getChildWorkEffort(){
            return getRelationValues(ctx, p1, "child_work_effort", WorkEffort.class);
        }

        public List<WorkEffort> mergeChildWorkEffort(){
            return getChildWorkEffort().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChildWorkEffort().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WorkEffortAssoc> getFromWorkEffortAssoc(){
            return getRelationValues(ctx, p1, "from_work_effort_assoc", WorkEffortAssoc.class);
        }

        public List<WorkEffortAssoc> mergeFromWorkEffortAssoc(){
            return getFromWorkEffortAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromWorkEffortAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WorkEffortAssoc> getToWorkEffortAssoc(){
            return getRelationValues(ctx, p1, "to_work_effort_assoc", WorkEffortAssoc.class);
        }

        public List<WorkEffortAssoc> mergeToWorkEffortAssoc(){
            return getToWorkEffortAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelToWorkEffortAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WorkEffortFixedAssetAssign> getWorkEffortFixedAssetAssign(){
            return getRelationValues(ctx, p1, "work_effort_fixed_asset_assign", WorkEffortFixedAssetAssign.class);
        }

        public List<WorkEffortFixedAssetAssign> mergeWorkEffortFixedAssetAssign(){
            return getWorkEffortFixedAssetAssign().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelWorkEffortFixedAssetAssign().add(c))
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
         
        public List<WorkEffortPartyAssignment> getWorkEffortPartyAssignment(){
            return getRelationValues(ctx, p1, "work_effort_party_assignment", WorkEffortPartyAssignment.class);
        }

        public List<WorkEffortPartyAssignment> mergeWorkEffortPartyAssignment(){
            return getWorkEffortPartyAssignment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelWorkEffortPartyAssignment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WorkEffortSkillStandard> getWorkEffortSkillStandard(){
            return getRelationValues(ctx, p1, "work_effort_skill_standard", WorkEffortSkillStandard.class);
        }

        public List<WorkEffortSkillStandard> mergeWorkEffortSkillStandard(){
            return getWorkEffortSkillStandard().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelWorkEffortSkillStandard().add(c))
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
        WorkEffortData p = WorkEffortData.newBuilder()
                .setWorkEffortId(key)
                .build();
        WorkEffort rec = findOne(ctx, p, WorkEffort.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, WorkEffort rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PARENT_WORK_EFFORT="parent_work_effort";
         
    public static final String FIXED_ASSET="fixed_asset";
         
    public static final String FACILITY="facility";
         
    public static final String RECURRENCE_INFO="recurrence_info";
         
    public static final String TEMPORAL_EXPRESSION="temporal_expression";
         
    public static final String CUSTOM_METHOD="custom_method";
         
    public static final String ACCTG_TRANS="acctg_trans";
         
    public static final String INVENTORY_ITEM_DETAIL="inventory_item_detail";
         
    public static final String ROUTING_PRODUCT_ASSOC="routing_product_assoc";
         
    public static final String QUOTE_ITEM="quote_item";
         
    public static final String RATE_AMOUNT="rate_amount";
         
    public static final String ESTIMATED_SHIP_SHIPMENT="estimated_ship_shipment";
         
    public static final String ESTIMATED_ARRIVAL_SHIPMENT="estimated_arrival_shipment";
         
    public static final String CHILD_WORK_EFFORT="child_work_effort";
         
    public static final String FROM_WORK_EFFORT_ASSOC="from_work_effort_assoc";
         
    public static final String TO_WORK_EFFORT_ASSOC="to_work_effort_assoc";
         
    public static final String WORK_EFFORT_FIXED_ASSET_ASSIGN="work_effort_fixed_asset_assign";
         
    public static final String WORK_EFFORT_GOOD_STANDARD="work_effort_good_standard";
         
    public static final String WORK_EFFORT_PARTY_ASSIGNMENT="work_effort_party_assignment";
         
    public static final String WORK_EFFORT_SKILL_STANDARD="work_effort_skill_standard";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryWorkEffortRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            WorkEffortData p = WorkEffortData.newBuilder()
                    .setWorkEffortId(key)
                    .build();
            List<WorkEffortData.Builder> ds = find(ctx, p, WorkEffort.class).stream()
                    .map(e -> {
                        WorkEffortData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set parent_work_effort to head entity                        
                        if(relationsDemand.contains("parent_work_effort")) {
                            getRelationValues(ctx, p1, "parent_work_effort",
                                            WorkEffort.class)
                                    .forEach(el -> pb.setParentWorkEffort(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set fixed_asset to head entity                        
                        if(relationsDemand.contains("fixed_asset")) {
                            getRelationValues(ctx, p1, "fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.setFixedAsset(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set facility to head entity                        
                        if(relationsDemand.contains("facility")) {
                            getRelationValues(ctx, p1, "facility",
                                            Facility.class)
                                    .forEach(el -> pb.setFacility(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set recurrence_info to head entity                        
                        if(relationsDemand.contains("recurrence_info")) {
                            getRelationValues(ctx, p1, "recurrence_info",
                                            RecurrenceInfo.class)
                                    .forEach(el -> pb.setRecurrenceInfo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set temporal_expression to head entity                        
                        if(relationsDemand.contains("temporal_expression")) {
                            getRelationValues(ctx, p1, "temporal_expression",
                                            TemporalExpression.class)
                                    .forEach(el -> pb.setTemporalExpression(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set custom_method to head entity                        
                        if(relationsDemand.contains("custom_method")) {
                            getRelationValues(ctx, p1, "custom_method",
                                            CustomMethod.class)
                                    .forEach(el -> pb.setCustomMethod(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set acctg_trans to head entity                        
                        if(relationsDemand.contains("acctg_trans")) {
                            getRelationValues(ctx, p1, "acctg_trans",
                                            AcctgTrans.class)
                                    .forEach(el -> pb.addAcctgTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set inventory_item_detail to head entity                        
                        if(relationsDemand.contains("inventory_item_detail")) {
                            getRelationValues(ctx, p1, "inventory_item_detail",
                                            InventoryItemDetail.class)
                                    .forEach(el -> pb.addInventoryItemDetail(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set routing_product_assoc to head entity                        
                        if(relationsDemand.contains("routing_product_assoc")) {
                            getRelationValues(ctx, p1, "routing_product_assoc",
                                            ProductAssoc.class)
                                    .forEach(el -> pb.addRoutingProductAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set quote_item to head entity                        
                        if(relationsDemand.contains("quote_item")) {
                            getRelationValues(ctx, p1, "quote_item",
                                            QuoteItem.class)
                                    .forEach(el -> pb.addQuoteItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set rate_amount to head entity                        
                        if(relationsDemand.contains("rate_amount")) {
                            getRelationValues(ctx, p1, "rate_amount",
                                            RateAmount.class)
                                    .forEach(el -> pb.addRateAmount(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set estimated_ship_shipment to head entity                        
                        if(relationsDemand.contains("estimated_ship_shipment")) {
                            getRelationValues(ctx, p1, "estimated_ship_shipment",
                                            Shipment.class)
                                    .forEach(el -> pb.addEstimatedShipShipment(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set estimated_arrival_shipment to head entity                        
                        if(relationsDemand.contains("estimated_arrival_shipment")) {
                            getRelationValues(ctx, p1, "estimated_arrival_shipment",
                                            Shipment.class)
                                    .forEach(el -> pb.addEstimatedArrivalShipment(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set child_work_effort to head entity                        
                        if(relationsDemand.contains("child_work_effort")) {
                            getRelationValues(ctx, p1, "child_work_effort",
                                            WorkEffort.class)
                                    .forEach(el -> pb.addChildWorkEffort(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set from_work_effort_assoc to head entity                        
                        if(relationsDemand.contains("from_work_effort_assoc")) {
                            getRelationValues(ctx, p1, "from_work_effort_assoc",
                                            WorkEffortAssoc.class)
                                    .forEach(el -> pb.addFromWorkEffortAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set to_work_effort_assoc to head entity                        
                        if(relationsDemand.contains("to_work_effort_assoc")) {
                            getRelationValues(ctx, p1, "to_work_effort_assoc",
                                            WorkEffortAssoc.class)
                                    .forEach(el -> pb.addToWorkEffortAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set work_effort_fixed_asset_assign to head entity                        
                        if(relationsDemand.contains("work_effort_fixed_asset_assign")) {
                            getRelationValues(ctx, p1, "work_effort_fixed_asset_assign",
                                            WorkEffortFixedAssetAssign.class)
                                    .forEach(el -> pb.addWorkEffortFixedAssetAssign(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set work_effort_good_standard to head entity                        
                        if(relationsDemand.contains("work_effort_good_standard")) {
                            getRelationValues(ctx, p1, "work_effort_good_standard",
                                            WorkEffortGoodStandard.class)
                                    .forEach(el -> pb.addWorkEffortGoodStandard(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set work_effort_party_assignment to head entity                        
                        if(relationsDemand.contains("work_effort_party_assignment")) {
                            getRelationValues(ctx, p1, "work_effort_party_assignment",
                                            WorkEffortPartyAssignment.class)
                                    .forEach(el -> pb.addWorkEffortPartyAssignment(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set work_effort_skill_standard to head entity                        
                        if(relationsDemand.contains("work_effort_skill_standard")) {
                            getRelationValues(ctx, p1, "work_effort_skill_standard",
                                            WorkEffortSkillStandard.class)
                                    .forEach(el -> pb.addWorkEffortSkillStandard(
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


    
    public WorkEffort.WorkEffortBuilder seed(){
        return WorkEffort.builder()
                .workEffortId(sequence.nextStringId());
    }
}
