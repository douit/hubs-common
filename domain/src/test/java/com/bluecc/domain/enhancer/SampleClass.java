package com.bluecc.domain.enhancer;
public class SampleClass {

    public SampleClass() {
        System.out.println(this.getClass().getSimpleName() + ": default construct method");
    }

    public SampleClass(String name) {
        System.out.println(this.getClass().getSimpleName() + ": construct method : " + name);
    }

    public String hello(String name) {
        System.out.println(this.getClass().getSimpleName() + ": hello method");
        return "Hello, " + name;
    }

    public final String finalMethod(String input) {
        System.out.println(this.getClass().getSimpleName() + ": final method");
        return "final method: " + input;
    }

    public static String staticMethod(String input) {
        System.out.println(SampleClass.class.getName() + ": static method");
        return "static method: " + input;
    }

    private String privateMethod(String input) {
        System.out.println(this.getClass().getSimpleName() + ": private method");
        return "private method: " + input;
    }

}