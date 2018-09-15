package com.zhangyi.zip;

import java.io.File;
import java.util.Scanner;

import static com.zhangyi.zip.Tar.cutFile;
import static com.zhangyi.zip.Tar.unitFile;
import static com.zhangyi.zip.Zip.cut;
import static com.zhangyi.zip.Zip.unit;

public class Main {
    public static void main(String[] args) throws Exception {
//        拆分压缩
        System.out.println("请输入你要选择的程序运行");
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        if(n==0) {
            cutFile("." + File.separator + "demo" + File.separator + "test1.txt", "." + File.separator + "demo" + File.separator + "test" + File.separator, 100);
        }
        else if(n==1){
            unitFile("." +File.separator + "demo" +File.separator+"test2.txt","." +File.separator + "demo" +File.separator + "test"+File.separator,"");
        }
        else if(n==2){
            cut("." +File.separator + "demo" +File.separator+"demo1" +File.separator+"test3.txt","." +File.separator + "demo" +File.separator+"text1"+File.separator);
        }
        else {
            unit("." +File.separator + "demo" +File.separator + "demo1" +File.separator+"test3.txt","." +File.separator + "demo" +File.separator+ "text" +File.separator ,"");
        }
    }

}
