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
    static class PingCommand {
        @Parameter(names = {"--info", "-i"})
        private String info="hi";
        void execute() throws InterruptedException {
            System.out.println(".. ping cmd");
            RpcClient.ping(info);
        }
    }

    @Parameters(
            commandNames = { "store" },
            commandDescription = "提交指定的资源文件"
    )
    static class StoreCommand {
        @Parameter(names = {"--resource", "-r"})
        private String resource="order_head_simple";
        void execute() throws InterruptedException {
            System.out.println(".. store cmd");
            RpcClient.storeEntity(resource);
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
                .addObject(opts)
                .build();

        if(opts.help){
            jc.usage();
        }

        jc.parse(args);
        String parsedCmdStr = jc.getParsedCommand();
        if(parsedCmdStr!=null) {
            switch (parsedCmdStr) {
                case "ping":
                    pingCommand.execute();
                    break;

                case "store":
                    storeCommand.execute();
                    break;

                default:
                    System.err.println("Invalid command: " + parsedCmdStr);
            }
        }else{
            jc.usage();
        }
    }
}

