package com.franco.demo.drools;

/**
 * Created by malaka on 16/6/27.
 */
public class Account {
    private Integer balance;

    private Integer balanceLimite;
    public Integer getBalance() {
        return balance;
    }
    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    public Account(Integer balance, Integer balanceLimite) {
        super();
        this.balance = balance;
        this.balanceLimite = balanceLimite;
    }
    public void withdraw(int money) {
        balance -= money;
    }

    public void setBalanceLimite(Integer balanceLimite) {
        this.balanceLimite = balanceLimite;
    }

    public Integer getBalanceLimite() {
        return this.balanceLimite;
    }

}
