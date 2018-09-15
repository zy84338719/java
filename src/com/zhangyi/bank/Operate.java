package com.zhangyi.bank;


import java.util.List;

import static com.zhangyi.bank.FileOperate.getFile;
import static com.zhangyi.bank.FileOperate.setFile;
import static com.zhangyi.bank.FileOperate.setText;

public class Operate {


    private static final List<BankPerson> bankPersonList;

    static {
        bankPersonList = getFile();
    }
    public static String getInfo(Integer id){
        if(id.equals(null)){
            return "输入为空";
        }

        for (BankPerson person:bankPersonList
             ) {
            if(id.equals(person.getId())){
                if(person.getFlag()){
                    return person.toString();
                }
            }
        }
        return "未找到id为"+id.toString();
    }

    public static String delInfo(Integer id){
        if(id.equals(null)){
            return "输入为空";
        }

        for (BankPerson person:bankPersonList
        ) {
            if(id.equals(person.getId())){
                person.setFlag(false);
                return person.toString()+"\n删除成功";
            }
        }
        return "未找到id为"+id.toString();
    }

    public static String addInfo(BankPerson bankPerson){
        for (BankPerson bp:bankPersonList
             ) {
            if(!bp.getFlag()){
                bp.setAdd(bankPerson);
                return "插入成功\n"+bp.toString();
            }

        }

        return "插入失败，无空位";
    }

    public static String update(Integer id, Double deposit){
        for (BankPerson bp:bankPersonList
        ) {
            if(bp.getId().equals(id)){
                bp.setDeposit(bp.getDeposit()+deposit);
                return "插入成功\n"+bp.toString();
            }

        }
        return "数据库更新成功";
    }

    public static List<BankPerson> getAll(){
        return bankPersonList;
    }

    public static String createText(){
         setText();
         return "创建成功";
    }

    public static String save(){
        setFile(bankPersonList);
        return "数据库更新成功";
    }
}
