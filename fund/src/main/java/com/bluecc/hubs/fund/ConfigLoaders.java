package com.bluecc.hubs.fund;

import com.google.common.base.Suppliers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.yaml.snakeyaml.Yaml;

import javax.inject.Singleton;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.function.Supplier;

@Singleton
public class ConfigLoaders {

    static Reader reader(String source) throws FileNotFoundException {
        return new FileReader(SystemDefs.prependHubsHomeFile(source));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ConfigSupplier {
        List<String> entities;
        List<String> types;
        @SneakyThrows
        private static ConfigSupplier exportEntities()  {
            Yaml yaml=new Yaml();
            return yaml.loadAs(reader("asset/facts/exports.yml"),
                    ConfigSupplier.class);
        }
    }

    Supplier<ConfigSupplier> exportsSupplier;
    public ConfigLoaders(){
        exportsSupplier = Suppliers.memoize(ConfigSupplier::exportEntities);
    }

    public List<String> getExportTypes(){
        return exportsSupplier.get().types;
    }
}
