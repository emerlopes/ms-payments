package com.techchallenge.mspayments.application.entrypoint.rest;

import com.techchallenge.mspayments.application.entrypoint.rest.dto.PaymentOptionDTO;
import com.techchallenge.mspayments.application.mapper.PaymentOptionMappers;
import com.techchallenge.mspayments.domain.usecase.IExecuteCreatePaymentOptionUseCase;
import com.techchallenge.mspayments.domain.usecase.IExecuteFindPaymentOptionsUseCase;
import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionTypeEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment-options")
public class PaymentOptionController {

    private final IExecuteCreatePaymentOptionUseCase executeCreatePaymentOptionUseCase;
    private final IExecuteFindPaymentOptionsUseCase executeFindPaymentOptionsUseCase;

    public PaymentOptionController(IExecuteCreatePaymentOptionUseCase executeCreatePaymentOptionUseCase, IExecuteFindPaymentOptionsUseCase executeFindPaymentOptionsUseCase) {
        this.executeCreatePaymentOptionUseCase = executeCreatePaymentOptionUseCase;
        this.executeFindPaymentOptionsUseCase = executeFindPaymentOptionsUseCase;
    }

    @RequestMapping
    public ResponseEntity<?> savePaymentOption(@Valid @RequestBody PaymentOptionDTO paymentOptionDTO) {
        final var paymentOptionDoamainEntityInput = PaymentOptionMappers.mapToPaymentOptionDomainEntityInput(paymentOptionDTO);
        paymentOptionDoamainEntityInput.setPaymentOptionType(new PaymentOptionTypeEntity());

        final var paymentOption = executeCreatePaymentOptionUseCase.execute(paymentOptionDoamainEntityInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentOption);
    }

    @GetMapping
    public ResponseEntity<?> findPaymentOptions() {
        final var paymentOptions = executeFindPaymentOptionsUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(paymentOptions);
    }
}
