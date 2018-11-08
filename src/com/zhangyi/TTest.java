package com.zhangyi;


import org.junit.Test;

public class TTest {

    /**
     *
     */
    @Test
    public void test(){
        String a = " world";
        a.concat("hello");
        System.out.printf(a);

    }


    @Test
    public void test1(){
        A a = new B();
        a=new B();
    }
}


class A{
    static {
        System.out.println("1");
    }
    public A(){
        System.out.println("A");
    }
    {
        System.out.println("a");
    }
}

class B extends A{
    static {
        System.out.println("2");
    }
    public B(){
        System.out.println("B");
    }
    {
        System.out.println("b");
    }
}