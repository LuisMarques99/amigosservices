package com.amigoscode.customer.service;

import com.amigoscode.customer.model.Customer;
import com.amigoscode.customer.model.dto.CustomerRegistrationRequestDTO;
import org.springframework.stereotype.Service;

@Service
public record DefaultCustomerService() implements CustomerService {
    @Override
    public void registerCustomer(CustomerRegistrationRequestDTO request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // TODO: Check if email is valid
        // TODO: Check if email is not taken
        // TODO: Store customer in DB
    }
}
