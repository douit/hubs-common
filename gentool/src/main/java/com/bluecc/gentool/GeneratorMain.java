package com.bluecc.gentool;

import java.io.IOException;

public class GeneratorMain {
    public static void main(String[] args) throws IOException {
        SqlGenTool.startGen(new SqlGenTool.GenOpts(true));
        EntityTypesTool.startGen();
        ProtoTool.startGen(new ProtoTool.ProtoGenOpts(null, true));
        ProtoTypeTool.startGen();
    }
}
