package com.bluecc.gentool;

import com.bluecc.gentool.procgen.ProcGen;
import com.bluecc.hubs.fund.HeadEntityResources;
import com.bluecc.hubs.fund.MetaTypes;
import jodd.io.StreamGobbler;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

import static com.bluecc.gentool.ExternalTool.reimportSql;

public class GeneratorMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("* sql");
        SqlGenTool.startGen(new SqlGenTool.GenOpts(true));
        System.out.println("* entity types");
        EntityTypesTool.startGen();

        System.out.println("* proto");
        MetaTypes.reloadMetaList();  // force reload "asset/mysql/hubs.json"
        ProtoTool.startGen(new ProtoTool.ProtoGenOpts(null, true));
        System.out.println("* proto types");
        ProtoTypeTool.startGen();

        System.out.println("* head entities");
        GenHeadEntities.startGen();

        System.out.println("* entity names (symbols)");
        ProcGen.startGen();  // generate EntityNames.java

        System.out.println("* stereo data");
        StereotypeTool.startGen();
        System.out.println("* stereo types (livecases)");
        StereotypeAddons.startGen();  // livecases

        System.out.println("* rpc");
        RpcGenTool.startGen();  // rpc_crud.j2, facade.j2

        System.out.println("* profiles");
        GenProfile.startGen();

        // reimportSql("hubs");
    }

}
