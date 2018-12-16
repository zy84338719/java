package com.zhangyi;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class yuque {

    public static void main(String[] args) {
        //创建定时器对象
        Timer t=new Timer();
        //在3秒后执行MyTask类中的run方法,后面每10秒跑一次
        t.schedule(new MyTask(), 3000,86400000);

    }
}

class MyTask extends TimerTask {
    private static final int SUCCESS = 0;
    private static final String SUCCESS_MESSAGE = "successful";
    private static final String ERROR_MESSAGE = "fail";


    public static boolean executer(String command){
        try{
            Process process=Runtime.getRuntime().exec(command);
            readProcessOutput(process);
            // 等待程序执行结束并输出状态
            int exitCode = process.waitFor();
            if (exitCode == SUCCESS) {
                System.out.println(SUCCESS_MESSAGE);
                return true;
            } else {
                System.err.println(ERROR_MESSAGE + exitCode);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private static void readProcessOutput(final Process process) {
        // 将进程的正常输出在 System.out 中打印，进程的错误输出在 System.err 中打印
        read(process.getInputStream(), System.out);
        read(process.getErrorStream(), System.err);
    }

    private static void  read(InputStream inputStream, PrintStream out) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        System.out.println("开始执行");
        executer("sh /opt/dockerfile/hexo-yuque/yuque.sh");
        System.out.println("执行完毕");
    }
}