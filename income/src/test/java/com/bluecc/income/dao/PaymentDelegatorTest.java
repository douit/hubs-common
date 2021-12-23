package com.bluecc.income.dao;

import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.stub.PaymentData;
import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.model.Payment;
import com.github.javafaker.Faker;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Provider;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;

import static com.bluecc.hubs.stereotypes.PaymentApplicationTestsData.Payment_appltest10000;
import static com.bluecc.income.dao.PaymentDelegator.FROM_PARTY;
import static com.bluecc.income.dao.PaymentDelegator.TO_PARTY;
import static com.bluecc.income.procs.AbstractProcs.findOne;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

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
            Payment payment = findOne(c, Payment_appltest10000(), Payment.class);
            System.out.println(payment);
            assertNotNull(payment);
        });
    }

    @Test
    public void testQueryPayments() {
        process(c -> {
            // PaymentDelegator.PaymentDao dao = c.getHandle().attach(PaymentDelegator.PaymentDao.class);
            String key = Payment_appltest10000().getPaymentId();
            payments.queryPaymentRelations(key, Sets.newHashSet(
                            FROM_PARTY, TO_PARTY
                    )).apply("")
                    .subscribe(e -> {
                        // 如果没有查询到结果, 则subscribe这部分代码不会执行,
                        // 所以这里的assert没有意义, :)
                        assertNotNull(e);
                        assertTrue(ProtoTypes.hasFieldValue(e.toData(), "from_party"));
                    });
        });
    }

    public interface MeshFactory<T> {
        IMesh<T> create(T payment);
    }

    interface IMesh<T>{
        T getObject();
    }

    public static class RealPayment implements IMesh<Payment>{
        LiveObjects liveObjects;
        Sequence sequence;
        PaymentDelegator delegator;

        Payment payment;

        public RealPayment(
                LiveObjects liveObjects,
                Sequence sequence,
                PaymentDelegator delegator,
                Payment payment) {
            this.liveObjects = liveObjects;
            this.sequence = sequence;
            this.delegator=delegator;

            this.payment = payment;
        }

        void create() {
            this.payment.setPaymentId(sequence.nextStringId());
            liveObjects.persist(payment);
        }

        void load(){
            this.payment=liveObjects.merge(delegator.get(payment.getPaymentId()));
        }

        void store(){
            delegator.store(this.payment, false);
        }

        public void setStatus(String statusId){
            payment.setStatusId(statusId);
            delegator.storeOrUpdate(payment);
        }

        @Override
        public Payment getObject(){
            return payment;
        }
    }

    public static class RealPaymentFactory implements MeshFactory<Payment> {
        private final Provider<LiveObjects> liveObjectsProvider;
        private final Provider<Sequence> sequenceProvider;
        private final Provider<PaymentDelegator> delegator;

        @Inject
        public RealPaymentFactory(Provider<LiveObjects> liveObjectsProvider,
                                  Provider<Sequence> sequenceProvider,
                                  Provider<PaymentDelegator> delegator) {
            this.liveObjectsProvider = liveObjectsProvider;
            this.sequenceProvider = sequenceProvider;
            this.delegator = delegator;
        }

        @Override
        public RealPayment create(Payment payment) {
            return new RealPayment(liveObjectsProvider.get(),
                    sequenceProvider.get(),
                    delegator.get(),
                    payment);
        }
    }

    @Inject
    RealPaymentFactory paymentFactory;

    @Test
    public void testCreateObject() {
        RealPayment payment = paymentFactory.create(Payment.builder()
                .effectiveDate(LocalDateTime.now())
                .amount(new BigDecimal("17.8"))
                .build());
        payment.create();
        String newId=payment.getObject().getPaymentId();
        System.out.println(newId+", "
                +payment.getObject().getAmount());
        payment.store();

        BigDecimal amount=payments.get(newId).getAmount();
        System.out.println(amount);
        // System.out.println(amount.toBigInteger());
        // assertEquals(amount, payment.getObject().getAmount());
        assertThat(amount).isEqualByComparingTo(payment.getObject().getAmount());

        System.out.println(payment.getObject().getStatusId());
        payment.setStatus("PAYED");
        System.out.println(ProtoJsonUtils.toJson(payment.payment.toData()));
        payment.load();
        assertEquals("PAYED", payment.getObject().getStatusId());
    }
}
