package com.bluecc.domain.data;

import com.bluecc.domain.guice.GuiceTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(GuiceTestRunner.class)
public class SharedDataTest {
    @Inject
    SharedData sharedData;

    @Test
    public void getClient() {
        sharedData.getClient().getSet("names")
                .addAll(Arrays.asList("first", "second"));
        sharedData.getClient().getSet("names").readAll()
                .forEach(e -> System.out.println(e));
    }
}
