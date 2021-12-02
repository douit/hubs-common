package com.bluecc.income.cli;

import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.income.procs.ServiceManager;
import com.google.common.collect.Maps;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.mvel2.MVEL;

import javax.inject.Inject;
import java.io.Console;
import java.io.IOException;
import java.util.Map;

import static com.bluecc.income.dummy.store.StoreModule.startup;

/**
 * $ just i cli.ConsoleMain
 */
public class ConsoleMain {
    public static void main(String[] args) throws IOException {
        // simple();
        ConsoleMain consoleMain=startup(ConsoleMain.class);
        consoleMain.interact();
    }

    @Inject
    ProtoMeta protoMeta;
    @Inject
    ServiceManager serviceManager;

    void interact() throws IOException {
        Map<String, Object> ctx = Maps.newHashMap();
        ctx.put("meta", protoMeta);
        ctx.put("srv", serviceManager);

        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();

        LineReader lineReader = LineReaderBuilder.builder()
                .terminal(terminal)
                .build();

        String prompt = "> ";
        while (true) {
            String line;
            try {
                line = lineReader.readLine(prompt);
                System.out.println(line);
                if(line.trim().equals("quit")){
                    break;
                }
                try {
                    Object object = MVEL.eval(line, ctx);
                    System.out.println("〰️ " + object);
                }catch (RuntimeException e){
                    System.err.println("‼️ "+e.getMessage());
                    e.printStackTrace();
                }
            } catch (UserInterruptException e) {
                // Do nothing
            } catch (EndOfFileException e) {
                System.out.println("\nbye.");
                return;
            }
        }
    }

    private static void simple() {
        Map<String, Object> ctx = Maps.newHashMap();

        Console console = System.console();
        String line = console.readLine("> ");
        while (!line.equals("quit")){
            System.out.println(line);
            try {
                Object object = MVEL.eval(line, ctx);
                System.out.println("_ " + object);
            }catch (RuntimeException e){
                System.err.println(e.getMessage());
            }

            line = console.readLine("> ");
        }
    }
}
