package com.bluecc.income.dummy.store;

import com.bluecc.hubs.feed.ISharedData;
import com.bluecc.hubs.feed.SharedData;
import com.bluecc.hubs.fund.tenant.Tenants;
import com.bluecc.income.helper.TenantHubs;
import com.bluecc.income.helper.TenantId;
import com.bluecc.income.helper.TestHubs;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

import java.io.FileNotFoundException;

public class StoreModule extends AbstractFacModule {
    String tenant;

    public StoreModule(){
        this("default");
    }
    public StoreModule(String tenant){
        this.tenant=tenant;
    }

    @Override
    protected void configure() {
        super.configure();
        bind(IDataSourceFac.class).annotatedWith(TestHubs.class)
                .to(MysqlTestFac.class);
        bind(IDataSourceFac.class).annotatedWith(TenantHubs.class)
                .to(MysqlFac.class);
        bind(String.class).annotatedWith(TenantId.class)
                .toInstance(this.tenant);

        // interfaces
        // bind(ISharedData.class).to(SharedCodecData.class);
        bind(ISharedData.class).to(SharedData.class);

        try {
            Tenants tenants = Tenants.load();
            Tenants.TenantConf conf=tenants.getConf(this.tenant);
            bind(Tenants.TenantConf.class).toInstance(conf);

            bind(String.class).annotatedWith(Names.named("url"))
                    .toInstance(conf.getDataSource().getUrl());
            bind(String.class).annotatedWith(Names.named("user"))
                    .toInstance(conf.getDataSource().getUser());
            bind(String.class).annotatedWith(Names.named("password"))
                    .toInstance(conf.getDataSource().getPassword());

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Config fail", e);
        }
    }

    public static Injector startup(){
        return startup("default");
    }

    public static Injector startup(String tenant){
        return Guice.createInjector(new StoreModule(tenant),
                new DelegatorsPluginModule());
    }

    public static <T> T startup(Class<T> clz){
        return startup("default", clz);
    }

    public static <T> T startup(String tenant, Class<T> clz){
        return startup(tenant).getInstance(clz);
    }
}

