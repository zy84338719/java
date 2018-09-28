package com.zhangyi.ForkAndJoin;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import static com.zhangyi.ForkAndJoin.SumTask.genArray;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        sumtask();

        Prime();
    }

    private static void sumtask() throws ExecutionException, InterruptedException {
        long[] array = genArray(1000000);

        System.out.println(Arrays.toString(array));

        // 1. 创建任务
        SumTask sumTask = new SumTask(array, 0, array.length - 1);

        long begin = System.currentTimeMillis();

        // 2. 创建线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 3. 提交任务到线程池
        forkJoinPool.submit(sumTask);

        // 4. 获取结果
        Long result = sumTask.get();

        long end = System.currentTimeMillis();

        System.out.println(String.format("结果 %s 耗时 %sms", result, end - begin));
    }

    private static void Prime() throws ExecutionException, InterruptedException {


        // 1. 创建任务
        PrimeTask prime = new PrimeTask(0, 100000);

        long begin = System.currentTimeMillis();

        // 2. 创建线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 3. 提交任务到线程池
        forkJoinPool.submit(prime);

        // 4. 获取结果
        Integer result = prime.get();
        long end = System.currentTimeMillis();

        System.out.println(String.format("结果共计 %s个, 耗时 %sms", result ,end - begin));
    }
}
