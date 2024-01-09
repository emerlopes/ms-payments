package com.techchallenge.mspayments.application.entrypoint.rest;

import com.techchallenge.mspayments.application.entrypoint.rest.dto.PaymentOptionDTO;
import com.techchallenge.mspayments.domain.usecase.IExecuteCreatePaymentOptionUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment-options")
public class PaymentOptionController {

    private final IExecuteCreatePaymentOptionUseCase executeCreatePaymentOptionUseCase;

    public PaymentOptionController(IExecuteCreatePaymentOptionUseCase executeCreatePaymentOptionUseCase) {
        this.executeCreatePaymentOptionUseCase = executeCreatePaymentOptionUseCase;
    }

    public ResponseEntity<?> savePaymentOption(@Valid @RequestBody PaymentOptionDTO paymentOptionDTO) {
        final var paymentOption = executeCreatePaymentOptionUseCase.execute(null);
        return null;
    }
}
