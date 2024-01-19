package org.sid.customerservice;

import org.sid.customerservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.sid.customerservice.entities.Customer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder().name("Mohamed").email("med@gmail.com").build());
			customerRepository.save(Customer.builder().name("Yassine").email("yassine@gmail.com").build());
			customerRepository.save(Customer.builder().name("imane").email("imane@gmail.com").build());

		};
	}
}
