package com.company.entity;

public class Client {

    private String clientID;
    private String secondName;
    private String accountID;
    private double sum;

    public String getClientID() {
        return clientID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
