package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    List <Customer> customerList;
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

        //portion from main() so we can create some customers
        List<Integer> ids = new ArrayList<>(); //tracks customer ids, prevents duplicate ids
        customerList = new ArrayList<>();

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
    }

    @Test
    public void shouldReturn124000 () {
        assertEquals(124000, customerList.get(0).getBalance());
    }

    @Test
    public void shouldReturn53500 () {
        assertEquals(53500, customerList.get(1).getBalance());
    }

    @Test
    public void shouldReturnMinus15000 () {
        assertEquals(-15000, customerList.get(2).getBalance());
    }

    @Test
    public void shouldReturnCustomerDetails () {
        String expectedString = "Customer ID: 1\nCustomer name: Wayne Enterprises\nCustomer balance: 124000";

        assertEquals(expectedString,"Customer ID: " + String.valueOf(customer.getId()) + "\n"
                + "Customer name: " + customer.getName() + "\n"
                + "Customer balance: " + String.valueOf(customer.getBalance()));
    }

}
