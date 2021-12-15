package com.bluecc.saga.alphaworks;

import akka.Done;
import akka.actor.testkit.typed.javadsl.TestKitJunitResource;
import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import com.bluecc.hubs.fund.FnUtil;
import com.bluecc.saga.alphaworks.PartyAlphaMesh.Conductors.PartyConductor;
import com.bluecc.saga.alphaworks.PartyAlphaMesh.PartyEnabled;
import com.bluecc.saga.common.IMessageEvent;
import com.bluecc.saga.common.OnState;
import com.bluecc.saga.common.StateAction;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import lombok.extern.slf4j.Slf4j;
import org.junit.ClassRule;
import org.junit.Test;
import org.scalatestplus.junit.JUnitSuite;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Consumer;

import static java.lang.Thread.sleep;

@Slf4j
public class PartyAlphaMeshTest extends JUnitSuite {
    @ClassRule
    public static final TestKitJunitResource testKit = new TestKitJunitResource();

    // @Test
    // public void testPartyActor(){
    //     ActorRef<PartyAlphaMesh.Event> actor =
    //             testKit.spawn(PartyConductor.create(
    //                     new PartyAlphaMesh.DataAccessor() {
    //                         @Override
    //                         public CompletionStage<Done> update(PartyAlphaMesh.Event event) {
    //                             return CompletableFuture.completedFuture(Done.getInstance());
    //                         }
    //                     },
    //                     ArrayListMultimap.create(),
    //                     PartyAlphaMesh.ReEnable.INSTANCE));
    //
    // }

    public interface IAction {
        void action(Method method, Object[] params);
    }


    public static class AlphaMesh implements PartyAlphaMesh.DataAccessor, IAction {
        TestProbe<PartyAlphaMesh.Event> testProbe = testKit.createTestProbe();
        ActorRef<PartyAlphaMesh.Event> mesh;
        Multimap<Class<?>, StateAction<IMessageEvent>> actionMap;

        AlphaMesh() {
            collect();
            spawn();
        }

        @SuppressWarnings("unchecked")
        void collect() {
            Class<?> clazz = getClass();
            System.out.println(".. collecting");
            actionMap = ArrayListMultimap.create();
            Arrays.stream(clazz.getDeclaredMethods())
                    .peek(m -> {
                        System.out.println(m.getName());
                    })
                    .filter(m -> m.isAnnotationPresent(OnState.class))
                    .forEach(m -> {
                        System.out.println("register: " + m.getName());
                        Type[] acceptParams = FnUtil.getActualTypeArguments(m);
                        System.out.println(acceptParams[0]);
                        System.out.println("is disable: "
                                + (PartyAlphaMesh.Disable.class == acceptParams[0]));
                        System.out.println("is re-enable: "
                                + (PartyAlphaMesh.ReEnable.class == acceptParams[0]));
                        try {
                            actionMap.put(m.getAnnotation(OnState.class).value(),
                                    new StateAction(acceptParams,
                                            (Consumer<? extends IMessageEvent>) m.invoke(this)));
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                            throw new RuntimeException(e.getMessage(), e);
                        }
                    });
        }

        void spawn() {
            mesh = testKit.spawn(PartyConductor.create(this,
                    actionMap,
                    PartyAlphaMesh.ReEnable.INSTANCE), "admin");
        }

        public CompletionStage<Done> update(PartyAlphaMesh.Event event) {
            log.info("update {}", event);
            return CompletableFuture.completedFuture(Done.getInstance());
        }

        void disable() {
            mesh.tell(PartyAlphaMesh.Disable.INSTANCE);
        }

        void reEnable() {
            mesh.tell(PartyAlphaMesh.ReEnable.INSTANCE);
        }

        void assign(String msg) {
            mesh.tell(PartyAlphaMesh.Assigned.pack(msg));
        }

        public void action(Method method, Object[] params) {
            mesh.tell(new PartyAlphaMesh.DerivedEvent()
                    .action(method.getName())
                    .params(params));
        }
    }

    // impl
    static class DummyParty extends AlphaMesh {
        // 在PartyEnabled状态下接收事件类型为PartyAlphaMesh.Disable的事件
        // 因为是继承的AlphaMesh, 结果可以通过其它的actorRef传出,
        // 因此Consumer接口就足够了
        @OnState(PartyEnabled.class)
        Consumer<PartyAlphaMesh.Disable> warn() {
            return e -> System.out.println("a warn: " + e);
        }

        @OnState(PartyEnabled.class)
        Consumer<PartyAlphaMesh.Assigned> infoAssign() {
            return e -> System.out.println("***** do assign: " + e);
        }
    }
    //
    // public static class TargetInterceptor implements MethodInterceptor {
    //     @Override
    //     public Object intercept(Object obj, Method method, Object[] params,
    //                             MethodProxy proxy) throws Throwable {
    //         if (method.isAnnotationPresent(OnState.class)) {
    //             System.out.println("before");
    //             // Object result = proxy.invokeSuper(obj, params);
    //             ((IAction) obj).action(method, params);
    //             // System.out.println("after: " + result);
    //             // return result;
    //             System.out.println("after");
    //             return null;
    //         } else {
    //             return proxy.invokeSuper(obj, params);
    //         }
    //     }
    // }

    @Test
    public void testAlphaMesh() {
        // Enhancer enhancer = new Enhancer();
        // enhancer.setSuperclass(DummyParty.class);
        // enhancer.setCallback(new TargetInterceptor());
        // DummyParty alphaMesh = (DummyParty) enhancer.create();

        DummyParty alphaMesh = new DummyParty();
        // alphaMesh.spawn(collect(DummyParty.class));

        // alphaMesh.talk();
        // DummyParty alphaMesh=new DummyParty();
        alphaMesh.assign("samlet");
        // alphaMesh.talk();
        alphaMesh.disable(); // dead-letter
    }

    @Test
    public void testUnit() throws InterruptedException {
        // TestProbe<PartyAlphaMesh.Event> testProbe = testKit.createTestProbe();
        ActorRef<PartyAlphaMesh.Event> underTest = testKit.spawn(PartyConductor.create(
                event -> {
                    log.info("update {}", event);
                    return CompletableFuture.completedFuture(Done.getInstance());
                },
                ArrayListMultimap.create(),
                PartyAlphaMesh.ReEnable.INSTANCE), "admin");

        // underTest.tell(new AphaMesh("Charles", testProbe.getRef()));
        // testProbe.expectMessage(new AphaMeshResponse("Charles", underTest));

        underTest.tell(PartyAlphaMesh.Disable.INSTANCE);
        underTest.tell(PartyAlphaMesh.Disable.INSTANCE);  // cause unhandled(dead-letters)
        sleep(1000);
        underTest.tell(PartyAlphaMesh.ReEnable.INSTANCE);

        underTest.tell(PartyAlphaMesh.Assigned.pack("by samlet"));
    }

}

