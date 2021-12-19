package com.bluecc.gentool;

import com.bluecc.hubs.fund.FacadeMeta;
import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.fund.TemplateUtil;
import com.bluecc.hubs.fund.Util;
import com.google.common.collect.ImmutableMap;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

import static com.bluecc.gentool.GenModule.startup;

public class FacadeGenTool {
    public static void main(String[] args) throws IOException {
        FacadeGenTool tool = startup(FacadeGenTool.class);
        tool.gen();
    }

    @Inject
    FacadeMeta facadeMeta;

    void gen() throws IOException {
        String cnt = TemplateUtil.build("templates/facade_types.j2",
                ImmutableMap.of("facade", facadeMeta));
        // System.out.println(cnt);
        Util.writeFile(cnt, SystemDefs.getFacadeTypesProtoFile());

        File implFile = SystemDefs.prependHubsHomeFile(
                "income/src/main/java/com/bluecc/income/procs/EntityTypesRpc.java");
        Util.writeFile(TemplateUtil.build("templates/facade_types_impl.j2",
                ImmutableMap.of("facade", facadeMeta)), implFile);
    }
}
