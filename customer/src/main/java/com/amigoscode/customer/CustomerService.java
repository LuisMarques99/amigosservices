package com.amigoscode.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(final CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // TODO: Check if email is valid
        // TODO: Check if email is not taken
        // TODO: Check if customer is a fraudster
        customerRepository.save(customer);
        // TODO: Send notification
    }
}
