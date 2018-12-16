package com.zhangyi.magicFactory;

import java.util.*;

public class ideaFactory {
//    public static void main(String arg[]){
////        System.out.println(number_of_cards(5.19f));
//        System.out.println(beauty_of_array(new int[]{1,2,3,3}));
//    }

    public static int number_of_cards(float length){
        double sum = 0;
        for(int i=1;;i++){
            sum+=1.0/(i+1);
            if(sum > length){
                return i;
            }
        }
    }

//    public static int beauty_of_array(int[] array){
//        int sum=0;
//        int s;
//        int step = 1;
//        while (step <= array.length ){
//            s = count(array, step);
//            sum=sum+s;
//            step++;
//        }
//
//        return sum;
//    }
//
//    public static int count(int[] array, int step){
//        int res = 0;
//        Set<Integer> set = new HashSet<>();
//        int temp ;
//        int index;
//        if(step>1){
//            for(int i=0;i<array.length-step+1;i++){
//                temp = 0;
//                while (temp<step){
//                    index = i+temp;
//                    res+=array[index];
//                    temp++;
//                }
//            }
//        }
//        else{
//            for (int i = 0; i < array.length-1; i++)
//            {
//                for (int j = i+1; j < array.length; j++)
//                {
//                    if ((array[i] == array[j]) && (i != j))
//                    {
//                        set.add(array[j]);
//                    }
//                }
//            }
//            boolean flag;
//            for(int i:array){
//                flag=true;
//                for (int j: set){
//                    if(i==j){
//                        flag=false;
//                    }
//                }
//                if(flag){
//                    res+=i;
//                }
//            }
//        }
//        return res;
//    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            String input=sc.nextLine();
            String[] numString=input.trim().split("\\s+");
            int[] nums=new int[numString.length];
            for(int i=0;i<nums.length;i++) {
                nums[i] = Integer.valueOf(numString[i]);
            }
            int sum=0;
            for(int i=0;i<nums.length;i++){
                int s = countOne(nums,i);
                System.out.println(nums[i]+" "+s);
                sum=sum+s;
            }
            System.out.println(sum);
        }
    }
    public static int countOne(int[] nums,int index){
        int now=nums[index];
        int temp=index;
        while((index-1)>=0){
            if(nums[index-1]==now) break;
            index--;
        }
        return (temp-index+1)*(nums.length-temp)*now;
    }
}
