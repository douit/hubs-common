package com.bluecc.domain.guice;

import com.bluecc.domain.event.ConsoleTracker;
import com.bluecc.domain.util.Sequence;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.mchange.v2.c3p0.DataSources;
import com.bluecc.domain.dummy.repository.TweetRepository;
import com.bluecc.domain.dummy.repository.UserRepository;
import com.querydsl.sql.Configuration;
// import com.querydsl.sql.H2Templates;
import com.querydsl.sql.MySQLTemplates;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.Properties;

public class ServiceModule extends AbstractModule {
    public enum RunMode{
        Default, Test
    }
    RunMode runMode;
    public ServiceModule(){
        this(RunMode.Default);
    }

    public ServiceModule(RunMode mode){
        this.runMode=mode;
    }

    @Override
    protected void configure() {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/jdbc.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Entry<Object, Object> entry : properties.entrySet()) {
            bind(String.class).annotatedWith(Names.named((String)entry.getKey()))
                    .toInstance((String) entry.getValue());
        }

        bind(ConnectionContext.class).in(Scopes.SINGLETON);
        bind(TweetRepository.class).in(Scopes.SINGLETON);
        bind(UserRepository.class).in(Scopes.SINGLETON);

        TransactionInterceptor interceptor = new TransactionInterceptor();
        requestInjection(interceptor);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Transactional.class), interceptor);

        FireEventInterceptor fireEventInterceptor=new FireEventInterceptor();
        requestInjection(fireEventInterceptor);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Fire.class), fireEventInterceptor);
    }

    @Provides
    @Singleton
    public Configuration configuration() {
        // return new Configuration(new H2Templates());
        return new Configuration(new MySQLTemplates());
    }

    @Provides
    @Singleton
    public DataSource dataSource(@Named("jdbc.user") String user,
                                 @Named("jdbc.password") String password,
                                 @Named("jdbc.url") String url,
                                 @Named("jdbc.driver") String driver) {
        try {
            Class.forName(driver);
            return DataSources.pooledDataSource(DataSources.unpooledDataSource(
                    url, user, password));

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Provides
    public Sequence sequence(){
        return new Sequence(null);
    }

    @Provides
    public IEventProvider eventProvider(){
        return new ConsoleTracker();
    }
}
