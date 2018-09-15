package com.zhangyi.zip;

import java.io.File;

import static com.zhangyi.zip.Tar.cutFile;
import static com.zhangyi.zip.Tar.unitFile;

public class Main {
    public static void main(String[] args) throws Exception {
//        cutFile("." +File.separator + "demo" +File.separator+"test1.txt","." +File.separator + "demo" +File.separator + "test"+File.separator, 100);
        unitFile("." +File.separator + "demo" +File.separator+"test2.txt","." +File.separator + "demo" +File.separator + "test"+File.separator,"");
//        start.unite("." +File.separator + "demo" +File.separator+"test1.txt","." +File.separator + "demo" +File.separator + "test"+File.separator,"test1.txt1tmp");
    }

}
