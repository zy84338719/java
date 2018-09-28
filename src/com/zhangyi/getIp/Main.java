package com.zhangyi.getIp;

import java.io.IOException;

import static com.zhangyi.getIp.curl.readfile;

public class Main {
    public static void main(String[] args) {
        try {
            curl.getIp("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(readfile("/opt/dev/java/Course/ip"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
