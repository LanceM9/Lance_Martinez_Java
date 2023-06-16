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

        //creating Wayne
        Customer wayneEnterprises = new Customer(1, "Wayne Enterprises");
        wayneEnterprises.composeRecords(customerData);

        //creating Daily
        Customer dailyPlanet = new Customer(2, "Daily Planet");
        dailyPlanet.composeRecords(customerData);

        //creating Ace
        Customer aceChemical = new Customer(3, "Ace Chemical");
        aceChemical.composeRecords(customerData);

        List<String []> uniquePositiveData = customerData.stream()
                .filter(customer -> Integer.parseInt(customer[2]) > 0)
                .collect(Collectors.toList());
        List<String []> uniqueNegativeData = customerData.stream()
                .filter(customer -> Integer.parseInt(customer[2]) < 0)
                .collect(Collectors.toList());

        for (String [] c : uniquePositiveData) {
            System.out.println("Positive accounts: " + Arrays.toString(c));
        }

        System.out.println();

        for (String [] c : uniqueNegativeData) {
            System.out.println("Negative accounts: " + Arrays.toString(c));
        }
    }
}
