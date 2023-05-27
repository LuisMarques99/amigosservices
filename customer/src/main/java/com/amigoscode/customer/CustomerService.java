package com.amigoscode.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
    public void registerCustomer(final CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // TODO: Check if email is valid
        // TODO: Check if email is not taken
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        assert fraudCheckResponse != null : "Fraud service couldn't be reached.";
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Customer is fraudster.");
        }
        // TODO: Send notification
    }
}
