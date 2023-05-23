package com.amigoscode.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public record FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {

    public boolean isFraudulentCustomer(final Integer customerId) {
        // TODO: This should check detect frauds using an external service to check the email or something else...
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .isFraudster(false)
                        .customerId(customerId)
                        .createdAt(LocalDateTime.now(ZoneId.of("UTC")))
                        .build()
        );
        return false;
    }

}
