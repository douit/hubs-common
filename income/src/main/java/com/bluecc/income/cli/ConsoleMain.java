package com.bluecc.income.cli;

import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.income.procs.ServiceManager;
import com.github.freva.asciitable.AsciiTable;
import com.google.common.collect.Maps;
import org.fusesource.jansi.AnsiConsole;
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
import java.time.LocalDateTime;
import java.util.Map;

import static com.bluecc.income.dummy.store.StoreModule.startup;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

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
        AnsiConsole.systemInstall();

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
                String cmd=line.trim();
                if(cmd.equals("quit")){
                    break;
                }
                boolean capture=processCmd(cmd);
                if(!capture) {
                    try {
                        Object object = MVEL.eval(line, ctx);
                        System.out.println("〰️ " + object);
                    } catch (RuntimeException e) {
                        System.err.println("‼️ " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } catch (UserInterruptException e) {
                // Do nothing
            } catch (EndOfFileException e) {
                System.out.println("\nbye.");
                break;
            }
        }

        System.exit(0);
    }

    private boolean processCmd(String cmd) {
        boolean capture=true;
        switch (cmd){
            case "now":
                String now= LocalDateTime.now().toString();
                System.out.println( ansi()
                        .fg(RED).a("Current time is ")
                        .fg(GREEN).a(now).reset() );
                break;
            case "tables":
                sampleTables();
                break;
            default:
                capture=false;
        }
        return capture;
    }

    private void sampleTables(){
        String[] headers = {"", "Name", "Diameter", "Mass", "Atmosphere"};
        String[][] data = {
                {"1", "Mercury", "0.382", "0.06", "minimal"},
                {"2", "Venus", "0.949", "0.82", "Carbon dioxide, Nitrogen"},
                {"3", "Earth", "1.000", "1.00", "Nitrogen, Oxygen, Argon"},
                {"4", "Mars", "0.532", "0.11", "Carbon dioxide, Nitrogen, Argon"}};

        System.out.println(AsciiTable.getTable(headers, data));
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
