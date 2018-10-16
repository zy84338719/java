package com.zhangyi.multithread.Producer;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    private Lock lock = new ReentrantLock(true);
    private Condition conditionWrite = lock.newCondition();
    private Condition conditionRead = lock.newCondition();
    public int MAXSIZE;
    private Queue<Integer> queue;
    private int m=0;
        public ProducerConsumer(Queue<Integer> queue, int max){
        this.queue = queue;
        this.MAXSIZE = max;
    }

    public void set() {
        try {
            lock.lock();
            while (queue.size()>=MAXSIZE) {
                System.out.println("生产堆积！！！！！！！！！");
                conditionWrite.await();
            }
            queue.offer(m++);
            System.out.println("生产【产品"+m+"】");

            conditionRead.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (queue.size()<MAXSIZE) {
                System.out.println("产品空！！！！！！！！！");
                conditionRead.await();
            }
            Object o = queue.poll();
            if(o!=null){
                int n = (int) o;
                System.out.println("消费【产品"+n+"】");
            }

            conditionWrite.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
