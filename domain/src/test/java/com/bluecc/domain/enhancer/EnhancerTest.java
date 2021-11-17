package com.bluecc.domain.enhancer;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.beans.BulkBean;
import net.sf.cglib.proxy.*;
import net.sf.cglib.reflect.MethodDelegate;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EnhancerTest {
    @Test
    public void testPersonEnhancer() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue) () -> "Hello Tom!");
        PersonService proxy = (PersonService) enhancer.create();

        String res = proxy.sayHello(null);

        assertEquals("Hello Tom!", res);
    }

    @Test
    public void testIntercept() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setInterfaces(new Class[]{IStatusSetter.class});
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getName().equals("sayHello")
                    && method.getDeclaringClass() != Object.class
                    && method.getReturnType() == String.class) {
                return "Hello Tom!";
            } else {
                return proxy.invokeSuper(obj, args);
            }
        });

        PersonService proxy = (PersonService) enhancer.create();

        assertEquals("Hello Tom!", proxy.sayHello(null));
        int lengthOfName = proxy.lengthOfName("Mary");

        assertEquals(4, lengthOfName);

        // call with interface
        IStatusSetter setter = (IStatusSetter) proxy;
        setter.setStatusId("init");
        System.out.println(proxy.getStatusId());
        assertEquals("init", proxy.getStatusId());
        // 不支持接口里的default方法
        // System.out.println(((IStatusSetter) proxy).getStatusDesc());
    }

    @Test
    public void testIntercept2() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        CallbackHelper callbackHelper = new CallbackHelper(SampleClass.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return new FixedValue() {
                        @Override
                        public Object loadObject() throws Exception {
                            return "Hello, cglib!"; // 对于被代理类中的返回类型为 String 的方法统一拦截
                        }
                    };
                } else {
                    return NoOp.INSTANCE; // 对于其它方法直接委托给被代理类
                }
            }
        };
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        SampleClass proxy = (SampleClass) enhancer.create();
        assertEquals("Hello, cglib!", proxy.hello(null));
        assertNotEquals("Hello, cglib!", proxy.toString());
        System.out.println("hash code : " + proxy.hashCode()); // 调用 hashCode 方法也能正常返回哈希值了
    }

    public interface Interface1 {
        String first();
    }

    public interface Interface2 {
        String second();
    }

    public static class Class1 implements Interface1 {
        @Override
        public String first() {
            return "first behaviour";
        }
    }

    public static class Class2 implements Interface2 {
        @Override
        public String second() {
            return "second behaviour";
        }
    }

    public interface MixinInterface extends Interface1, Interface2 {
    }

    @Test
    public void testMixin() {
        Mixin mixin = Mixin.create(
                new Class[]{Interface1.class, Interface2.class, MixinInterface.class},
                new Object[]{new Class1(), new Class2()}
        );
        MixinInterface mixinDelegate = (MixinInterface) mixin;

        assertEquals("first behaviour", mixinDelegate.first());
        assertEquals("second behaviour", mixinDelegate.second());
    }

    @Test
    public void testMixinCreate() {
        // Mixin mixin = Mixin.create(
        //         new Class[]{IStatusSetter.class},
        //         new Object[]{new PersonService()});
        // IStatusSetter setter=(IStatusSetter)mixin;
        // setter.setStatusId("init");
        // System.out.println(setter.getStatusDesc());
    }

    @Data
    // @Accessors(chain = true)
    @Builder
    public static class User{
        String name;
        Integer age;
    }

    @Test
    public void testBulkBean(){
        BulkBean bulkBean = BulkBean.create(
                User.class,
                new String[] {"getName", "getAge"},
                new String[] {"setName", "setAge"},
                new Class[] {String.class, Integer.class});

        User user = User.builder().name("zhenchao").age(26).build();

        // 通过 bulk 来获取 bean 属性
        Assert.assertEquals(2, bulkBean.getPropertyValues(user).length);
        Assert.assertEquals("zhenchao", bulkBean.getPropertyValues(user)[0]);
        Assert.assertEquals(26, bulkBean.getPropertyValues(user)[1]);

        // 通过 bulk 来设置 bean 属性
        bulkBean.setPropertyValues(user, new Object[] {"xiaotang", 26});
        Assert.assertEquals("xiaotang", user.getName());

        // map
        BeanMap map = BeanMap.create(user);
        Assert.assertEquals("xiaotang", map.get("name"));
        Assert.assertEquals(26, map.get("age"));
    }

    @Test
    public void testDelegate(){
        PersonService bean=new PersonService();
        bean.setStatusId("init");
        Interface1 delegate = (Interface1) MethodDelegate.create(bean,
                "getStatusId", Interface1.class);
        // 调用接口的 Interface1#first 方法本质上在调用 SampleBean#getStatusId 方法
        Assert.assertEquals("init", delegate.first());
    }
}
