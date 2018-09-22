package com.zhangyi.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张易
 * 数据创建
 */
public class CreateData {
    public static String create(){
        List<BankPerson> bankPersonList = new ArrayList<>();
        for(int i=1;i<=100;i++){
            bankPersonList.add(new BankPerson("","",0.0,i));
        }
        FileOperate.setFile(bankPersonList);
        return null;
    }
}
