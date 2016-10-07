package com.franco.demo.drools;

/**
 * Created by wengxiaojun on 16/10/7.
 */
public class Account2 {
    private Integer balance;


    public Account2() {}
    public Integer getBalance() {
        return balance;
    }
    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    public Account2(Integer balance) {
        super();
        this.balance = balance;
    }
    public void withdraw(int money) {
        balance -= money;
    }
}
