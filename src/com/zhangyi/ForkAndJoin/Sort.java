package com.zhangyi.ForkAndJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Sort {
    class FKQS extends RecursiveAction {

        int [] arr;
        int start;
        int end;
        FKQS(int[]arr,int start,int end){
            this.arr = arr;
            this.start = start;
            this.end = end;
        }
        @Override
        protected void compute() {
            if(end - start>0) {

                int L = start;
                int R = end;
                int temp = arr[L];
                while(L!=R) {
                    while(R>L) {
                        if(arr[R]<temp) {
                            arr[L] = arr[R];
                            break;
                        }
                        R--;
                    }
                    while(L<R) {
                        if(arr[L]>temp) {
                            arr[R] = arr[L];
                            break;
                        }
                        L++;
                    }
                }
                arr[L]=temp;
                FKQS segmentL = new FKQS(arr,start,L-1);
                FKQS segmentR = new FKQS(arr,L+1,end);
                segmentL.fork();
                segmentR.fork();
                segmentL.join();
                segmentR.join();
            }
        }
    }
    //测试代码
    public static void main(String[] args) {
        int [] arr = {8,3,4,2,6,5,0,7,2};
        RecursiveAction f = new Sort().new FKQS(arr,0,arr.length-1);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(f);
        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }
}