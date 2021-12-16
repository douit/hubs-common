package com.bluecc.hubs.fund;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.TopKSelector;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class SelectorTest {

    @Test
    public void testOfferedThreeK() {
        for (List<Integer> list : Collections2.permutations(Ints.asList(1, 2, 3, 4, 5, 6))) {
            TopKSelector<Integer> top = TopKSelector.least(2);
            top.offerAll(list);
            assertThat(top.topK()).containsExactly(1, 2).inOrder();
        }
    }

    @Test
    public void testDifferentComparator() {
        TopKSelector<String> top = TopKSelector.least(3, String.CASE_INSENSITIVE_ORDER);
        top.offerAll(ImmutableList.of("a", "B", "c", "D", "e", "F"));
        assertThat(top.topK()).containsExactly("a", "B", "c").inOrder();
    }

}
