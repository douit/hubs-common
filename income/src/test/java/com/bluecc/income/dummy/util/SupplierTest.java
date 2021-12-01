package com.bluecc.income.dummy.util;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.stub.PartyContactMechData;
import com.bluecc.hubs.stub.PersonData;
import com.google.protobuf.Message;
import com.google.protobuf.Timestamp;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class SupplierTest {
    @Test
    public void supplier() {
        Supplier<Double> doubleSupplier1 = () -> Math.random();
        DoubleSupplier doubleSupplier2 = Math::random;

        System.out.println(doubleSupplier1.get());
        System.out.println(doubleSupplier2.getAsDouble());
    }

    @Test
    public void supplierWithOptional() {
        Supplier<Double> doubleSupplier = () -> Math.random();
        Optional<Double> optionalDouble = Optional.empty();
        System.out.println(optionalDouble.orElseGet(doubleSupplier));
    }


    @Test
    public void testProtoType() {
        PersonData personData = PersonData.newBuilder().build();
        Supplier<List<PartyContactMechData>> listGetter = personData::getPartyContactMechList;
        // listGetter.get()

        PersonData.Builder builder = PersonData.newBuilder();
        builder.setLastName("samlet");

        Consumer<PartyContactMechData> listAdder = builder::addPartyContactMech;
        Consumer<List<PartyContactMechData>> listAdder2 = builder::addAllPartyContactMech;
        Consumer<Timestamp> tsMarker=builder::setCreatedTxStamp;

        System.out.println(builder.build());
        listAdder.accept(PartyContactMechData.newBuilder()
                .setComments("default address")
                .build());
        System.out.println(builder.build());

        Timestamp now=ProtoTypes.now();
        tsMarker.accept(now);
        System.out.println(builder.build());
        assertEquals(now, builder.build().getCreatedTxStamp());

        System.out.println(tsMarker.getClass().getName());


    }
}
