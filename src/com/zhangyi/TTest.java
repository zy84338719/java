package com.zhangyi;


import org.junit.Test;

import java.util.Scanner;

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

    @Test
    public void test2(){
        boolean a = false;
        ok:{
            for(int i=0;i<10;i++){
                if(i==5){
                    break ok;
                }
                System.out.println(i);
            }
        }
    }

    @Test
    public void test3(){
        boolean a = true;
            for(int i=0;i<10&&a;i++){
                if(i==5){
                    a = false;
                }
                System.out.println(i);
            }
    }

    @Test
    public void test6(){
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入一个学生的成绩：");
        String score = sc.next();
        String level="";//等级
        switch(score){
            case "A":level="90-100";break;
            case "B":level="80-89";break;
            case "C":level="70-79";break;
            case "D":level="60-69";break;
            case "E":level="0-59";break;
            default :level="error";break;
        }
        System.out.println("您的成绩对应的等级是："+level);
        /*
        1.switch后面的(),里面返回的是一个具体的数值：byte ,short,char ,int ,jdk1.5增加了枚举；JDK 1.7之后 可以是String
        2.这个数值会依次跟case后面的数值进行比较，只要满足就执行后面的代码，直到遇到break结束
        3.在每个分支后面要加上一个关键字break
        4.default就是一个备胎的作用。其余的分支假如都没有走，那么一定会走default里面的代码。（类似if多分钟中的else结构）
           default可以写在任意的位置上，但是要写break结束语句。
          假如放在最后一行，break可以省略不写。（建议写在最后一行--可读性好）
        5.switch能解决的，if都能解决，if能解决的 switch不一定能解决。
        */
    }

    @Test
    public void test4(){
        short s1 = 1;
//        s1 = s1 + 1;
    }


    @Test
    public void test5(){
        final StringBuffer a = new StringBuffer("immutable");
//        a = new StringBuffer("");
        a.append(" broken!");
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
