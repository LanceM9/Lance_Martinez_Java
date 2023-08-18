package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository repo;

    //@MockBean

    @BeforeEach
    public void setUp() {
        repo.deleteAll();
    }

    @Test
    public void shouldAddCustomer () {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setEmail("john@gmail.com");
        customer.setCompany("Smith Inc.");
        customer.setPhone("1123456789");
        customer.setAddress1("Smith Apartments");
        customer.setAddress2("Apt G11");
        customer.setState("Colorado");
        customer.setPostalCode("80225");
        customer.setCountry("United States");

        // Act
        customer = repo.save(customer);

        // Assert
        Optional<Customer> customer1 = repo.findById(customer.getCustomerId());
        assertEquals(customer1.get(), customer);;
    }

    @Test
    public void shouldUpdateExistingCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setEmail("john@gmail.com");
        customer.setCompany("Smith Inc.");
        customer.setPhone("1123456789");
        customer.setAddress1("Smith Apartments");
        customer.setAddress2("Apt G11");
        customer.setState("Colorado");
        customer.setPostalCode("80225");
        customer.setCountry("United States");

        // Act

        customer = repo.save(customer);

        customer.setLastName("John");
        customer.setFirstName("Smith");

        repo.save(customer);

        // Assert
        Optional<Customer> customer1 = repo.findById(customer.getCustomerId());
        assertEquals(customer1.get(), customer);

    }

    @Test
    public void shouldDeleteExistingCustomerById(){
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setEmail("john@gmail.com");
        customer.setCompany("Smith Inc.");
        customer.setPhone("1123456789");
        customer.setAddress1("Smith Apartments");
        customer.setAddress2("Apt G11");
        customer.setState("Colorado");
        customer.setPostalCode("80225");
        customer.setCountry("United States");

        // Act
        customer = repo.save(customer);

        // Assert
        Optional<Customer> customer1 = repo.findById(customer.getCustomerId());
        assertEquals(customer1.get(), customer);

        repo.deleteById(customer.getCustomerId());

        customer1 = repo.findById(customer.getCustomerId());
        assertFalse(customer1.isPresent());
    }

    @Test
    public void shouldGetCustomerById() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setEmail("john@gmail.com");
        customer.setCompany("Smith Inc.");
        customer.setPhone("1123456789");
        customer.setAddress1("Smith Apartments");
        customer.setAddress2("Apt G11");
        customer.setState("Colorado");
        customer.setPostalCode("80225");
        customer.setCountry("United States");

        // Act
        customer = repo.save(customer);

        // Assert
        Optional<Customer> customer1 = repo.findById(customer.getCustomerId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldGetCustomerByState(){
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setEmail("john@gmail.com");
        customer.setCompany("Smith Inc.");
        customer.setPhone("1123456789");
        customer.setAddress1("Smith Apartments");
        customer.setAddress2("Apt G11");
        customer.setState("Colorado");
        customer.setPostalCode("80225");
        customer.setCountry("United States");

        // Act
        customer = repo.save(customer);

        // Assert
        List<Customer> customerList = repo.findCustomerRecordsByState("Colorado");
        assertEquals(customerList.size(), 1);
    }
}
