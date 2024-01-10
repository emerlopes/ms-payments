package com.techchallenge.mspayments.application.entrypoint.rest.paymentoption;

import com.techchallenge.mspayments.application.entrypoint.rest.paymentoption.dto.PaymentOptionDTO;
import com.techchallenge.mspayments.application.mapper.PaymentOptionMappers;
import com.techchallenge.mspayments.application.mapper.PaymentOptionTypeMappers;
import com.techchallenge.mspayments.domain.usecase.IExecuteFindPaymentOptionByIdUseCase;
import com.techchallenge.mspayments.domain.usecase.IExecuteSavePaymentOptionUseCase;
import com.techchallenge.mspayments.domain.usecase.IExecuteFindPaymentOptionsUseCase;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteFindPaymentOptionTypeByIdUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/payment-options")
public class PaymentOptionController {

    private final IExecuteSavePaymentOptionUseCase executeCreatePaymentOptionUseCase;
    private final IExecuteFindPaymentOptionsUseCase executeFindPaymentOptionsUseCase;
    private final IExecuteFindPaymentOptionTypeByIdUseCase executeFindPaymentOptionTypeByIdUseCase;
    private final IExecuteFindPaymentOptionByIdUseCase executeFindPaymentOptionByIdUseCase;

    public PaymentOptionController(IExecuteSavePaymentOptionUseCase executeCreatePaymentOptionUseCase, IExecuteFindPaymentOptionsUseCase executeFindPaymentOptionsUseCase, IExecuteFindPaymentOptionTypeByIdUseCase executeFindPaymentOptionTypeByIdUseCase, IExecuteFindPaymentOptionByIdUseCase executeFindPaymentOptionByIdUseCase) {
        this.executeCreatePaymentOptionUseCase = executeCreatePaymentOptionUseCase;
        this.executeFindPaymentOptionsUseCase = executeFindPaymentOptionsUseCase;
        this.executeFindPaymentOptionTypeByIdUseCase = executeFindPaymentOptionTypeByIdUseCase;
        this.executeFindPaymentOptionByIdUseCase = executeFindPaymentOptionByIdUseCase;
    }

    @RequestMapping
    public ResponseEntity<?> savePaymentOption(@Valid @RequestBody PaymentOptionDTO paymentOptionDTO) {
        final var paymentOptionDoamainEntityInput = PaymentOptionMappers.mapToPaymentOptionDomainEntityInput(paymentOptionDTO);
        final var paymentOptionType = executeFindPaymentOptionTypeByIdUseCase.execute(paymentOptionDTO.getPaymentOptionTypeId());
        final var paymentOptionTypeEntity = PaymentOptionTypeMappers.mapToPaymentOptionEntity(paymentOptionType.getData());

        paymentOptionDoamainEntityInput.setPaymentOptionType(paymentOptionTypeEntity);

        final var paymentOption = executeCreatePaymentOptionUseCase.execute(paymentOptionDoamainEntityInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentOption);
    }

    @GetMapping
    public ResponseEntity<?> findPaymentOptions() {
        final var paymentOptions = executeFindPaymentOptionsUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(paymentOptions);
    }

    @GetMapping("/{externalDriverId}")
    public ResponseEntity<?> findPaymentOptionByExternalDriverId(@PathVariable UUID externalDriverId) {
        final var paymentOption = executeFindPaymentOptionByIdUseCase.execute(externalDriverId);
        return ResponseEntity.status(HttpStatus.OK).body(paymentOption);
    }
}
