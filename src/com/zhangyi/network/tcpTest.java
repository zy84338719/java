package com.zhangyi.network;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import java.net.ServerSocket;

public class tcpTest {
}

class TcpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动");
        //创建客户端对象，明确目的地址和端口
        Socket s = new Socket("127.0.0.1",3997);
        //获取socket对象的IO流对象，将数据发送到服务端
        OutputStream os = s.getOutputStream();//getOutputStream() 返回此套接字的输出流。
        //通过输出流写数据
        os.write("helloWorld".getBytes());
        //获取socket的输入流对象
        InputStream is = s.getInputStream();//getInputStream() 返回此套接字的输入流。
        //通过输入流对象读服务端反馈的数据
        byte[] buf = new byte[1024];
        int len = is.read(buf);
        String data = new String(buf,0,len);
        System.out.println(data);
        s.close();
    }
}

/*
 * 创建服务器端：
 * 1、创建SeverSocket对象，需要监听端口
 * 2、获取客户端socket对象，通过客户端的socket IO流和客户端进行通信
 * 3、获取客户端的socket的读取流
 * 4、读取数据并显示
 */

class TcpSever {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动");
        //创建服务器端对象
        ServerSocket ss=new ServerSocket(3997);
        //获取客户端对象
        Socket s = ss.accept();//accept() 侦听并接受到此套接字的连接。
        //通过客户端对象获取socket的读取流
        InputStream is = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = is.read(buf);
        String data = new String(buf,0,len);
        String ip = s.getInetAddress().getHostAddress();
        System.out.println("from--"+ip+":"+data);
        //向客户端反馈数据
        OutputStream os = s.getOutputStream();
        os.write("收到消息".getBytes());

        s.close();
        ss.close();}
}
