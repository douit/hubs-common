package com.bluecc.gentool;

import java.io.*;

public class ExternalTool {
    public static void main(String[] args) throws IOException, InterruptedException {
        reimportSql("hubs");
    }

    public static void reimportSql(String db) throws IOException{
        File file=new File("asset/mysql/hubs.sql");
        System.out.println("... import "+file);
        if(file.exists()) {
            Process process;
            ProcessBuilder builder = new ProcessBuilder(
                    "mysql", "-uroot", "-proot", db);
            // ProcessBuilder builder = new ProcessBuilder("/bin/sh", "-c",
            //         "mysql -uroot -proot hubs < "+ file);

            builder.redirectInput(ProcessBuilder.Redirect.from(file));
            process = builder.start();
            // StreamGobbler streamGobbler =
            //         new StreamGobbler(process.getInputStream(), System.out);
            // Executors.newSingleThreadExecutor().submit(streamGobbler);
            // int exitCode = process.waitFor();
            // assert exitCode == 0;

            InputStream is = process.getInputStream();
            // Now read from it and write it to standard output.
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        }else{
            // System.out.println("File not found: "+file);
            throw new IOException("Cannot find file "+file);
        }
    }
}

