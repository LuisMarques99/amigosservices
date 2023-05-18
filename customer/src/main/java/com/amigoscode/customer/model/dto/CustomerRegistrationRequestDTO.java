package com.amigoscode.customer.model.dto;

public record CustomerRegistrationRequestDTO(
        String firstName,
        String lastName,
        String email) {
}
