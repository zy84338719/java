package com.zhangyi.ForkAndJoin;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class PrimeTask extends RecursiveTask<Integer>{
    private static final long serialVersionUID = -6196480027075657316L;

    private static final int THRESHOLD = 50;

    private Integer sum = 0;
    private int low;

    private int high;

    public PrimeTask(int low, int high) {
        this.low = low;
        this.high = high;
    }

    @Override
    protected Integer compute() {

        if (high - low <= THRESHOLD) {
            // 小于阈值则直接计算
            for (int i = low; i < high; i++) {
                BigInteger m = new BigInteger(String.valueOf(i));
                if(m.isProbablePrime(1)){
                    System.out.println(i);
                    sum+=1;
                }
            }
        } else {
            // 1. 一个大任务分割成两个子任务
            int mid = (low + high) >>> 1;
            PrimeTask left = new PrimeTask(low, mid);
            PrimeTask right = new PrimeTask(mid + 1, high);

            // 2. 分别计算
            left.fork();
            right.fork();

            // 3.合并结果
            sum = right.join()+left.join();

        }
        return sum;
    }
}
