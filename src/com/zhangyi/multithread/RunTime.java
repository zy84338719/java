package com.zhangyi.multithread;

public class RunTime {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        System.out.println("1.MAX = "+byteToM(run.maxMemory()));
        System.out.println("1.free = "+byteToM(run.freeMemory()));
        System.out.println("1.total = "+byteToM(run.totalMemory()));
        String str = "";
        for (int i=0;i<2222;i++
             ) {
            str +=i;
        }
        run.gc();
        System.out.println("2.MAX = "+byteToM(run.maxMemory()));
        System.out.println("2.free = "+byteToM(run.freeMemory()));
        System.out.println("2.total = "+byteToM(run.totalMemory()));

    }

    public static double byteToM(long num){
        return (double) num / 1024 / 1024;
    }
}
