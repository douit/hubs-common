package com.bluecc.income.dao;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.stub.PaymentData;
import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.model.Payment;
import com.github.javafaker.Faker;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static com.bluecc.hubs.stereotypes.PaymentApplicationTestsData.Payment_appltest10000;
import static com.bluecc.income.dao.PaymentDelegator.FROM_PARTY;
import static com.bluecc.income.dao.PaymentDelegator.TO_PARTY;
import static org.junit.Assert.*;

public class PaymentDelegatorTest extends AbstractStoreProcTest {
    @Inject
    PaymentDelegator payments;

    @Before
    public void setUp() throws Exception {
        setupEntities("Payment");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId = sequence.nextStringId();
            PaymentFlatData flatData = PaymentFlatData.newBuilder()
                    .setPaymentId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, payments.create(ctx, flatData));
            assertEquals(1, payments.update(ctx, flatData));
            assertEquals(1, payments.find(ctx, flatData).size());
            assertEquals(1, payments.findById(ctx, flatData).size());
            assertEquals(1, payments.delete(ctx, flatData));
            assertEquals(0, payments.find(ctx, flatData).size());
        });
    }

    @Test
    public void testCreatePayment() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            String newId = sequence.nextStringId();
            PaymentData flatData = PaymentData.newBuilder()
                    .setPaymentId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, payments.create(c, flatData));
        });
    }

    @Test
    public void testFindPayment() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            Payment payment = genericProcs.findOne(c, Payment_appltest10000, Payment.class);
            System.out.println(payment);
            assertNotNull(payment);
        });
    }

    @Test
    public void testQueryPayments() {
        process(c -> {
            // PaymentDelegator.PaymentDao dao = c.getHandle().attach(PaymentDelegator.PaymentDao.class);
            String key = Payment_appltest10000.getPaymentId();
            payments.queryPaymentRelations(key, Sets.newHashSet(
                            FROM_PARTY, TO_PARTY
                    )).apply("")
                    .subscribe(e -> {
                        assertNotNull(e);
                        assertTrue(ProtoTypes.hasFieldValue(e.toData(), "from_party"));
                    });
        });
    }
}
