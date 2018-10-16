package com.zhangyi.multithread.ForkAndJoin;

import java.util.Random;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {

    private static final long serialVersionUID = -6196480027075657316L;

    private static final int THRESHOLD = 500;

    private long[] array;

    private int low;

    private int high;

    public SumTask(long[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    @Override
    protected Long compute() {
        Long sum = 0L;
        if (high - low <= THRESHOLD) {
            // 小于阈值则直接计算
            for (int i = low; i < high; i++) {
                sum += array[i];
            }
        } else {
            // 1. 一个大任务分割成两个子任务
            int mid = (low + high) >>> 1;
            SumTask left = new SumTask(array, low, mid);
            SumTask right = new SumTask(array, mid + 1, high);

            // 2. 分别计算
            left.fork();
            right.fork();

            // 3. 合并结果
            sum = left.join() + right.join();
        }
        return sum;
    }

    public static long[] genArray(int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextLong();
        }
        return array;
    }
}


