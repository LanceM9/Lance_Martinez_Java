package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @MockBean
    CustomerRepository repo;

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setUp(){
        repo.deleteAll();
    }

    @Test
    public void shouldReturnCreatedStatus() throws Exception{
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

        String inputJson = mapper.writeValueAsString(customer);

        // Act
        customer = repo.save(customer);

        // Assert
        mockMvc.perform(post("/customer")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    public void shouldUpdateAndReturn204Status () throws Exception{
        // Arrange
        Customer customer = new Customer();
        customer.setCustomerId(5);
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
        String inputJson = mapper.writeValueAsString(customer);

        // Assert
        mockMvc.perform(
                        put("/customer")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteByIdAndReturn204Status () throws Exception{
        // Arrange
        Customer customer = new Customer();
        customer.setCustomerId(5);
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
        mockMvc.perform(delete("/customer/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetCustomerById() throws Exception {
        // Arrange
        Customer customer = new Customer();
        customer.setCustomerId(5);
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
        mockMvc.perform(get("/customer/5"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCustomerByState() throws Exception {
        // Arrange
        Customer customer = new Customer();
        customer.setCustomerId(5);
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
        mockMvc.perform(get("/customer/state/Colorado"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
