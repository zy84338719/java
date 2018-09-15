package com.zhangyi.bank;

import java.io.Serializable;

/**
 * 银行个人信息类
 * @author zhangyi
 */

public class BankPerson implements Serializable {
    @Override
    public String toString() {
        return String.format("%-15s %-15s %-10.2f %-10d",firstName,lastName,deposit,id);
    }

    private String firstName;
    private String lastName;
    private Double deposit;
    private Integer id;
    private Boolean flag;

    public BankPerson(String firstName, String lastName, Double deposit, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deposit = deposit;
        this.id = id;
        this.flag = false;
    }

    public void setAdd(BankPerson bankPerson) {
        this.firstName = bankPerson.firstName;
        this.lastName = bankPerson.lastName;
        this.deposit = bankPerson.deposit;
        this.flag = true;
    }

    public BankPerson(){

    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
