package com.bluecc.income.types;

import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.income.model.Person;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

import javax.inject.Singleton;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;

@Singleton
@Slf4j
public class ObjectRegistries {
    Kryo kryo = new Kryo();
    Reflections reflections = new Reflections("com.bluecc.income.model");
    Set<Class<?>> modelClasses;

    ObjectRegistries() {
        modelClasses =
                reflections.get(SubTypes.of(IModel.class).asClass());
        modelClasses.forEach(e -> log.debug("register {}", e.getName()));
        register(modelClasses);
    }

    public Set<Class<?>> getModelClasses() {
        return modelClasses;
    }

    void register(Collection<Class<?>> types) {
        for (Class<?> type : types) {
            kryo.register(type);
        }
    }

    public <T> T readObject(Input input, Class<T> type) {
        return kryo.readObject(input, type);
    }

    public byte[] writeBytes(Object object) {
        Output output = new Output(new ByteArrayOutputStream());
        kryo.writeObject(output, object);
        output.close();
        return output.toBytes();
    }

    // public static void main(String[] args) {
    //     ObjectRegistries objectRegistries=new ObjectRegistries();
    // }
}
