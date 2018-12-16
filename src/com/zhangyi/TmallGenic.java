package com.zhangyi;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TmallGenic {

//    public static void main(String[] args) {
//        String cmd = null;
//
//        Runtime run = Runtime.getRuntime();
//        //返回与当前 Java 应用程序相关的运行时对象
//        try {
//            String path = "/opt/env/Tmall.txt";
//            File file = new File(path);
//            if(file.isFile() && file.exists()) {
//                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
//                BufferedReader br = new BufferedReader(isr);
//                String lineTxt = null;
//                if ((lineTxt = br.readLine()) != null) {
//                    cmd = lineTxt;
//                }
//                br.close();
//                Process p = run.exec(cmd);
//                // 启动另一个进程来执行命令
//                if (p.waitFor() != 0) {
//                    if (p.exitValue() == 1) {
//                        //p.exitValue()==0表示正常结束，1：非正常结束
//                        System.err.println("命令执行失败!");
//                    }
//                }
//            } else {
//                System.out.println("配置文件不存在!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
class TimedTask {
    @Test
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 把run方法里的内容换成你要执行的内容
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("当前的系统时间为：" + sdf.format(new Date()));
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        //public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);
        //command--执行的任务,initialDelay--延迟开始,period--间隔时间,unit--时间单位
        service.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.HOURS);
    }
}
