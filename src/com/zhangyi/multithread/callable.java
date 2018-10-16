package com.zhangyi.multithread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class callable implements Callable<String> {
    @Override
    public String call() throws Exception{
        String name = Thread.currentThread().getName();
        System.out.println(name);
        return name;
    }
}
class TestDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask(new callable());
        new Thread(task).start();
        System.out.println(task.get());
    }
}
