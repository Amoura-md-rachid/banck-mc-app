package com.amoura.accountservice.clients;

import com.amoura.accountservice.model.Customer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerByID(@PathVariable Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getAllCustomers")
    List<Customer> allCustomer();

    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("not vailable");
        customer.setLastName("not vailable");
        customer.setEmail( "not vailable");

        return customer;
    }

    default List<Customer> getAllCustomers(){
        return List.of();
    }

}
