package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );


    public static void main(String[] args) {
        //Update this
        List<Integer> ids = new ArrayList<>(); //tracks customer ids, prevents duplicate ids
        List <Customer> customerList = new ArrayList<>();

        for (String [] customer : customerData) {
            Customer tempCustomer = new Customer(customer);

            /* if id not in id list: add id to id list, add account record to customer,
            add customer to customer list */
            if (!ids.contains(tempCustomer.getId())) {
                ids.add(tempCustomer.getId());
                tempCustomer.appendRecord(customer);
                customerList.add(tempCustomer);
            }
            //if id in id list: append record to respective customer
            else {
                customerList.get(tempCustomer.getId() - 1).appendRecord(customer);
            }
        }

        List<Customer> uniquePositiveData = customerList.stream()
                .filter(customer -> customer.getBalance() > 0)
                .collect(Collectors.toList());
        List<Customer> uniqueNegativeData = customerList.stream()
                .filter(customer -> customer.getBalance() < 0)
                .collect(Collectors.toList());

        for (Customer c : uniquePositiveData) {
            System.out.println("Positive accounts:\n" + c.toString() + "\n");
        }

        System.out.println("-------------------------------");

        for (Customer c : uniqueNegativeData) {
                System.out.println("Negative accounts:\n" + c.toString() + "\n");
        }
    }
}
