package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public Customer (int aid, String aname) {
        this.id = aid;
        this.name = aname;
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

    public int getBalance() {
        int sum = 0;
        for (AccountRecord rec : charges) {
            sum += rec.getCharge();
            System.out.println(rec.getCharge());
        }
        return sum;
    }

    public void setRecords (List<AccountRecord> rec) {
        this.charges = rec;
    }

    public void appendRecord(AccountRecord rec) {
        charges.add(rec);
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        return ("Customer ID: " + String.valueOf(id) + "\n"
                + "Customer name: " + this.name + "\n"
                + "Customer balance: " + String.valueOf(this.getBalance()));
    }

    public void composeRecords (List<String []> data) {
        for (String [] x : data) {
            if (Integer.parseInt(x[0]) == this.id) {
                AccountRecord accRec = new AccountRecord();
                accRec.setCharge(Integer.parseInt(x[2]));
                accRec.setChargeDate(x[3]);
                this.appendRecord(accRec);
            }
        }

        //not sure why .filter was returning nothing

//        List<String []> uniqueData = data.stream()
//                .filter(customer -> (customer[0] == String.valueOf(this.id)))
//                .collect(Collectors.toList());

//        for (String [] w : uniqueData) {
//            AccountRecord accRec = new AccountRecord();
//            accRec.setCharge(Integer.parseInt(w[2]));
//            accRec.setChargeDate(w[3]);
//            this.appendRecord(accRec);
//        }
    }
}
