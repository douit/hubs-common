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
import com.bluecc.hubs.stub.UserLoginData;

public class UserLoginDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

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
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        default Map<String, UserLogin> chainParty(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        default Map<String, UserLogin> chainParty(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("pa_party_id", String.class) != null) {
                            p.getRelParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        default Map<String, UserLogin> chainPerson(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainPerson(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Person.class, prefix = "pe")
        default Map<String, UserLogin> chainPerson(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PERSON);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("pe_party_id", String.class) != null) {
                            p.getRelPerson()
                                    .add(rr.getRow(Person.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        default Map<String, UserLogin> chainPartyGroup(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainPartyGroup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = PartyGroup.class, prefix = "pg")
        default Map<String, UserLogin> chainPartyGroup(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_GROUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("pg_party_id", String.class) != null) {
                            p.getRelPartyGroup()
                                    .add(rr.getRow(PartyGroup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Content.class, prefix = "cbc")
        default Map<String, UserLogin> chainCreatedByContent(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByContent(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Content.class, prefix = "cbc")
        default Map<String, UserLogin> chainCreatedByContent(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_CONTENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbc_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByContent()
                                    .add(rr.getRow(Content.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Content.class, prefix = "lmbc")
        default Map<String, UserLogin> chainLastModifiedByContent(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByContent(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Content.class, prefix = "lmbc")
        default Map<String, UserLogin> chainLastModifiedByContent(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_CONTENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbc_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByContent()
                                    .add(rr.getRow(Content.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ContentAssoc.class, prefix = "cbca")
        default Map<String, UserLogin> chainCreatedByContentAssoc(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByContentAssoc(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ContentAssoc.class, prefix = "cbca")
        default Map<String, UserLogin> chainCreatedByContentAssoc(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_CONTENT_ASSOC);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbca_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByContentAssoc()
                                    .add(rr.getRow(ContentAssoc.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ContentAssoc.class, prefix = "lmbca")
        default Map<String, UserLogin> chainLastModifiedByContentAssoc(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByContentAssoc(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ContentAssoc.class, prefix = "lmbca")
        default Map<String, UserLogin> chainLastModifiedByContentAssoc(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_CONTENT_ASSOC);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbca_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByContentAssoc()
                                    .add(rr.getRow(ContentAssoc.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = DataResource.class, prefix = "cbdr")
        default Map<String, UserLogin> chainCreatedByDataResource(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByDataResource(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = DataResource.class, prefix = "cbdr")
        default Map<String, UserLogin> chainCreatedByDataResource(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_DATA_RESOURCE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbdr_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByDataResource()
                                    .add(rr.getRow(DataResource.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = DataResource.class, prefix = "lmbdr")
        default Map<String, UserLogin> chainLastModifiedByDataResource(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByDataResource(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = DataResource.class, prefix = "lmbdr")
        default Map<String, UserLogin> chainLastModifiedByDataResource(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_DATA_RESOURCE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbdr_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByDataResource()
                                    .add(rr.getRow(DataResource.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = FinAccountStatus.class, prefix = "fas")
        default Map<String, UserLogin> chainFinAccountStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainFinAccountStatus(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = FinAccountStatus.class, prefix = "fas")
        default Map<String, UserLogin> chainFinAccountStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIN_ACCOUNT_STATUS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("fas_change_by_user_login_id", String.class) != null) {
                            p.getRelFinAccountStatus()
                                    .add(rr.getRow(FinAccountStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = InvoiceStatus.class, prefix = "cbis")
        default Map<String, UserLogin> chainChangeByInvoiceStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainChangeByInvoiceStatus(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = InvoiceStatus.class, prefix = "cbis")
        default Map<String, UserLogin> chainChangeByInvoiceStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHANGE_BY_INVOICE_STATUS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbis_change_by_user_login_id", String.class) != null) {
                            p.getRelChangeByInvoiceStatus()
                                    .add(rr.getRow(InvoiceStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ItemIssuance.class, prefix = "ibii")
        default Map<String, UserLogin> chainIssuedByItemIssuance(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainIssuedByItemIssuance(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ItemIssuance.class, prefix = "ibii")
        default Map<String, UserLogin> chainIssuedByItemIssuance(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ISSUED_BY_ITEM_ISSUANCE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("ibii_issued_by_user_login_id", String.class) != null) {
                            p.getRelIssuedByItemIssuance()
                                    .add(rr.getRow(ItemIssuance.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderAdjustment.class, prefix = "oa")
        default Map<String, UserLogin> chainOrderAdjustment(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainOrderAdjustment(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderAdjustment.class, prefix = "oa")
        default Map<String, UserLogin> chainOrderAdjustment(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ADJUSTMENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("oa_created_by_user_login", String.class) != null) {
                            p.getRelOrderAdjustment()
                                    .add(rr.getRow(OrderAdjustment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "cboh")
        default Map<String, UserLogin> chainCreatedByOrderHeader(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByOrderHeader(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "cboh")
        default Map<String, UserLogin> chainCreatedByOrderHeader(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_ORDER_HEADER);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cboh_created_by", String.class) != null) {
                            p.getRelCreatedByOrderHeader()
                                    .add(rr.getRow(OrderHeader.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "dcsoi")
        default Map<String, UserLogin> chainDontCancelSetOrderItem(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainDontCancelSetOrderItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "dcsoi")
        default Map<String, UserLogin> chainDontCancelSetOrderItem(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(DONT_CANCEL_SET_ORDER_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("dcsoi_dont_cancel_set_user_login", String.class) != null) {
                            p.getRelDontCancelSetOrderItem()
                                    .add(rr.getRow(OrderItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "cboi")
        default Map<String, UserLogin> chainChangeByOrderItem(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainChangeByOrderItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "cboi")
        default Map<String, UserLogin> chainChangeByOrderItem(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHANGE_BY_ORDER_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cboi_change_by_user_login_id", String.class) != null) {
                            p.getRelChangeByOrderItem()
                                    .add(rr.getRow(OrderItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "opp")
        default Map<String, UserLogin> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainOrderPaymentPreference(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "opp")
        default Map<String, UserLogin> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_PAYMENT_PREFERENCE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("opp_created_by_user_login", String.class) != null) {
                            p.getRelOrderPaymentPreference()
                                    .add(rr.getRow(OrderPaymentPreference.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderStatus.class, prefix = "os")
        default Map<String, UserLogin> chainOrderStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainOrderStatus(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = OrderStatus.class, prefix = "os")
        default Map<String, UserLogin> chainOrderStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_STATUS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("os_status_user_login", String.class) != null) {
                            p.getRelOrderStatus()
                                    .add(rr.getRow(OrderStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Party.class, prefix = "cbp")
        default Map<String, UserLogin> chainCreatedByParty(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Party.class, prefix = "cbp")
        default Map<String, UserLogin> chainCreatedByParty(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbp_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Party.class, prefix = "lmbp")
        default Map<String, UserLogin> chainLastModifiedByParty(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Party.class, prefix = "lmbp")
        default Map<String, UserLogin> chainLastModifiedByParty(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbp_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = PartyStatus.class, prefix = "cbps")
        default Map<String, UserLogin> chainChangeByPartyStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainChangeByPartyStatus(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = PartyStatus.class, prefix = "cbps")
        default Map<String, UserLogin> chainChangeByPartyStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHANGE_BY_PARTY_STATUS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbps_change_by_user_login_id", String.class) != null) {
                            p.getRelChangeByPartyStatus()
                                    .add(rr.getRow(PartyStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Product.class, prefix = "cbp")
        default Map<String, UserLogin> chainCreatedByProduct(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Product.class, prefix = "cbp")
        default Map<String, UserLogin> chainCreatedByProduct(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbp_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByProduct()
                                    .add(rr.getRow(Product.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Product.class, prefix = "lmbp")
        default Map<String, UserLogin> chainLastModifiedByProduct(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = Product.class, prefix = "lmbp")
        default Map<String, UserLogin> chainLastModifiedByProduct(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbp_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByProduct()
                                    .add(rr.getRow(Product.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductFeaturePrice.class, prefix = "cbpfp")
        default Map<String, UserLogin> chainCreatedByProductFeaturePrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByProductFeaturePrice(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductFeaturePrice.class, prefix = "cbpfp")
        default Map<String, UserLogin> chainCreatedByProductFeaturePrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_PRODUCT_FEATURE_PRICE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbpfp_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByProductFeaturePrice()
                                    .add(rr.getRow(ProductFeaturePrice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductFeaturePrice.class, prefix = "lmbpfp")
        default Map<String, UserLogin> chainLastModifiedByProductFeaturePrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByProductFeaturePrice(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductFeaturePrice.class, prefix = "lmbpfp")
        default Map<String, UserLogin> chainLastModifiedByProductFeaturePrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_PRODUCT_FEATURE_PRICE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbpfp_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByProductFeaturePrice()
                                    .add(rr.getRow(ProductFeaturePrice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPrice.class, prefix = "cbpp")
        default Map<String, UserLogin> chainCreatedByProductPrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByProductPrice(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPrice.class, prefix = "cbpp")
        default Map<String, UserLogin> chainCreatedByProductPrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_PRODUCT_PRICE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbpp_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByProductPrice()
                                    .add(rr.getRow(ProductPrice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPrice.class, prefix = "lmbpp")
        default Map<String, UserLogin> chainLastModifiedByProductPrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByProductPrice(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPrice.class, prefix = "lmbpp")
        default Map<String, UserLogin> chainLastModifiedByProductPrice(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_PRODUCT_PRICE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbpp_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByProductPrice()
                                    .add(rr.getRow(ProductPrice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromo.class, prefix = "cbpp")
        default Map<String, UserLogin> chainCreatedByProductPromo(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByProductPromo(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromo.class, prefix = "cbpp")
        default Map<String, UserLogin> chainCreatedByProductPromo(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_PRODUCT_PROMO);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbpp_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByProductPromo()
                                    .add(rr.getRow(ProductPromo.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromo.class, prefix = "lmbpp")
        default Map<String, UserLogin> chainLastModifiedByProductPromo(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByProductPromo(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromo.class, prefix = "lmbpp")
        default Map<String, UserLogin> chainLastModifiedByProductPromo(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_PRODUCT_PROMO);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbpp_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByProductPromo()
                                    .add(rr.getRow(ProductPromo.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromoCode.class, prefix = "cbppc")
        default Map<String, UserLogin> chainCreatedByProductPromoCode(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainCreatedByProductPromoCode(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromoCode.class, prefix = "cbppc")
        default Map<String, UserLogin> chainCreatedByProductPromoCode(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_PRODUCT_PROMO_CODE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbppc_created_by_user_login", String.class) != null) {
                            p.getRelCreatedByProductPromoCode()
                                    .add(rr.getRow(ProductPromoCode.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromoCode.class, prefix = "lmbppc")
        default Map<String, UserLogin> chainLastModifiedByProductPromoCode(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainLastModifiedByProductPromoCode(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductPromoCode.class, prefix = "lmbppc")
        default Map<String, UserLogin> chainLastModifiedByProductPromoCode(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(LAST_MODIFIED_BY_PRODUCT_PROMO_CODE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("lmbppc_last_modified_by_user_login", String.class) != null) {
                            p.getRelLastModifiedByProductPromoCode()
                                    .add(rr.getRow(ProductPromoCode.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductReview.class, prefix = "pr")
        default Map<String, UserLogin> chainProductReview(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainProductReview(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ProductReview.class, prefix = "pr")
        default Map<String, UserLogin> chainProductReview(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_REVIEW);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("pr_user_login_id", String.class) != null) {
                            p.getRelProductReview()
                                    .add(rr.getRow(ProductReview.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "sr")
        default Map<String, UserLogin> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainShipmentReceipt(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "sr")
        default Map<String, UserLogin> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_RECEIPT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("sr_received_by_user_login_id", String.class) != null) {
                            p.getRelShipmentReceipt()
                                    .add(rr.getRow(ShipmentReceipt.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ShipmentStatus.class, prefix = "cbss")
        default Map<String, UserLogin> chainChangeByShipmentStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainChangeByShipmentStatus(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = ShipmentStatus.class, prefix = "cbss")
        default Map<String, UserLogin> chainChangeByShipmentStatus(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHANGE_BY_SHIPMENT_STATUS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("cbss_change_by_user_login_id", String.class) != null) {
                            p.getRelChangeByShipmentStatus()
                                    .add(rr.getRow(ShipmentStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = UserLoginSecurityGroup.class, prefix = "ulsg")
        default Map<String, UserLogin> chainUserLoginSecurityGroup(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               boolean succInvoke) {
            return chainUserLoginSecurityGroup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = UserLogin.class, prefix = "ul")
        @RegisterBeanMapper(value = UserLoginSecurityGroup.class, prefix = "ulsg")
        default Map<String, UserLogin> chainUserLoginSecurityGroup(ProtoMeta protoMeta,
                                               Map<String, UserLogin> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("UserLogin", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(USER_LOGIN_SECURITY_GROUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        UserLogin p = map.computeIfAbsent(rr.getColumn("ul_user_login_id", String.class),
                                id -> rr.getRow(UserLogin.class));
                        if (rr.getColumn("ulsg_user_login_id", String.class) != null) {
                            p.getRelUserLoginSecurityGroup()
                                    .add(rr.getRow(UserLoginSecurityGroup.class));
                        }
                        return map;
                    });
        }
        
    }

     
    Consumer<Map<String, UserLogin>> party(Dao dao, boolean succ) {
        return e -> dao.chainParty(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> party(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainParty(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> person(Dao dao, boolean succ) {
        return e -> dao.chainPerson(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> person(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPerson(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> partyGroup(Dao dao, boolean succ) {
        return e -> dao.chainPartyGroup(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> partyGroup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyGroup(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> createdByContent(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByContent(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> createdByContent(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByContent(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> lastModifiedByContent(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByContent(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> lastModifiedByContent(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByContent(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> createdByContentAssoc(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByContentAssoc(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> createdByContentAssoc(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByContentAssoc(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> lastModifiedByContentAssoc(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByContentAssoc(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> lastModifiedByContentAssoc(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByContentAssoc(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> createdByDataResource(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByDataResource(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> createdByDataResource(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByDataResource(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> lastModifiedByDataResource(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByDataResource(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> lastModifiedByDataResource(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByDataResource(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> finAccountStatus(Dao dao, boolean succ) {
        return e -> dao.chainFinAccountStatus(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> finAccountStatus(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFinAccountStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> changeByInvoiceStatus(Dao dao, boolean succ) {
        return e -> dao.chainChangeByInvoiceStatus(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> changeByInvoiceStatus(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainChangeByInvoiceStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> issuedByItemIssuance(Dao dao, boolean succ) {
        return e -> dao.chainIssuedByItemIssuance(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> issuedByItemIssuance(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainIssuedByItemIssuance(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> orderAdjustment(Dao dao, boolean succ) {
        return e -> dao.chainOrderAdjustment(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> orderAdjustment(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderAdjustment(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> createdByOrderHeader(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByOrderHeader(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> createdByOrderHeader(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByOrderHeader(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> dontCancelSetOrderItem(Dao dao, boolean succ) {
        return e -> dao.chainDontCancelSetOrderItem(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> dontCancelSetOrderItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainDontCancelSetOrderItem(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> changeByOrderItem(Dao dao, boolean succ) {
        return e -> dao.chainChangeByOrderItem(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> changeByOrderItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainChangeByOrderItem(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> orderPaymentPreference(Dao dao, boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> orderPaymentPreference(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> orderStatus(Dao dao, boolean succ) {
        return e -> dao.chainOrderStatus(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> orderStatus(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> createdByParty(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByParty(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> createdByParty(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByParty(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> lastModifiedByParty(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByParty(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> lastModifiedByParty(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByParty(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> changeByPartyStatus(Dao dao, boolean succ) {
        return e -> dao.chainChangeByPartyStatus(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> changeByPartyStatus(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainChangeByPartyStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> createdByProduct(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByProduct(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> createdByProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> lastModifiedByProduct(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByProduct(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> lastModifiedByProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> createdByProductFeaturePrice(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByProductFeaturePrice(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> createdByProductFeaturePrice(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByProductFeaturePrice(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> lastModifiedByProductFeaturePrice(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByProductFeaturePrice(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> lastModifiedByProductFeaturePrice(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByProductFeaturePrice(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> createdByProductPrice(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByProductPrice(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> createdByProductPrice(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByProductPrice(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> lastModifiedByProductPrice(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByProductPrice(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> lastModifiedByProductPrice(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByProductPrice(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> createdByProductPromo(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByProductPromo(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> createdByProductPromo(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByProductPromo(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> lastModifiedByProductPromo(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByProductPromo(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> lastModifiedByProductPromo(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByProductPromo(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> createdByProductPromoCode(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByProductPromoCode(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> createdByProductPromoCode(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByProductPromoCode(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> lastModifiedByProductPromoCode(Dao dao, boolean succ) {
        return e -> dao.chainLastModifiedByProductPromoCode(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> lastModifiedByProductPromoCode(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainLastModifiedByProductPromoCode(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> productReview(Dao dao, boolean succ) {
        return e -> dao.chainProductReview(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> productReview(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductReview(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> shipmentReceipt(Dao dao, boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> shipmentReceipt(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> changeByShipmentStatus(Dao dao, boolean succ) {
        return e -> dao.chainChangeByShipmentStatus(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> changeByShipmentStatus(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainChangeByShipmentStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, UserLogin>> userLoginSecurityGroup(Dao dao, boolean succ) {
        return e -> dao.chainUserLoginSecurityGroup(protoMeta, e, succ);
    }

    Consumer<Map<String, UserLogin>> userLoginSecurityGroup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainUserLoginSecurityGroup(protoMeta, e, whereClause, binds, succ);
    }
    

    public UserLogin get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getUserLogin(id);
    }

    public List<UserLogin> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listUserLogin();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countUserLogin();
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
         
    public static final String CREATED_BY_CONTENT="created_by_content";
         
    public static final String LAST_MODIFIED_BY_CONTENT="last_modified_by_content";
         
    public static final String CREATED_BY_CONTENT_ASSOC="created_by_content_assoc";
         
    public static final String LAST_MODIFIED_BY_CONTENT_ASSOC="last_modified_by_content_assoc";
         
    public static final String CREATED_BY_DATA_RESOURCE="created_by_data_resource";
         
    public static final String LAST_MODIFIED_BY_DATA_RESOURCE="last_modified_by_data_resource";
         
    public static final String FIN_ACCOUNT_STATUS="fin_account_status";
         
    public static final String CHANGE_BY_INVOICE_STATUS="change_by_invoice_status";
         
    public static final String ISSUED_BY_ITEM_ISSUANCE="issued_by_item_issuance";
         
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
