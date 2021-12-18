package com.bluecc.gentool;

import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.nio.file.Path;
import java.util.stream.Stream;

import static com.bluecc.hubs.fund.Util.scanFiles;

public class GenCfgScanner {
    @Data
    public static class GenCfgItems{
        String profile;
    }

    @Data
    @Builder
    public static class GenCfg{
        GenCfgItems configItems;
        Path path;
        Path folder;
    }

    public static void main(String[] args) {
        String cfgFileName="gencfg.yml";
        GenCfgScanner scanner = new GenCfgScanner();
        Stream.of("income/src").flatMap(d -> scanFiles(d, cfgFileName).stream())
                .map(path -> createGenCfg(path))
                .forEach(cfg -> System.out.println(cfg));
    }

    @SneakyThrows
    private static GenCfg createGenCfg(Path path) {
        Yaml yaml=new Yaml();
        GenCfgItems cfgItems=yaml.loadAs(new FileReader(path.toFile()), GenCfgItems.class);
        return GenCfg.builder()
                .path(path)
                .folder(path.getParent())
                .configItems(cfgItems)
                .build();
    }

}
