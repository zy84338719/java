package com.zhangyi.bank;

import java.io.*;
import java.util.List;

/**
 * @author zhangyi
 * 文件操作类
 */

public class FileOperate {



    public static void setFile(List<BankPerson> bankPersonList){
        File file = new File("." + File.separator + "demo" + File.separator + "data.dat");
        try {
            if ((!file.exists())) {
                file.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file) ;
            ObjectOutputStream oos = new ObjectOutputStream(fos) ;
            for (BankPerson bp:bankPersonList) {
                oos.writeObject(bankPersonList);
            }

            System.out.println("数据已存入");
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<BankPerson> getFile(){
        File file = new File("." + File.separator + "demo" + File.separator + "data.dat");
        try {
            FileInputStream fis= new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (List<BankPerson>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setText(){
        File file = new File("." + File.separator + "demo" + File.separator + "test.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        List<BankPerson> bankPersonList =  getFile();
        try {
            Writer out = new FileWriter(file);
            for(BankPerson bankPerson:bankPersonList){
                if(bankPerson.getFlag()){
                    out.write(bankPerson.toString());
                    out.write("\n");
                }
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
