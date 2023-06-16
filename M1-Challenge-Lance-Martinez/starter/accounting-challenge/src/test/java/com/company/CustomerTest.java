package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    Customer customer, customer1;

    @BeforeEach
    public void SetUp () {
        List<String[]> customerData = Arrays.asList(
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
        customer = new Customer(1, "Wayne Enterprises");
        customer.composeRecords(customerData);

        customer1 = new Customer(2, "DailyPlanet");
        customer1.composeRecords(customerData);
    }

    @Test
    public void shouldReturn124000 () {

        assertEquals(124000, customer.getBalance());
    }

    @Test
    public void shouldReturn53500 () {
        assertEquals(53500, customer1.getBalance());
    }

    @Test
    public void shouldReturnCustomerDetails () {
        String expectedString = "Customer ID: 1\nCustomer name: Wayne Enterprises\nCustomer balance: 124000";

        assertEquals(expectedString,"Customer ID: " + String.valueOf(customer.getId()) + "\n"
                + "Customer name: " + customer.getName() + "\n"
                + "Customer balance: " + String.valueOf(customer.getBalance()));
    }

}
