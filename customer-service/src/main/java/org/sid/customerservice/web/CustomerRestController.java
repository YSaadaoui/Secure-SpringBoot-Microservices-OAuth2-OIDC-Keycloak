package org.sid.customerservice.web;

import lombok.AllArgsConstructor;
import org.sid.customerservice.repo.CustomerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.sid.customerservice.entities.Customer;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CustomerRestController {
    public CustomerRepository customerRepository;

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('USER')")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }

    @GetMapping("/mySession")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}
