package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.gentool.dummy.DummyTemplateProcs;
import com.bluecc.hubs.fund.EntityMeta;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.bluecc.gentool.EntityMetaManager.readEntityMeta;


/**
 * $ just gen CrudGenTool Person Party
 */
public class CrudGenTool {
    // @Parameter(names = {"--entity", "-e"})
    // String entity;
    @Parameter
    public List<String> entities = Lists.newArrayList("Person");
    @Parameter(names = { "-log", "-verbose" }, description = "Level of verbosity")
    public Integer verbose = 1;
    public static void main(String[] args) throws IOException {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        System.out.println("Current directory is "+currentPath);

        CrudGenTool main = new CrudGenTool();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);

        if(main.entities.size()>0) {
            for (String entity : main.entities) {
                if(main.verbose==1){
                    System.out.println(".. generate "+entity);
                }
                main.gen(entity);
            }
        }else{
            System.out.println("No specific entities");
        }
    }

    void gen(String entityName) throws IOException {
        // String entityName="Person";
        File targetDir=new File("domain/src/main/java/com/bluecc/domain/generic/dao");
        Preconditions.checkArgument(targetDir.exists(),
                "Target folder doesn't exist");
        Path filePath = Paths.get(targetDir.toString(), entityName+"Repository.java");
        FileWriter writer=new FileWriter(filePath.toFile());
        gen(entityName, writer);
        writer.close();
    }

    void gen(String entityName, Writer writer) throws IOException {
        EntityMeta meta=readEntityMeta(entityName);
        DummyTemplateProcs procs=new DummyTemplateProcs();
        String cnt=procs.procCrud(meta);
        if(writer!=null){
            writer.write(cnt);
            writer.write('\n');
        }
    }
}
