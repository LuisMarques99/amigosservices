package com.amigoscode.customer.service;

import com.amigoscode.customer.model.dto.CustomerRegistrationRequestDTO;

public interface CustomerService {

    void registerCustomer(CustomerRegistrationRequestDTO customerRegistrationRequest);

}
