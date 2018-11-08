package com.zhangyi.network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPservice {

        public static void main(String[] args) {
            // 使用ServerSocket代表基于TCP/IP协议建立的服务端
            ServerSocket server = null;
            // 输入流用于接收客户端发来的消息
            BufferedReader in = null;
            // 输出流用于将消息返还给客户端
            PrintWriter out = null;

            try {
                // 创建ServerSocket对象，调用构造器ServerSocket(int port)指定端口号port
                // 对象创建，代表服务端已经启动，网络资源也需要关闭
                server = new ServerSocket(9999);
                // 9999为服务端的端口号
                // 1-1000端口号操作系统默认应用占用，还有特殊的端口
                // eg.tomcat-8080 orcal-1521 mysql-3306 ...
                // 大数据软件占用端口 16010-hbase 9000-hdfs 2080-zookeeper
                System.out.println("正在等待连接...");

                // accept对象不为空代表服务端和客户端建立成功
                // 没有客户端连接时accept()方法会造成线程阻塞，等待客户端连接
                Socket accept = server.accept();
                System.out.println("客户端连接成功...");

                //创建输入流对象，调用getInputStream()方法接收客户端消息
                in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                //打印客户端发来的消息到控制台
                System.out.println("客户端：" + in.readLine());

                //创建输出流对象，调用getOutputStream()方法向客户端传递消息
                out = new PrintWriter(accept.getOutputStream());
                out.println("你好 我是服务端");
                out.flush();

                //以下为一些方法用来查看客户端中的一些信息
                String ip = accept.getInetAddress().getHostAddress();
                System.out.println("客户端ip为：" + ip);
                int c_port = accept.getPort();
                System.out.println("客户端端口号为：" + c_port);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                //关闭各种开启的资源，关闭原则：后开启的先关闭
                try {
                    if (out != null) {
                        out.flush();
                        out.close();
                    }
                    if (in != null) {

                        in.close();
                    }
                    if (server != null) {
                        server.close();
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
}
