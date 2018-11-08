package com.zhangyi.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class EchoServer implements Runnable{

    static List<Socket> socketList=new ArrayList<Socket>();
    // 读取 In
    static Socket socket = null;
    static ServerSocket serverSocket = null;
    public EchoServer() {// 构造方法
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {// 此处直接抛错
        Scanner input = new Scanner(System.in);
        EchoServer echoServer = new EchoServer();
        int count = 0;
        System.out.println("我是服务端。。。。。。。");
        boolean flag = true;
        while (flag) {
            socket = serverSocket.accept();
            count++;
            System.out.println("第" + count + "个客户已连接");
            socketList.add(socket);
            Print p = new Print(socket);
            Thread read = new Thread(echoServer);
            Thread print = new Thread(p);
            read.start();
            print.start();
        }
    }



    @Override
    public void run() {
        // 重写run方法
        try {
            Thread.sleep(1000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            while (true) {
                String output = in.readLine();
                System.out.println( output);
                for (Socket socket:socketList) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    if (socket!=EchoServer.socket) {
                        out.println(output);
                    }
                    out.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Print implements Runnable {
    static List<Socket> socketList=new ArrayList<Socket>();
    Scanner input = new Scanner(System.in);
    public Print(Socket s) {// 构造方法
        try {
            socketList.add(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            while (true) {
                String msg = input.next();
                for (int i = 0; i < socketList.size(); i++) {
                    Socket socket=socketList.get(i);
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    out.println("服务端:"+msg);
                    out.flush();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}