package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public Customer(){}

    public Customer (String [] customerInfo) {
        this.id = Integer.parseInt(customerInfo[0]);
        this.name = customerInfo[1];
    }

    public int getBalance() {
        int sum = 0;
        for (AccountRecord rec : charges) {
            sum += rec.getCharge();
        }
        return sum;
    }

    @Override
    public String toString() {
        return ("Customer ID: " + String.valueOf(id) + "\n"
                + "Customer name: " + this.name + "\n"
                + "Customer balance: " + String.valueOf(this.getBalance()));
    }

    public void appendRecord(String [] rec) {
        AccountRecord ac = new AccountRecord();
        ac.setCharge(Integer.parseInt(rec[2]));
        ac.setChargeDate(rec[3]);
        charges.add(ac);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

}

