package com.bluecc.income.model;

import com.bluecc.income.dao.PartyDelegator;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.bluecc.hubs.fund.EntityMeta.RelationMeta.getRelVarNameByRelation;
import static com.bluecc.hubs.fund.FnUtil.getter;
import static com.bluecc.hubs.fund.FnUtil.setter;
import static com.bluecc.income.dao.PartyDelegator.PARTY_CONTACT_MECH;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
public class PersonTest {

    @Test
    public void getRelPartyContactMech() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        Person person= Person.builder()
                .lastName("samlet")
                .addPartyContactMech(PartyContactMech.builder()
                        .comments("now live")
                        .build())
                .build();

        String relVar=getRelVarNameByRelation(PARTY_CONTACT_MECH);
        assertEquals("relPartyContactMech", relVar);
        // https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandles.Lookup.html
        MethodHandle handle = lookup.findGetter(Person.class, relVar, List.class);
        List<Object> meches= (List<Object>) handle.invoke(person);
        assertEquals(1, meches.size());

        Supplier<List<PartyContactMech>> getMeches = getter(person, Person::getRelPartyContactMech);
        assertThat(getMeches.get())
                .hasSize(1)
                .hasOnlyElementsOfType(PartyContactMech.class);
        Consumer<Double> setWeight = setter(person, (a, w) -> a.weight = w);
        setWeight.accept(90.9);

        Map<String, Supplier<List<?>>> suppliers= ImmutableMap.of(
                PARTY_CONTACT_MECH, getter(person, Person::getRelPartyContactMech)
        );
        suppliers.forEach((k, v)-> {
            System.out.println(k+": "+v.get());
        });

        person.suppliers().forEach((k, v)-> {
            System.out.println(k+": "+v.get());
        });

    }

}