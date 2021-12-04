package com.bluecc.income;

import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.income.dummy.store.HubsStore;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.exchange.ResultSubscriber;
import com.bluecc.income.procs.GenericProcs;
import com.bluecc.income.template.TemplateGlobalContext;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import org.jdbi.v3.core.statement.SqlLogger;
import org.jdbi.v3.core.statement.StatementContext;
import org.junit.runner.RunWith;
import reactor.core.publisher.Flux;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(GuiceStoreRunner.class)
public class AbstractStoreProcTest extends AbstractProcTest {
    @Override
    protected void setupEntities(String...entities){
        setupEntities(false, entities);
    }
}

