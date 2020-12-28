package com.liulu.test;

public class Test {

    public static void test(){
        Object object1 = new Object();
        Object object2 = new Object();
        System.out.println(object1.hashCode() == object2.hashCode());
    }

    public static void main(String[] args) {
        test();
    }

}
