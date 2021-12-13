package com.bluecc.saga.meshes;

import com.bluecc.income.dao.InvoiceDelegator;
import com.bluecc.saga.MeshTestBase;
import org.junit.Test;

public class SampleMeshTest extends MeshTestBase {
    @Test
    public void testCount() {
        process(c -> {
            InvoiceDelegator.Dao dao = c.getHandle().attach(InvoiceDelegator.Dao.class);
            System.out.println(dao.countInvoice());
        });
    }
}
