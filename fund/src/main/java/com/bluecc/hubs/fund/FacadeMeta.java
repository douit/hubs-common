package com.bluecc.hubs.fund;

import javax.inject.Inject;

public class FacadeMeta {
    @Inject
    ProtoMeta protoMeta;
    @Inject
    ConfigLoaders config;

    public ConfigLoaders getConfig() {
        return config;
    }
}

