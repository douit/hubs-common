package com.bluecc.income.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.bluecc.income.endpoint.RpcClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * $ just cli ping
 * $ just cli --help
 * $ just cli ping -i "hellow,world"
 * $ just cli store -r order_head_simple
 */
public class CliMain {
    @Parameters(
            commandNames = { "ping" },
            commandDescription = "检测服务端是否启动"
    )
    static class PingCommand implements ICmd{
        @Parameter(names = {"--info", "-i"})
        private String info="hi";
        public void execute() throws InterruptedException {
            System.out.println(".. ping cmd");
            RpcClient.ping(info);
        }
    }

    @Parameters(
            commandNames = { "store" },
            commandDescription = "提交指定的资源文件"
    )
    static class StoreCommand implements ICmd{
        @Parameter(names = {"--resource", "-r"})
        private String resource="order_head_simple";
        public void execute() throws InterruptedException {
            System.out.println(".. store cmd");
            RpcClient.storeEntity(resource);
        }
    }

    @Parameters(
            commandNames = {"meta"},
            commandDescription = "显示实体信息"
    )
    static class MetaCommand implements ICmd {
        @Parameter(names = {"--info", "-i"})
        private String info = "hi";

        public void execute() throws InterruptedException {
            System.out.println(".. meta cmd");
            // RpcClient.meta(info);
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        @Parameter(names = "--help", help = true)
        private boolean help;
    }

    public static void main(String[] args) throws InterruptedException {
        Opts opts = new Opts();
        PingCommand pingCommand=new PingCommand();
        StoreCommand storeCommand=new StoreCommand();
        JCommander jc = JCommander.newBuilder()
                .addCommand(pingCommand)
                .addCommand(storeCommand)
                .addCommand(new MetaCommand())
                .addObject(opts)
                .build();

        if(opts.help){
            jc.usage();
        }

        jc.parse(args);
        String parsedCmdStr = jc.getParsedCommand();
        if(parsedCmdStr!=null) {
            JCommander cmdWrapper=jc.findCommandByAlias(parsedCmdStr);
            // System.out.println(cmd.getObjects().get(0).getClass().getName());
            ICmd cmd=(ICmd) cmdWrapper.getObjects().get(0);
            cmd.execute();

            // switch (parsedCmdStr) {
            //     case "ping":
            //         pingCommand.execute();
            //         break;
            //     default:
            //         System.err.println("Invalid command: " + parsedCmdStr);
            // }
        }else{
            jc.usage();
        }
    }
}

