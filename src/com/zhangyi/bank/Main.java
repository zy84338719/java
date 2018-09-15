package com.zhangyi.bank;



import java.util.List;
import java.util.Scanner;

import static com.zhangyi.bank.Operate.*;

public class Main {

    public static void main(String[] args) throws Exception{
//	 write your code here
//        CreateData.create();
        while (true){
           Integer op = Switch();
           switch (op){
               case 1:
                   List<BankPerson> bankPersonList = getAll();
                   for(BankPerson bankPerson:bankPersonList){
                       if(bankPerson.getFlag()){
                           System.out.println(bankPerson.toString());
                       }
                   }
                   break;
               case 2:
                   System.out.println("请输入你所要查看的id：");
                   Scanner seeId = new Scanner(System.in);
                   System.out.println(getInfo(Integer.parseInt(seeId.nextLine())));
                   break;
               case 3:
                   System.out.println("请输入你所要删除的id：");
                   Scanner delId = new Scanner(System.in);
                   System.out.println(delInfo(Integer.parseInt(delId.nextLine())));
                   break;
               case 4:
                   System.out.println("请输入你所要存取款的id：");
                   Scanner updateId = new Scanner(System.in);
                   System.out.println(update(Integer.parseInt(updateId.nextLine()),Double.parseDouble(updateId.nextLine())));
                   break;
               case 5:
                   System.out.println("姓 名 存款");
                   Scanner add = new Scanner(System.in);
                   BankPerson bankPerson = new BankPerson();
                   bankPerson.setFirstName(add.nextLine());
                   bankPerson.setLastName(add.nextLine());
                   bankPerson.setDeposit(add.nextDouble());
                   System.out.println(addInfo(bankPerson));
                   break;
               case 6:
                   System.out.println(createText());
                   break;
               case 7:
                   System.out.println(save());
                   break;
               case 8:
                   return;
               default:
           }
        }


    }

    public static Integer Switch(){
        System.out.println("欢迎使用信息存款查看");
        System.out.println("1.查看全部存款信息");
        System.out.println("2.查看指定id存款信息");
        System.out.println("3.删除指定id存款信息");
        System.out.println("4.指定id存取款");
        System.out.println("5.添加存款人记录");
        System.out.println("6.保存为txt输出");
        System.out.println("7.保存修改结果");
        System.out.println("8.退出");

        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
