package com.zhangyi.Producer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static Queue queue;
    public static ProducerConsumer producerConsumer;

    public static void main(String[] args) {
        queue = new LinkedList();
        producerConsumer = new ProducerConsumer(queue, 10);
        Thread p1 = new Thread(new ProducerThread());
        Thread p2 = new Thread(new ProducerThread());
        Thread c1 = new Thread(new ConsumerThread());
        Thread c2 = new Thread(new ConsumerThread());
        Thread c3 = new Thread(new ConsumerThread());
        Thread c4 = new Thread(new ConsumerThread());
        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c4.start();
        c3.start();

    }

    static class ProducerThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("当前任务名：" + Thread.currentThread().getName());
                producerConsumer.set();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ConsumerThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("当前任务名：" + Thread.currentThread().getName());
                producerConsumer.get();
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(2000)+500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
