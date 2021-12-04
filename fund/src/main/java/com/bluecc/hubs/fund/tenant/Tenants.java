package com.bluecc.hubs.fund.tenant;

import com.bluecc.hubs.fund.SystemDefs;
import lombok.Data;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import static com.bluecc.hubs.fund.Util.pretty;

@Data
public class Tenants {
    @Data
    public static class TenantConf {
        DataSourceConf dataSource;
        ServerConf server;
    }

    @Data
    public static class DataSourceConf {
        String url;
        String user;
        String password;
    }
    @Data
    public static class ServerConf{
        String host;
        int port;
    }

    private Map<String, TenantConf> tenants;

    public TenantConf getDefaultConf() {
        return getConf("default");
    }

    public TenantConf getConf(String name) {
        return tenants.get(name);
    }

    public static Tenants load() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        Tenants conf = yaml.loadAs(new FileInputStream(
                        SystemDefs.prependHubsHomeFile("config/tenant_conf.yml")),
                Tenants.class);
        return conf;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Tenants tenants = load();
        pretty(tenants);
        System.out.println(tenants.getDefaultConf().getDataSource().getUrl());
    }
}
