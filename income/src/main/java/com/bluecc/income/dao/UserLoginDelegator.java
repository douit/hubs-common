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

import com.bluecc.hubs.stub.UserLoginData;

public class UserLoginDelegator extends AbstractProcs implements IChainQuery<UserLogin>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(UserLogin.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from user_login")
        List<UserLogin> listUserLogin();
        @SqlQuery("select * from user_login where user_login_id=:id")
        UserLogin getUserLogin(@Bind("id") String id);

        @SqlQuery("select count(*) from user_login")
        int countUserLogin();

        // for relations
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Party.class, prefix = "pao")
        default Map<String, UserLogin> chainParty(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainParty(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Party.class, prefix = "pao")
        default Map<String, UserLogin> chainParty(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("pao_party_id", String.class) != null) {
                            p.getRelParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Person.class, prefix = "peo")
        default Map<String, UserLogin> chainPerson(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainPerson(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Person.class, prefix = "peo")
        default Map<String, UserLogin> chainPerson(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PERSON);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("peo_party_id", String.class) != null) {
                            p.getRelPerson()
                                    .add(rr.getRow(Person.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pgo")
        default Map<String, UserLogin> chainPartyGroup(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainPartyGroup(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pgo")
        default Map<String, UserLogin> chainPartyGroup(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_GROUP);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("pgo_party_id", String.class) != null) {
                            p.getRelPartyGroup()
                                    .add(rr.getRow(PartyGroup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = BudgetStatus.class, prefix = "cbbsm")
        default Map<String, UserLogin> chainChangeByBudgetStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainChangeByBudgetStatus(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = BudgetStatus.class, prefix = "cbbsm")
        default Map<String, UserLogin> chainChangeByBudgetStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHANGE_BY_BUDGET_STATUS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbbsm_change_by_user_login_id", String.class) != null) {
                            p.getRelChangeByBudgetStatus()
                                    .add(rr.getRow(BudgetStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Content.class, prefix = "cbcm")
        default Map<String, UserLogin> chainCreatedByContent(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByContent(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Content.class, prefix = "cbcm")
        default Map<String, UserLogin> chainCreatedByContent(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_CONTENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbcm_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByContent()
                                    .add(rr.getRow(Content.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Content.class, prefix = "lmbcm")
        default Map<String, UserLogin> chainLastModifiedByContent(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByContent(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Content.class, prefix = "lmbcm")
        default Map<String, UserLogin> chainLastModifiedByContent(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_CONTENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbcm_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByContent()
                                    .add(rr.getRow(Content.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ContentAssoc.class, prefix = "cbcam")
        default Map<String, UserLogin> chainCreatedByContentAssoc(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByContentAssoc(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ContentAssoc.class, prefix = "cbcam")
        default Map<String, UserLogin> chainCreatedByContentAssoc(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_CONTENT_ASSOC);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbcam_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByContentAssoc()
                                    .add(rr.getRow(ContentAssoc.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ContentAssoc.class, prefix = "lmbcam")
        default Map<String, UserLogin> chainLastModifiedByContentAssoc(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByContentAssoc(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ContentAssoc.class, prefix = "lmbcam")
        default Map<String, UserLogin> chainLastModifiedByContentAssoc(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_CONTENT_ASSOC);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbcam_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByContentAssoc()
                                    .add(rr.getRow(ContentAssoc.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = DataResource.class, prefix = "cbdrm")
        default Map<String, UserLogin> chainCreatedByDataResource(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByDataResource(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = DataResource.class, prefix = "cbdrm")
        default Map<String, UserLogin> chainCreatedByDataResource(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_DATA_RESOURCE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbdrm_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByDataResource()
                                    .add(rr.getRow(DataResource.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = DataResource.class, prefix = "lmbdrm")
        default Map<String, UserLogin> chainLastModifiedByDataResource(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByDataResource(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = DataResource.class, prefix = "lmbdrm")
        default Map<String, UserLogin> chainLastModifiedByDataResource(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_DATA_RESOURCE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbdrm_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByDataResource()
                                    .add(rr.getRow(DataResource.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = FinAccountStatus.class, prefix = "fasm")
        default Map<String, UserLogin> chainFinAccountStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainFinAccountStatus(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = FinAccountStatus.class, prefix = "fasm")
        default Map<String, UserLogin> chainFinAccountStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIN_ACCOUNT_STATUS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("fasm_change_by_user_login_id", String.class) != null) {
                            p.getRelFinAccountStatus()
                                    .add(rr.getRow(FinAccountStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = InvoiceStatus.class, prefix = "cbism")
        default Map<String, UserLogin> chainChangeByInvoiceStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainChangeByInvoiceStatus(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = InvoiceStatus.class, prefix = "cbism")
        default Map<String, UserLogin> chainChangeByInvoiceStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHANGE_BY_INVOICE_STATUS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbism_change_by_user_login_id", String.class) != null) {
                            p.getRelChangeByInvoiceStatus()
                                    .add(rr.getRow(InvoiceStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ItemIssuance.class, prefix = "ibiim")
        default Map<String, UserLogin> chainIssuedByItemIssuance(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainIssuedByItemIssuance(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ItemIssuance.class, prefix = "ibiim")
        default Map<String, UserLogin> chainIssuedByItemIssuance(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ISSUED_BY_ITEM_ISSUANCE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("ibiim_issued_by_user_login_id", String.class) != null) {
                            p.getRelIssuedByItemIssuance()
                                    .add(rr.getRow(ItemIssuance.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = JobSandbox.class, prefix = "ajsm")
        default Map<String, UserLogin> chainAuthJobSandbox(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainAuthJobSandbox(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = JobSandbox.class, prefix = "ajsm")
        default Map<String, UserLogin> chainAuthJobSandbox(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(AUTH_JOB_SANDBOX);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("ajsm_auth_user_login_id", String.class) != null) {
                            p.getRelAuthJobSandbox()
                                    .add(rr.getRow(JobSandbox.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = JobSandbox.class, prefix = "rajsm")
        default Map<String, UserLogin> chainRunAsJobSandbox(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainRunAsJobSandbox(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = JobSandbox.class, prefix = "rajsm")
        default Map<String, UserLogin> chainRunAsJobSandbox(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(RUN_AS_JOB_SANDBOX);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("rajsm_run_as_user", String.class) != null) {
                            p.getRelRunAsJobSandbox()
                                    .add(rr.getRow(JobSandbox.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderAdjustment.class, prefix = "oam")
        default Map<String, UserLogin> chainOrderAdjustment(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainOrderAdjustment(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderAdjustment.class, prefix = "oam")
        default Map<String, UserLogin> chainOrderAdjustment(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ADJUSTMENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("oam_created_by_user_login", String.class) != null) {
                            p.getRelOrderAdjustment()
                                    .add(rr.getRow(OrderAdjustment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "cbohm")
        default Map<String, UserLogin> chainCreatedByOrderHeader(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByOrderHeader(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "cbohm")
        default Map<String, UserLogin> chainCreatedByOrderHeader(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_ORDER_HEADER);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbohm_created_by", String.class) != null) {
                            p.getRelCreatedByOrderHeader()
                                    .add(rr.getRow(OrderHeader.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "dcsoim")
        default Map<String, UserLogin> chainDontCancelSetOrderItem(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainDontCancelSetOrderItem(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "dcsoim")
        default Map<String, UserLogin> chainDontCancelSetOrderItem(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(DONT_CANCEL_SET_ORDER_ITEM);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("dcsoim_dont_cancel_set_user_login", String.class) != null) {
                            p.getRelDontCancelSetOrderItem()
                                    .add(rr.getRow(OrderItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "cboim")
        default Map<String, UserLogin> chainChangeByOrderItem(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainChangeByOrderItem(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "cboim")
        default Map<String, UserLogin> chainChangeByOrderItem(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHANGE_BY_ORDER_ITEM);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cboim_change_by_user_login_id", String.class) != null) {
                            p.getRelChangeByOrderItem()
                                    .add(rr.getRow(OrderItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "oppm")
        default Map<String, UserLogin> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainOrderPaymentPreference(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "oppm")
        default Map<String, UserLogin> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_PAYMENT_PREFERENCE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("oppm_created_by_user_login", String.class) != null) {
                            p.getRelOrderPaymentPreference()
                                    .add(rr.getRow(OrderPaymentPreference.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderStatus.class, prefix = "osm")
        default Map<String, UserLogin> chainOrderStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainOrderStatus(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderStatus.class, prefix = "osm")
        default Map<String, UserLogin> chainOrderStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_STATUS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("osm_status_user_login", String.class) != null) {
                            p.getRelOrderStatus()
                                    .add(rr.getRow(OrderStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Party.class, prefix = "cbpm")
        default Map<String, UserLogin> chainCreatedByParty(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByParty(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Party.class, prefix = "cbpm")
        default Map<String, UserLogin> chainCreatedByParty(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_PARTY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbpm_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Party.class, prefix = "lmbpm")
        default Map<String, UserLogin> chainLastModifiedByParty(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByParty(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Party.class, prefix = "lmbpm")
        default Map<String, UserLogin> chainLastModifiedByParty(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_PARTY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbpm_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = PartyStatus.class, prefix = "cbpsm")
        default Map<String, UserLogin> chainChangeByPartyStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainChangeByPartyStatus(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = PartyStatus.class, prefix = "cbpsm")
        default Map<String, UserLogin> chainChangeByPartyStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHANGE_BY_PARTY_STATUS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbpsm_change_by_user_login_id", String.class) != null) {
                            p.getRelChangeByPartyStatus()
                                    .add(rr.getRow(PartyStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Product.class, prefix = "cbpm")
        default Map<String, UserLogin> chainCreatedByProduct(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByProduct(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Product.class, prefix = "cbpm")
        default Map<String, UserLogin> chainCreatedByProduct(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_PRODUCT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbpm_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByProduct()
                                    .add(rr.getRow(Product.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Product.class, prefix = "lmbpm")
        default Map<String, UserLogin> chainLastModifiedByProduct(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByProduct(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Product.class, prefix = "lmbpm")
        default Map<String, UserLogin> chainLastModifiedByProduct(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_PRODUCT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbpm_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByProduct()
                                    .add(rr.getRow(Product.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductFeaturePrice.class, prefix = "cbpfpm")
        default Map<String, UserLogin> chainCreatedByProductFeaturePrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByProductFeaturePrice(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductFeaturePrice.class, prefix = "cbpfpm")
        default Map<String, UserLogin> chainCreatedByProductFeaturePrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_PRODUCT_FEATURE_PRICE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbpfpm_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByProductFeaturePrice()
                                    .add(rr.getRow(ProductFeaturePrice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductFeaturePrice.class, prefix = "lmbpfpm")
        default Map<String, UserLogin> chainLastModifiedByProductFeaturePrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByProductFeaturePrice(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductFeaturePrice.class, prefix = "lmbpfpm")
        default Map<String, UserLogin> chainLastModifiedByProductFeaturePrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_PRODUCT_FEATURE_PRICE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbpfpm_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByProductFeaturePrice()
                                    .add(rr.getRow(ProductFeaturePrice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPrice.class, prefix = "cbppm")
        default Map<String, UserLogin> chainCreatedByProductPrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByProductPrice(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPrice.class, prefix = "cbppm")
        default Map<String, UserLogin> chainCreatedByProductPrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_PRODUCT_PRICE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbppm_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByProductPrice()
                                    .add(rr.getRow(ProductPrice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPrice.class, prefix = "lmbppm")
        default Map<String, UserLogin> chainLastModifiedByProductPrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByProductPrice(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPrice.class, prefix = "lmbppm")
        default Map<String, UserLogin> chainLastModifiedByProductPrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_PRODUCT_PRICE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbppm_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByProductPrice()
                                    .add(rr.getRow(ProductPrice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromo.class, prefix = "cbppm")
        default Map<String, UserLogin> chainCreatedByProductPromo(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByProductPromo(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromo.class, prefix = "cbppm")
        default Map<String, UserLogin> chainCreatedByProductPromo(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_PRODUCT_PROMO);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbppm_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByProductPromo()
                                    .add(rr.getRow(ProductPromo.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromo.class, prefix = "lmbppm")
        default Map<String, UserLogin> chainLastModifiedByProductPromo(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByProductPromo(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromo.class, prefix = "lmbppm")
        default Map<String, UserLogin> chainLastModifiedByProductPromo(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_PRODUCT_PROMO);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbppm_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByProductPromo()
                                    .add(rr.getRow(ProductPromo.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromoCode.class, prefix = "cbppcm")
        default Map<String, UserLogin> chainCreatedByProductPromoCode(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByProductPromoCode(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromoCode.class, prefix = "cbppcm")
        default Map<String, UserLogin> chainCreatedByProductPromoCode(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_PRODUCT_PROMO_CODE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbppcm_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByProductPromoCode()
                                    .add(rr.getRow(ProductPromoCode.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromoCode.class, prefix = "lmbppcm")
        default Map<String, UserLogin> chainLastModifiedByProductPromoCode(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByProductPromoCode(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromoCode.class, prefix = "lmbppcm")
        default Map<String, UserLogin> chainLastModifiedByProductPromoCode(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_PRODUCT_PROMO_CODE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbppcm_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByProductPromoCode()
                                    .add(rr.getRow(ProductPromoCode.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductReview.class, prefix = "prm")
        default Map<String, UserLogin> chainProductReview(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainProductReview(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductReview.class, prefix = "prm")
        default Map<String, UserLogin> chainProductReview(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_REVIEW);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("prm_user_login_id", String.class) != null) {
                            p.getRelProductReview()
                                    .add(rr.getRow(ProductReview.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "srm")
        default Map<String, UserLogin> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainShipmentReceipt(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "srm")
        default Map<String, UserLogin> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_RECEIPT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("srm_received_by_user_login_id", String.class) != null) {
                            p.getRelShipmentReceipt()
                                    .add(rr.getRow(ShipmentReceipt.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ShipmentStatus.class, prefix = "cbssm")
        default Map<String, UserLogin> chainChangeByShipmentStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainChangeByShipmentStatus(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ShipmentStatus.class, prefix = "cbssm")
        default Map<String, UserLogin> chainChangeByShipmentStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHANGE_BY_SHIPMENT_STATUS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbssm_change_by_user_login_id", String.class) != null) {
                            p.getRelChangeByShipmentStatus()
                                    .add(rr.getRow(ShipmentStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = UserLoginSecurityGroup.class, prefix = "ulsgm")
        default Map<String, UserLogin> chainUserLoginSecurityGroup(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainUserLoginSecurityGroup(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = UserLoginSecurityGroup.class, prefix = "ulsgm")
        default Map<String, UserLogin> chainUserLoginSecurityGroup(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(USER_LOGIN_SECURITY_GROUP);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("ulsgm_user_login_id", String.class) != null) {
                            p.getRelUserLoginSecurityGroup()
                                    .add(rr.getRow(UserLoginSecurityGroup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = WorkEffortPartyAssignment.class, prefix = "abwepam")
        default Map<String, UserLogin> chainAssignedByWorkEffortPartyAssignment(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainAssignedByWorkEffortPartyAssignment(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = WorkEffortPartyAssignment.class, prefix = "abwepam")
        default Map<String, UserLogin> chainAssignedByWorkEffortPartyAssignment(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ASSIGNED_BY_WORK_EFFORT_PARTY_ASSIGNMENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("abwepam_assigned_by_user_login_id", String.class) != null) {
                            p.getRelAssignedByWorkEffortPartyAssignment()
                                    .add(rr.getRow(WorkEffortPartyAssignment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, UserLogin> chainTenant(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, UserLogin> chainTenant(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, UserLogin>> party(Dao dao, boolean succ) {
        return e -> dao.chainParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> party(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> person(Dao dao, boolean succ) {
        return e -> dao.chainPerson(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> person(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPerson(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> partyGroup(Dao dao, boolean succ) {
        return e -> dao.chainPartyGroup(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> partyGroup(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPartyGroup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> changeByBudgetStatus(Dao dao, boolean succ) {
        return e -> dao.chainChangeByBudgetStatus(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> changeByBudgetStatus(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainChangeByBudgetStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> createdByContent(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByContent(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> createdByContent(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByContent(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> lastModifiedByContent(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByContent(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> lastModifiedByContent(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByContent(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> createdByContentAssoc(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByContentAssoc(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> createdByContentAssoc(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByContentAssoc(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> lastModifiedByContentAssoc(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByContentAssoc(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> lastModifiedByContentAssoc(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByContentAssoc(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> createdByDataResource(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByDataResource(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> createdByDataResource(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByDataResource(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> lastModifiedByDataResource(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByDataResource(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> lastModifiedByDataResource(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByDataResource(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> finAccountStatus(Dao dao, boolean succ) {
        return e -> dao.chainFinAccountStatus(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> finAccountStatus(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFinAccountStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> changeByInvoiceStatus(Dao dao, boolean succ) {
        return e -> dao.chainChangeByInvoiceStatus(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> changeByInvoiceStatus(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainChangeByInvoiceStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> issuedByItemIssuance(Dao dao, boolean succ) {
        return e -> dao.chainIssuedByItemIssuance(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> issuedByItemIssuance(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainIssuedByItemIssuance(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> authJobSandbox(Dao dao, boolean succ) {
        return e -> dao.chainAuthJobSandbox(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> authJobSandbox(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainAuthJobSandbox(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> runAsJobSandbox(Dao dao, boolean succ) {
        return e -> dao.chainRunAsJobSandbox(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> runAsJobSandbox(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainRunAsJobSandbox(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> orderAdjustment(Dao dao, boolean succ) {
        return e -> dao.chainOrderAdjustment(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> orderAdjustment(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderAdjustment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> createdByOrderHeader(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByOrderHeader(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> createdByOrderHeader(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByOrderHeader(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> dontCancelSetOrderItem(Dao dao, boolean succ) {
        return e -> dao.chainDontCancelSetOrderItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> dontCancelSetOrderItem(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainDontCancelSetOrderItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> changeByOrderItem(Dao dao, boolean succ) {
        return e -> dao.chainChangeByOrderItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> changeByOrderItem(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainChangeByOrderItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> orderPaymentPreference(Dao dao, boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> orderPaymentPreference(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> orderStatus(Dao dao, boolean succ) {
        return e -> dao.chainOrderStatus(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> orderStatus(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> createdByParty(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> createdByParty(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> lastModifiedByParty(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> lastModifiedByParty(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> changeByPartyStatus(Dao dao, boolean succ) {
        return e -> dao.chainChangeByPartyStatus(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> changeByPartyStatus(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainChangeByPartyStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> createdByProduct(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> createdByProduct(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> lastModifiedByProduct(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> lastModifiedByProduct(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> createdByProductFeaturePrice(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByProductFeaturePrice(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> createdByProductFeaturePrice(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByProductFeaturePrice(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> lastModifiedByProductFeaturePrice(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByProductFeaturePrice(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> lastModifiedByProductFeaturePrice(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByProductFeaturePrice(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> createdByProductPrice(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByProductPrice(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> createdByProductPrice(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByProductPrice(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> lastModifiedByProductPrice(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByProductPrice(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> lastModifiedByProductPrice(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByProductPrice(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> createdByProductPromo(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByProductPromo(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> createdByProductPromo(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByProductPromo(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> lastModifiedByProductPromo(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByProductPromo(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> lastModifiedByProductPromo(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByProductPromo(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> createdByProductPromoCode(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByProductPromoCode(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> createdByProductPromoCode(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByProductPromoCode(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> lastModifiedByProductPromoCode(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByProductPromoCode(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> lastModifiedByProductPromoCode(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByProductPromoCode(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> productReview(Dao dao, boolean succ) {
        return e -> dao.chainProductReview(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> productReview(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductReview(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> shipmentReceipt(Dao dao, boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> shipmentReceipt(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> changeByShipmentStatus(Dao dao, boolean succ) {
        return e -> dao.chainChangeByShipmentStatus(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> changeByShipmentStatus(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainChangeByShipmentStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> userLoginSecurityGroup(Dao dao, boolean succ) {
        return e -> dao.chainUserLoginSecurityGroup(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> userLoginSecurityGroup(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainUserLoginSecurityGroup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> assignedByWorkEffortPartyAssignment(Dao dao, boolean succ) {
        return e -> dao.chainAssignedByWorkEffortPartyAssignment(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> assignedByWorkEffortPartyAssignment(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainAssignedByWorkEffortPartyAssignment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, UserLogin>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, UserLogin>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, UserLogin> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, UserLogin> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, UserLogin> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, UserLogin> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, UserLogin>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(PARTY)) {
            chain = chain.andThen(party(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PERSON)) {
            chain = chain.andThen(person(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PARTY_GROUP)) {
            chain = chain.andThen(partyGroup(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CHANGE_BY_BUDGET_STATUS)) {
            chain = chain.andThen(changeByBudgetStatus(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CREATED_BY_CONTENT)) {
            chain = chain.andThen(createdByContent(dao, whereClause, binds, true));
        }
         
        if (incls.contains(LAST_MODIFIED_BY_CONTENT)) {
            chain = chain.andThen(lastModifiedByContent(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CREATED_BY_CONTENT_ASSOC)) {
            chain = chain.andThen(createdByContentAssoc(dao, whereClause, binds, true));
        }
         
        if (incls.contains(LAST_MODIFIED_BY_CONTENT_ASSOC)) {
            chain = chain.andThen(lastModifiedByContentAssoc(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CREATED_BY_DATA_RESOURCE)) {
            chain = chain.andThen(createdByDataResource(dao, whereClause, binds, true));
        }
         
        if (incls.contains(LAST_MODIFIED_BY_DATA_RESOURCE)) {
            chain = chain.andThen(lastModifiedByDataResource(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FIN_ACCOUNT_STATUS)) {
            chain = chain.andThen(finAccountStatus(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CHANGE_BY_INVOICE_STATUS)) {
            chain = chain.andThen(changeByInvoiceStatus(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ISSUED_BY_ITEM_ISSUANCE)) {
            chain = chain.andThen(issuedByItemIssuance(dao, whereClause, binds, true));
        }
         
        if (incls.contains(AUTH_JOB_SANDBOX)) {
            chain = chain.andThen(authJobSandbox(dao, whereClause, binds, true));
        }
         
        if (incls.contains(RUN_AS_JOB_SANDBOX)) {
            chain = chain.andThen(runAsJobSandbox(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_ADJUSTMENT)) {
            chain = chain.andThen(orderAdjustment(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CREATED_BY_ORDER_HEADER)) {
            chain = chain.andThen(createdByOrderHeader(dao, whereClause, binds, true));
        }
         
        if (incls.contains(DONT_CANCEL_SET_ORDER_ITEM)) {
            chain = chain.andThen(dontCancelSetOrderItem(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CHANGE_BY_ORDER_ITEM)) {
            chain = chain.andThen(changeByOrderItem(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_PAYMENT_PREFERENCE)) {
            chain = chain.andThen(orderPaymentPreference(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_STATUS)) {
            chain = chain.andThen(orderStatus(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CREATED_BY_PARTY)) {
            chain = chain.andThen(createdByParty(dao, whereClause, binds, true));
        }
         
        if (incls.contains(LAST_MODIFIED_BY_PARTY)) {
            chain = chain.andThen(lastModifiedByParty(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CHANGE_BY_PARTY_STATUS)) {
            chain = chain.andThen(changeByPartyStatus(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CREATED_BY_PRODUCT)) {
            chain = chain.andThen(createdByProduct(dao, whereClause, binds, true));
        }
         
        if (incls.contains(LAST_MODIFIED_BY_PRODUCT)) {
            chain = chain.andThen(lastModifiedByProduct(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CREATED_BY_PRODUCT_FEATURE_PRICE)) {
            chain = chain.andThen(createdByProductFeaturePrice(dao, whereClause, binds, true));
        }
         
        if (incls.contains(LAST_MODIFIED_BY_PRODUCT_FEATURE_PRICE)) {
            chain = chain.andThen(lastModifiedByProductFeaturePrice(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CREATED_BY_PRODUCT_PRICE)) {
            chain = chain.andThen(createdByProductPrice(dao, whereClause, binds, true));
        }
         
        if (incls.contains(LAST_MODIFIED_BY_PRODUCT_PRICE)) {
            chain = chain.andThen(lastModifiedByProductPrice(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CREATED_BY_PRODUCT_PROMO)) {
            chain = chain.andThen(createdByProductPromo(dao, whereClause, binds, true));
        }
         
        if (incls.contains(LAST_MODIFIED_BY_PRODUCT_PROMO)) {
            chain = chain.andThen(lastModifiedByProductPromo(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CREATED_BY_PRODUCT_PROMO_CODE)) {
            chain = chain.andThen(createdByProductPromoCode(dao, whereClause, binds, true));
        }
         
        if (incls.contains(LAST_MODIFIED_BY_PRODUCT_PROMO_CODE)) {
            chain = chain.andThen(lastModifiedByProductPromoCode(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_REVIEW)) {
            chain = chain.andThen(productReview(dao, whereClause, binds, true));
        }
         
        if (incls.contains(SHIPMENT_RECEIPT)) {
            chain = chain.andThen(shipmentReceipt(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CHANGE_BY_SHIPMENT_STATUS)) {
            chain = chain.andThen(changeByShipmentStatus(dao, whereClause, binds, true));
        }
         
        if (incls.contains(USER_LOGIN_SECURITY_GROUP)) {
            chain = chain.andThen(userLoginSecurityGroup(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ASSIGNED_BY_WORK_EFFORT_PARTY_ASSIGNMENT)) {
            chain = chain.andThen(assignedByWorkEffortPartyAssignment(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, whereClause, binds, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<UserLoginData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<UserLoginData> responseObserver) {

        Map<String, UserLogin> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            UserLoginData.Builder userLoginData = data.toHeadBuilder();
             
            data.getRelParty().forEach(e -> 
                userLoginData.setParty(e.toHeadBuilder())); 
            data.getRelPerson().forEach(e -> 
                userLoginData.setPerson(e.toHeadBuilder())); 
            data.getRelPartyGroup().forEach(e -> 
                userLoginData.setPartyGroup(e.toHeadBuilder())); 
            data.getRelChangeByBudgetStatus().forEach(e -> 
                userLoginData.addChangeByBudgetStatus(e.toDataBuilder())); 
            data.getRelCreatedByContent().forEach(e -> 
                userLoginData.addCreatedByContent(e.toDataBuilder())); 
            data.getRelLastModifiedByContent().forEach(e -> 
                userLoginData.addLastModifiedByContent(e.toDataBuilder())); 
            data.getRelCreatedByContentAssoc().forEach(e -> 
                userLoginData.addCreatedByContentAssoc(e.toDataBuilder())); 
            data.getRelLastModifiedByContentAssoc().forEach(e -> 
                userLoginData.addLastModifiedByContentAssoc(e.toDataBuilder())); 
            data.getRelCreatedByDataResource().forEach(e -> 
                userLoginData.addCreatedByDataResource(e.toDataBuilder())); 
            data.getRelLastModifiedByDataResource().forEach(e -> 
                userLoginData.addLastModifiedByDataResource(e.toDataBuilder())); 
            data.getRelFinAccountStatus().forEach(e -> 
                userLoginData.addFinAccountStatus(e.toDataBuilder())); 
            data.getRelChangeByInvoiceStatus().forEach(e -> 
                userLoginData.addChangeByInvoiceStatus(e.toDataBuilder())); 
            data.getRelIssuedByItemIssuance().forEach(e -> 
                userLoginData.addIssuedByItemIssuance(e.toDataBuilder())); 
            data.getRelAuthJobSandbox().forEach(e -> 
                userLoginData.addAuthJobSandbox(e.toDataBuilder())); 
            data.getRelRunAsJobSandbox().forEach(e -> 
                userLoginData.addRunAsJobSandbox(e.toDataBuilder())); 
            data.getRelOrderAdjustment().forEach(e -> 
                userLoginData.addOrderAdjustment(e.toDataBuilder())); 
            data.getRelCreatedByOrderHeader().forEach(e -> 
                userLoginData.addCreatedByOrderHeader(e.toHeadBuilder())); 
            data.getRelDontCancelSetOrderItem().forEach(e -> 
                userLoginData.addDontCancelSetOrderItem(e.toHeadBuilder())); 
            data.getRelChangeByOrderItem().forEach(e -> 
                userLoginData.addChangeByOrderItem(e.toHeadBuilder())); 
            data.getRelOrderPaymentPreference().forEach(e -> 
                userLoginData.addOrderPaymentPreference(e.toDataBuilder())); 
            data.getRelOrderStatus().forEach(e -> 
                userLoginData.addOrderStatus(e.toDataBuilder())); 
            data.getRelCreatedByParty().forEach(e -> 
                userLoginData.addCreatedByParty(e.toHeadBuilder())); 
            data.getRelLastModifiedByParty().forEach(e -> 
                userLoginData.addLastModifiedByParty(e.toHeadBuilder())); 
            data.getRelChangeByPartyStatus().forEach(e -> 
                userLoginData.addChangeByPartyStatus(e.toDataBuilder())); 
            data.getRelCreatedByProduct().forEach(e -> 
                userLoginData.addCreatedByProduct(e.toHeadBuilder())); 
            data.getRelLastModifiedByProduct().forEach(e -> 
                userLoginData.addLastModifiedByProduct(e.toHeadBuilder())); 
            data.getRelCreatedByProductFeaturePrice().forEach(e -> 
                userLoginData.addCreatedByProductFeaturePrice(e.toDataBuilder())); 
            data.getRelLastModifiedByProductFeaturePrice().forEach(e -> 
                userLoginData.addLastModifiedByProductFeaturePrice(e.toDataBuilder())); 
            data.getRelCreatedByProductPrice().forEach(e -> 
                userLoginData.addCreatedByProductPrice(e.toDataBuilder())); 
            data.getRelLastModifiedByProductPrice().forEach(e -> 
                userLoginData.addLastModifiedByProductPrice(e.toDataBuilder())); 
            data.getRelCreatedByProductPromo().forEach(e -> 
                userLoginData.addCreatedByProductPromo(e.toDataBuilder())); 
            data.getRelLastModifiedByProductPromo().forEach(e -> 
                userLoginData.addLastModifiedByProductPromo(e.toDataBuilder())); 
            data.getRelCreatedByProductPromoCode().forEach(e -> 
                userLoginData.addCreatedByProductPromoCode(e.toDataBuilder())); 
            data.getRelLastModifiedByProductPromoCode().forEach(e -> 
                userLoginData.addLastModifiedByProductPromoCode(e.toDataBuilder())); 
            data.getRelProductReview().forEach(e -> 
                userLoginData.addProductReview(e.toDataBuilder())); 
            data.getRelShipmentReceipt().forEach(e -> 
                userLoginData.addShipmentReceipt(e.toDataBuilder())); 
            data.getRelChangeByShipmentStatus().forEach(e -> 
                userLoginData.addChangeByShipmentStatus(e.toDataBuilder())); 
            data.getRelUserLoginSecurityGroup().forEach(e -> 
                userLoginData.addUserLoginSecurityGroup(e.toDataBuilder())); 
            data.getRelAssignedByWorkEffortPartyAssignment().forEach(e -> 
                userLoginData.addAssignedByWorkEffortPartyAssignment(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                userLoginData.setTenant(e.toDataBuilder()));
            return userLoginData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public UserLogin get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getUserLogin(id);
    }

    @Get("/user_logins/:id")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public UserLogin get(@Param String id){
        return single(c -> get(c, id));
    }

    public List<UserLogin> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listUserLogin();
    }

    @Get("/user_logins")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Collection<UserLogin> all(){
        return collect(c -> all(c));
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countUserLogin();
    }

    @Get("/user_logins/count")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Integer count(){
        return single(c -> count(c));
    }

    @Post("/user_logins")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(UserLogin userLogin){
        return store(userLogin, true);
    }

    @Put("/user_logins")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String storeOrUpdate(UserLogin userLogin){
        return store(userLogin, false);
    }

    public String store(UserLogin userLogin, boolean genId){
        process(c ->{
            if(genId){
                userLogin.setUserLoginId(sequence.nextStringId());
            }
            storeOrUpdate(c, userLogin.toData());
        });
        return userLogin.getUserLoginId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "UserLogin", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final UserLogin rec;
        final Message p1;
        UserLogin persistObject;

        Agent(IProc.ProcContext ctx, UserLogin rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public UserLogin getRecord(){
            return rec;
        }

        public UserLogin merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
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
         
        public List<Person> getPerson(){
            return getRelationValues(ctx, p1, "person", Person.class);
        }

        public List<Person> mergePerson(){
            return getPerson().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPerson().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyGroup> getPartyGroup(){
            return getRelationValues(ctx, p1, "party_group", PartyGroup.class);
        }

        public List<PartyGroup> mergePartyGroup(){
            return getPartyGroup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyGroup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<BudgetStatus> getChangeByBudgetStatus(){
            return getRelationValues(ctx, p1, "change_by_budget_status", BudgetStatus.class);
        }

        public List<BudgetStatus> mergeChangeByBudgetStatus(){
            return getChangeByBudgetStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChangeByBudgetStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Content> getCreatedByContent(){
            return getRelationValues(ctx, p1, "created_by_content", Content.class);
        }

        public List<Content> mergeCreatedByContent(){
            return getCreatedByContent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByContent().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Content> getLastModifiedByContent(){
            return getRelationValues(ctx, p1, "last_modified_by_content", Content.class);
        }

        public List<Content> mergeLastModifiedByContent(){
            return getLastModifiedByContent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByContent().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ContentAssoc> getCreatedByContentAssoc(){
            return getRelationValues(ctx, p1, "created_by_content_assoc", ContentAssoc.class);
        }

        public List<ContentAssoc> mergeCreatedByContentAssoc(){
            return getCreatedByContentAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByContentAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ContentAssoc> getLastModifiedByContentAssoc(){
            return getRelationValues(ctx, p1, "last_modified_by_content_assoc", ContentAssoc.class);
        }

        public List<ContentAssoc> mergeLastModifiedByContentAssoc(){
            return getLastModifiedByContentAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByContentAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<DataResource> getCreatedByDataResource(){
            return getRelationValues(ctx, p1, "created_by_data_resource", DataResource.class);
        }

        public List<DataResource> mergeCreatedByDataResource(){
            return getCreatedByDataResource().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByDataResource().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<DataResource> getLastModifiedByDataResource(){
            return getRelationValues(ctx, p1, "last_modified_by_data_resource", DataResource.class);
        }

        public List<DataResource> mergeLastModifiedByDataResource(){
            return getLastModifiedByDataResource().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByDataResource().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FinAccountStatus> getFinAccountStatus(){
            return getRelationValues(ctx, p1, "fin_account_status", FinAccountStatus.class);
        }

        public List<FinAccountStatus> mergeFinAccountStatus(){
            return getFinAccountStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFinAccountStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InvoiceStatus> getChangeByInvoiceStatus(){
            return getRelationValues(ctx, p1, "change_by_invoice_status", InvoiceStatus.class);
        }

        public List<InvoiceStatus> mergeChangeByInvoiceStatus(){
            return getChangeByInvoiceStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChangeByInvoiceStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ItemIssuance> getIssuedByItemIssuance(){
            return getRelationValues(ctx, p1, "issued_by_item_issuance", ItemIssuance.class);
        }

        public List<ItemIssuance> mergeIssuedByItemIssuance(){
            return getIssuedByItemIssuance().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelIssuedByItemIssuance().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<JobSandbox> getAuthJobSandbox(){
            return getRelationValues(ctx, p1, "auth_job_sandbox", JobSandbox.class);
        }

        public List<JobSandbox> mergeAuthJobSandbox(){
            return getAuthJobSandbox().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAuthJobSandbox().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<JobSandbox> getRunAsJobSandbox(){
            return getRelationValues(ctx, p1, "run_as_job_sandbox", JobSandbox.class);
        }

        public List<JobSandbox> mergeRunAsJobSandbox(){
            return getRunAsJobSandbox().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelRunAsJobSandbox().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderAdjustment> getOrderAdjustment(){
            return getRelationValues(ctx, p1, "order_adjustment", OrderAdjustment.class);
        }

        public List<OrderAdjustment> mergeOrderAdjustment(){
            return getOrderAdjustment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderAdjustment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderHeader> getCreatedByOrderHeader(){
            return getRelationValues(ctx, p1, "created_by_order_header", OrderHeader.class);
        }

        public List<OrderHeader> mergeCreatedByOrderHeader(){
            return getCreatedByOrderHeader().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByOrderHeader().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItem> getDontCancelSetOrderItem(){
            return getRelationValues(ctx, p1, "dont_cancel_set_order_item", OrderItem.class);
        }

        public List<OrderItem> mergeDontCancelSetOrderItem(){
            return getDontCancelSetOrderItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelDontCancelSetOrderItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItem> getChangeByOrderItem(){
            return getRelationValues(ctx, p1, "change_by_order_item", OrderItem.class);
        }

        public List<OrderItem> mergeChangeByOrderItem(){
            return getChangeByOrderItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChangeByOrderItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderPaymentPreference> getOrderPaymentPreference(){
            return getRelationValues(ctx, p1, "order_payment_preference", OrderPaymentPreference.class);
        }

        public List<OrderPaymentPreference> mergeOrderPaymentPreference(){
            return getOrderPaymentPreference().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderPaymentPreference().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderStatus> getOrderStatus(){
            return getRelationValues(ctx, p1, "order_status", OrderStatus.class);
        }

        public List<OrderStatus> mergeOrderStatus(){
            return getOrderStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Party> getCreatedByParty(){
            return getRelationValues(ctx, p1, "created_by_party", Party.class);
        }

        public List<Party> mergeCreatedByParty(){
            return getCreatedByParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Party> getLastModifiedByParty(){
            return getRelationValues(ctx, p1, "last_modified_by_party", Party.class);
        }

        public List<Party> mergeLastModifiedByParty(){
            return getLastModifiedByParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyStatus> getChangeByPartyStatus(){
            return getRelationValues(ctx, p1, "change_by_party_status", PartyStatus.class);
        }

        public List<PartyStatus> mergeChangeByPartyStatus(){
            return getChangeByPartyStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChangeByPartyStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Product> getCreatedByProduct(){
            return getRelationValues(ctx, p1, "created_by_product", Product.class);
        }

        public List<Product> mergeCreatedByProduct(){
            return getCreatedByProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Product> getLastModifiedByProduct(){
            return getRelationValues(ctx, p1, "last_modified_by_product", Product.class);
        }

        public List<Product> mergeLastModifiedByProduct(){
            return getLastModifiedByProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFeaturePrice> getCreatedByProductFeaturePrice(){
            return getRelationValues(ctx, p1, "created_by_product_feature_price", ProductFeaturePrice.class);
        }

        public List<ProductFeaturePrice> mergeCreatedByProductFeaturePrice(){
            return getCreatedByProductFeaturePrice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByProductFeaturePrice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFeaturePrice> getLastModifiedByProductFeaturePrice(){
            return getRelationValues(ctx, p1, "last_modified_by_product_feature_price", ProductFeaturePrice.class);
        }

        public List<ProductFeaturePrice> mergeLastModifiedByProductFeaturePrice(){
            return getLastModifiedByProductFeaturePrice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByProductFeaturePrice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPrice> getCreatedByProductPrice(){
            return getRelationValues(ctx, p1, "created_by_product_price", ProductPrice.class);
        }

        public List<ProductPrice> mergeCreatedByProductPrice(){
            return getCreatedByProductPrice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByProductPrice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPrice> getLastModifiedByProductPrice(){
            return getRelationValues(ctx, p1, "last_modified_by_product_price", ProductPrice.class);
        }

        public List<ProductPrice> mergeLastModifiedByProductPrice(){
            return getLastModifiedByProductPrice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByProductPrice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromo> getCreatedByProductPromo(){
            return getRelationValues(ctx, p1, "created_by_product_promo", ProductPromo.class);
        }

        public List<ProductPromo> mergeCreatedByProductPromo(){
            return getCreatedByProductPromo().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByProductPromo().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromo> getLastModifiedByProductPromo(){
            return getRelationValues(ctx, p1, "last_modified_by_product_promo", ProductPromo.class);
        }

        public List<ProductPromo> mergeLastModifiedByProductPromo(){
            return getLastModifiedByProductPromo().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByProductPromo().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromoCode> getCreatedByProductPromoCode(){
            return getRelationValues(ctx, p1, "created_by_product_promo_code", ProductPromoCode.class);
        }

        public List<ProductPromoCode> mergeCreatedByProductPromoCode(){
            return getCreatedByProductPromoCode().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByProductPromoCode().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromoCode> getLastModifiedByProductPromoCode(){
            return getRelationValues(ctx, p1, "last_modified_by_product_promo_code", ProductPromoCode.class);
        }

        public List<ProductPromoCode> mergeLastModifiedByProductPromoCode(){
            return getLastModifiedByProductPromoCode().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelLastModifiedByProductPromoCode().add(c))
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
         
        public List<ShipmentReceipt> getShipmentReceipt(){
            return getRelationValues(ctx, p1, "shipment_receipt", ShipmentReceipt.class);
        }

        public List<ShipmentReceipt> mergeShipmentReceipt(){
            return getShipmentReceipt().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentReceipt().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentStatus> getChangeByShipmentStatus(){
            return getRelationValues(ctx, p1, "change_by_shipment_status", ShipmentStatus.class);
        }

        public List<ShipmentStatus> mergeChangeByShipmentStatus(){
            return getChangeByShipmentStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChangeByShipmentStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<UserLoginSecurityGroup> getUserLoginSecurityGroup(){
            return getRelationValues(ctx, p1, "user_login_security_group", UserLoginSecurityGroup.class);
        }

        public List<UserLoginSecurityGroup> mergeUserLoginSecurityGroup(){
            return getUserLoginSecurityGroup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelUserLoginSecurityGroup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WorkEffortPartyAssignment> getAssignedByWorkEffortPartyAssignment(){
            return getRelationValues(ctx, p1, "assigned_by_work_effort_party_assignment", WorkEffortPartyAssignment.class);
        }

        public List<WorkEffortPartyAssignment> mergeAssignedByWorkEffortPartyAssignment(){
            return getAssignedByWorkEffortPartyAssignment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAssignedByWorkEffortPartyAssignment().add(c))
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
        UserLoginData p = UserLoginData.newBuilder()
                .setUserLoginId(key)
                .build();
        UserLogin rec = findOne(ctx, p, UserLogin.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, UserLogin rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PARTY="party";
         
    public static final String PERSON="person";
         
    public static final String PARTY_GROUP="party_group";
         
    public static final String CHANGE_BY_BUDGET_STATUS="change_by_budget_status";
         
    public static final String CREATED_BY_CONTENT="created_by_content";
         
    public static final String LAST_MODIFIED_BY_CONTENT="last_modified_by_content";
         
    public static final String CREATED_BY_CONTENT_ASSOC="created_by_content_assoc";
         
    public static final String LAST_MODIFIED_BY_CONTENT_ASSOC="last_modified_by_content_assoc";
         
    public static final String CREATED_BY_DATA_RESOURCE="created_by_data_resource";
         
    public static final String LAST_MODIFIED_BY_DATA_RESOURCE="last_modified_by_data_resource";
         
    public static final String FIN_ACCOUNT_STATUS="fin_account_status";
         
    public static final String CHANGE_BY_INVOICE_STATUS="change_by_invoice_status";
         
    public static final String ISSUED_BY_ITEM_ISSUANCE="issued_by_item_issuance";
         
    public static final String AUTH_JOB_SANDBOX="auth_job_sandbox";
         
    public static final String RUN_AS_JOB_SANDBOX="run_as_job_sandbox";
         
    public static final String ORDER_ADJUSTMENT="order_adjustment";
         
    public static final String CREATED_BY_ORDER_HEADER="created_by_order_header";
         
    public static final String DONT_CANCEL_SET_ORDER_ITEM="dont_cancel_set_order_item";
         
    public static final String CHANGE_BY_ORDER_ITEM="change_by_order_item";
         
    public static final String ORDER_PAYMENT_PREFERENCE="order_payment_preference";
         
    public static final String ORDER_STATUS="order_status";
         
    public static final String CREATED_BY_PARTY="created_by_party";
         
    public static final String LAST_MODIFIED_BY_PARTY="last_modified_by_party";
         
    public static final String CHANGE_BY_PARTY_STATUS="change_by_party_status";
         
    public static final String CREATED_BY_PRODUCT="created_by_product";
         
    public static final String LAST_MODIFIED_BY_PRODUCT="last_modified_by_product";
         
    public static final String CREATED_BY_PRODUCT_FEATURE_PRICE="created_by_product_feature_price";
         
    public static final String LAST_MODIFIED_BY_PRODUCT_FEATURE_PRICE="last_modified_by_product_feature_price";
         
    public static final String CREATED_BY_PRODUCT_PRICE="created_by_product_price";
         
    public static final String LAST_MODIFIED_BY_PRODUCT_PRICE="last_modified_by_product_price";
         
    public static final String CREATED_BY_PRODUCT_PROMO="created_by_product_promo";
         
    public static final String LAST_MODIFIED_BY_PRODUCT_PROMO="last_modified_by_product_promo";
         
    public static final String CREATED_BY_PRODUCT_PROMO_CODE="created_by_product_promo_code";
         
    public static final String LAST_MODIFIED_BY_PRODUCT_PROMO_CODE="last_modified_by_product_promo_code";
         
    public static final String PRODUCT_REVIEW="product_review";
         
    public static final String SHIPMENT_RECEIPT="shipment_receipt";
         
    public static final String CHANGE_BY_SHIPMENT_STATUS="change_by_shipment_status";
         
    public static final String USER_LOGIN_SECURITY_GROUP="user_login_security_group";
         
    public static final String ASSIGNED_BY_WORK_EFFORT_PARTY_ASSIGNMENT="assigned_by_work_effort_party_assignment";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryUserLoginRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            UserLoginData p = UserLoginData.newBuilder()
                    .setUserLoginId(key)
                    .build();
            List<UserLoginData.Builder> ds = find(ctx, p, UserLogin.class).stream()
                    .map(e -> {
                        UserLoginData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set party to head entity                        
                        if(relationsDemand.contains("party")) {
                            getRelationValues(ctx, p1, "party",
                                            Party.class)
                                    .forEach(el -> pb.setParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set person to head entity                        
                        if(relationsDemand.contains("person")) {
                            getRelationValues(ctx, p1, "person",
                                            Person.class)
                                    .forEach(el -> pb.setPerson(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set party_group to head entity                        
                        if(relationsDemand.contains("party_group")) {
                            getRelationValues(ctx, p1, "party_group",
                                            PartyGroup.class)
                                    .forEach(el -> pb.setPartyGroup(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set change_by_budget_status to head entity                        
                        if(relationsDemand.contains("change_by_budget_status")) {
                            getRelationValues(ctx, p1, "change_by_budget_status",
                                            BudgetStatus.class)
                                    .forEach(el -> pb.addChangeByBudgetStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_content to head entity                        
                        if(relationsDemand.contains("created_by_content")) {
                            getRelationValues(ctx, p1, "created_by_content",
                                            Content.class)
                                    .forEach(el -> pb.addCreatedByContent(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_content to head entity                        
                        if(relationsDemand.contains("last_modified_by_content")) {
                            getRelationValues(ctx, p1, "last_modified_by_content",
                                            Content.class)
                                    .forEach(el -> pb.addLastModifiedByContent(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_content_assoc to head entity                        
                        if(relationsDemand.contains("created_by_content_assoc")) {
                            getRelationValues(ctx, p1, "created_by_content_assoc",
                                            ContentAssoc.class)
                                    .forEach(el -> pb.addCreatedByContentAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_content_assoc to head entity                        
                        if(relationsDemand.contains("last_modified_by_content_assoc")) {
                            getRelationValues(ctx, p1, "last_modified_by_content_assoc",
                                            ContentAssoc.class)
                                    .forEach(el -> pb.addLastModifiedByContentAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_data_resource to head entity                        
                        if(relationsDemand.contains("created_by_data_resource")) {
                            getRelationValues(ctx, p1, "created_by_data_resource",
                                            DataResource.class)
                                    .forEach(el -> pb.addCreatedByDataResource(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_data_resource to head entity                        
                        if(relationsDemand.contains("last_modified_by_data_resource")) {
                            getRelationValues(ctx, p1, "last_modified_by_data_resource",
                                            DataResource.class)
                                    .forEach(el -> pb.addLastModifiedByDataResource(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fin_account_status to head entity                        
                        if(relationsDemand.contains("fin_account_status")) {
                            getRelationValues(ctx, p1, "fin_account_status",
                                            FinAccountStatus.class)
                                    .forEach(el -> pb.addFinAccountStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set change_by_invoice_status to head entity                        
                        if(relationsDemand.contains("change_by_invoice_status")) {
                            getRelationValues(ctx, p1, "change_by_invoice_status",
                                            InvoiceStatus.class)
                                    .forEach(el -> pb.addChangeByInvoiceStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set issued_by_item_issuance to head entity                        
                        if(relationsDemand.contains("issued_by_item_issuance")) {
                            getRelationValues(ctx, p1, "issued_by_item_issuance",
                                            ItemIssuance.class)
                                    .forEach(el -> pb.addIssuedByItemIssuance(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set auth_job_sandbox to head entity                        
                        if(relationsDemand.contains("auth_job_sandbox")) {
                            getRelationValues(ctx, p1, "auth_job_sandbox",
                                            JobSandbox.class)
                                    .forEach(el -> pb.addAuthJobSandbox(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set run_as_job_sandbox to head entity                        
                        if(relationsDemand.contains("run_as_job_sandbox")) {
                            getRelationValues(ctx, p1, "run_as_job_sandbox",
                                            JobSandbox.class)
                                    .forEach(el -> pb.addRunAsJobSandbox(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_adjustment to head entity                        
                        if(relationsDemand.contains("order_adjustment")) {
                            getRelationValues(ctx, p1, "order_adjustment",
                                            OrderAdjustment.class)
                                    .forEach(el -> pb.addOrderAdjustment(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_order_header to head entity                        
                        if(relationsDemand.contains("created_by_order_header")) {
                            getRelationValues(ctx, p1, "created_by_order_header",
                                            OrderHeader.class)
                                    .forEach(el -> pb.addCreatedByOrderHeader(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set dont_cancel_set_order_item to head entity                        
                        if(relationsDemand.contains("dont_cancel_set_order_item")) {
                            getRelationValues(ctx, p1, "dont_cancel_set_order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.addDontCancelSetOrderItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set change_by_order_item to head entity                        
                        if(relationsDemand.contains("change_by_order_item")) {
                            getRelationValues(ctx, p1, "change_by_order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.addChangeByOrderItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set order_payment_preference to head entity                        
                        if(relationsDemand.contains("order_payment_preference")) {
                            getRelationValues(ctx, p1, "order_payment_preference",
                                            OrderPaymentPreference.class)
                                    .forEach(el -> pb.addOrderPaymentPreference(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_status to head entity                        
                        if(relationsDemand.contains("order_status")) {
                            getRelationValues(ctx, p1, "order_status",
                                            OrderStatus.class)
                                    .forEach(el -> pb.addOrderStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_party to head entity                        
                        if(relationsDemand.contains("created_by_party")) {
                            getRelationValues(ctx, p1, "created_by_party",
                                            Party.class)
                                    .forEach(el -> pb.addCreatedByParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_party to head entity                        
                        if(relationsDemand.contains("last_modified_by_party")) {
                            getRelationValues(ctx, p1, "last_modified_by_party",
                                            Party.class)
                                    .forEach(el -> pb.addLastModifiedByParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set change_by_party_status to head entity                        
                        if(relationsDemand.contains("change_by_party_status")) {
                            getRelationValues(ctx, p1, "change_by_party_status",
                                            PartyStatus.class)
                                    .forEach(el -> pb.addChangeByPartyStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_product to head entity                        
                        if(relationsDemand.contains("created_by_product")) {
                            getRelationValues(ctx, p1, "created_by_product",
                                            Product.class)
                                    .forEach(el -> pb.addCreatedByProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_product to head entity                        
                        if(relationsDemand.contains("last_modified_by_product")) {
                            getRelationValues(ctx, p1, "last_modified_by_product",
                                            Product.class)
                                    .forEach(el -> pb.addLastModifiedByProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set created_by_product_feature_price to head entity                        
                        if(relationsDemand.contains("created_by_product_feature_price")) {
                            getRelationValues(ctx, p1, "created_by_product_feature_price",
                                            ProductFeaturePrice.class)
                                    .forEach(el -> pb.addCreatedByProductFeaturePrice(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_product_feature_price to head entity                        
                        if(relationsDemand.contains("last_modified_by_product_feature_price")) {
                            getRelationValues(ctx, p1, "last_modified_by_product_feature_price",
                                            ProductFeaturePrice.class)
                                    .forEach(el -> pb.addLastModifiedByProductFeaturePrice(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_product_price to head entity                        
                        if(relationsDemand.contains("created_by_product_price")) {
                            getRelationValues(ctx, p1, "created_by_product_price",
                                            ProductPrice.class)
                                    .forEach(el -> pb.addCreatedByProductPrice(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_product_price to head entity                        
                        if(relationsDemand.contains("last_modified_by_product_price")) {
                            getRelationValues(ctx, p1, "last_modified_by_product_price",
                                            ProductPrice.class)
                                    .forEach(el -> pb.addLastModifiedByProductPrice(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_product_promo to head entity                        
                        if(relationsDemand.contains("created_by_product_promo")) {
                            getRelationValues(ctx, p1, "created_by_product_promo",
                                            ProductPromo.class)
                                    .forEach(el -> pb.addCreatedByProductPromo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_product_promo to head entity                        
                        if(relationsDemand.contains("last_modified_by_product_promo")) {
                            getRelationValues(ctx, p1, "last_modified_by_product_promo",
                                            ProductPromo.class)
                                    .forEach(el -> pb.addLastModifiedByProductPromo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set created_by_product_promo_code to head entity                        
                        if(relationsDemand.contains("created_by_product_promo_code")) {
                            getRelationValues(ctx, p1, "created_by_product_promo_code",
                                            ProductPromoCode.class)
                                    .forEach(el -> pb.addCreatedByProductPromoCode(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set last_modified_by_product_promo_code to head entity                        
                        if(relationsDemand.contains("last_modified_by_product_promo_code")) {
                            getRelationValues(ctx, p1, "last_modified_by_product_promo_code",
                                            ProductPromoCode.class)
                                    .forEach(el -> pb.addLastModifiedByProductPromoCode(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_review to head entity                        
                        if(relationsDemand.contains("product_review")) {
                            getRelationValues(ctx, p1, "product_review",
                                            ProductReview.class)
                                    .forEach(el -> pb.addProductReview(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_receipt to head entity                        
                        if(relationsDemand.contains("shipment_receipt")) {
                            getRelationValues(ctx, p1, "shipment_receipt",
                                            ShipmentReceipt.class)
                                    .forEach(el -> pb.addShipmentReceipt(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set change_by_shipment_status to head entity                        
                        if(relationsDemand.contains("change_by_shipment_status")) {
                            getRelationValues(ctx, p1, "change_by_shipment_status",
                                            ShipmentStatus.class)
                                    .forEach(el -> pb.addChangeByShipmentStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set user_login_security_group to head entity                        
                        if(relationsDemand.contains("user_login_security_group")) {
                            getRelationValues(ctx, p1, "user_login_security_group",
                                            UserLoginSecurityGroup.class)
                                    .forEach(el -> pb.addUserLoginSecurityGroup(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set assigned_by_work_effort_party_assignment to head entity                        
                        if(relationsDemand.contains("assigned_by_work_effort_party_assignment")) {
                            getRelationValues(ctx, p1, "assigned_by_work_effort_party_assignment",
                                            WorkEffortPartyAssignment.class)
                                    .forEach(el -> pb.addAssignedByWorkEffortPartyAssignment(
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


    
    public UserLogin.UserLoginBuilder seed(){
        return UserLogin.builder()
                .userLoginId(sequence.nextStringId());
    }
}
