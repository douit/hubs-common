package com.bluecc.gentool;

import jodd.io.StreamGobbler;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

import static com.bluecc.gentool.ExternalTool.reimportSql;

public class GeneratorMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        SqlGenTool.startGen(new SqlGenTool.GenOpts(true));
        EntityTypesTool.startGen();
        ProtoTool.startGen(new ProtoTool.ProtoGenOpts(null, true));
        ProtoTypeTool.startGen();
        GenHeadEntities.startGen();

        // reimportSql("hubs");
    }

}
