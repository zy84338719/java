package com.zhangyi.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPclient {
    public static void main(String[] args) {
        //使用ServerSocket代表基于TCP/IP协议建立的服务端
        Socket client = null;
        //输出流向服务端发出消息
        PrintWriter out = null;
        //输入流接收服务端消息
        BufferedReader in = null;
        try {
            System.out.println("客户端准备连接服务端...");
            Thread.sleep(1000);
            // 对象建立即代表连接成功
            //调用构造器传入两个参数
            //1.服务端所在ip地址，因为是本机所以这里写127.0.0.1
            //2.服务端的端口号，这里需要与刚才编写的服务端端口号相同
            client = new Socket("127.0.0.1", 9999);
            System.out.println("连接成功~");

            //客户端向服务端信息
            out = new PrintWriter(client.getOutputStream());
            out.println("你好");
            out.flush();
            //接收服务端消息
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("服务端："+in.readLine());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //同样的，关闭各种资源
            try {
                if(client != null){
                    client.close();
                }
                if(in != null){
                    in.close();
                }
                if(out != null){
                    out.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    }
}
