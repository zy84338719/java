package com.zhangyi.network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient implements Runnable{
    static Socket socket = null;
    static String name=null;
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int x=(int)(Math.random()*100);
        EchoClient.name="客户端"+x;
        System.out.println("我是客户端"+x+"");
        try {
            socket = new Socket("127.0.0.1", 8888);
            System.out.println("已经连上服务器了");
        } catch (Exception e) {
            e.printStackTrace();
        }
        EchoClient t = new EchoClient();
        Read r = new Read(socket);
        Thread print = new Thread(t);
        Thread read = new Thread(r);
        print.start();
        read.start();
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            while (true) {
                String msg = input.next();
                out.println(name+"说:"+msg);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class Read implements Runnable {
    static Socket socket = null;
    public Read(Socket socket) {
        Read.socket = socket;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            while (true) {
                System.out.println(  in.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

