package com.zhangyi.getIp;

import java.io.*;
import java.util.regex.Pattern;

public class curl {
    public static void getIp(String name) throws IOException {
        String[] cmds = {"curl", "-i", "-w", "状态:%{http_code}；DNS时间:%{time_namelookup}；"
                + "等待时间:%{time_pretransfer}TCP 连接:%{time_connect}；发出请求:%{time_starttransfer}；"
                + "总时间:%{time_total}", "https://ip.cn/index.php?ip="+name};

        ProcessBuilder pb = new ProcessBuilder(cmds);
        pb.redirectErrorStream(true);
        Process p;

        p = pb.start();
        BufferedReader br = null;
        String line = null;
        boolean flag = false;
        br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = br.readLine()) != null) {
            if ("HTTP/2 200".equals(line.trim())) {
                flag = true;
            }
            if (flag && Pattern.matches("当前.*", line)) {
                String ip = line.split(" ")[2];
                writefile("/opt/dev/java/Course/ip", ip);
            }
        }
        br.close();



    }
    private static void writefile(String path, String context) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(context);
        oos.close();
        fos.close();
    }
    public static String readfile(String path) throws ClassNotFoundException, IOException {
        File file = new File(path);
        FileInputStream fis= new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        return (String) ois.readObject();
    }
}