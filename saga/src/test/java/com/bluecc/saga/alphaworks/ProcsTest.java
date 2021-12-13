package com.bluecc.saga.alphaworks;

import com.bluecc.testkit.AbstractOnceProcTest;
import com.bluecc.testkit.AbstractProcTest;
import org.junit.Test;

public class ProcsTest extends AbstractOnceProcTest {
    @Test
    public void testSequence(){
        System.out.println(sequence.nextId());
    }
}
