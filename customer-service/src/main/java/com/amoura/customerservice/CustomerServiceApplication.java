package com.amoura.customerservice;

import com.amoura.customerservice.entities.Customer;
import com.amoura.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
							.firstName("Amoura")
							.lastName("mohand")
							.email("amoura@gmail.com")
							.build()
					, Customer.builder()
							.firstName("Arouki")
							.lastName("mourakami")
							.email("arouki@gmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}

}
