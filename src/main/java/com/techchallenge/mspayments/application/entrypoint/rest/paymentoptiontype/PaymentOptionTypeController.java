package com.techchallenge.mspayments.application.entrypoint.rest.paymentoptiontype;

import com.techchallenge.mspayments.application.entrypoint.rest.paymentoptiontype.dto.PaymentOptionTypeDTO;
import com.techchallenge.mspayments.application.mapper.PaymentOptionTypeMappers;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteFindAllPaymentOptionsTypeUseCase;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteFindPaymentOptionTypeByIdUseCase;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteSavePaymentOptionTypeUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment-options-type")
public class PaymentOptionTypeController {

    private final IExecuteSavePaymentOptionTypeUseCase executeSavePaymentOptionTypeUseCase;

    private final IExecuteFindAllPaymentOptionsTypeUseCase executeFindAllPaymentOptionsTypeUseCase;

    private final IExecuteFindPaymentOptionTypeByIdUseCase executeFindPaymentOptionTypeByIdUseCase;

    public PaymentOptionTypeController(
            IExecuteSavePaymentOptionTypeUseCase executeSavePaymentOptionTypeUseCase,
            IExecuteFindAllPaymentOptionsTypeUseCase executeFindPaymentOptionsTypeUseCase, IExecuteFindPaymentOptionTypeByIdUseCase executeFindPaymentOptionTypeByIdUseCase) {
        this.executeSavePaymentOptionTypeUseCase = executeSavePaymentOptionTypeUseCase;
        this.executeFindAllPaymentOptionsTypeUseCase = executeFindPaymentOptionsTypeUseCase;
        this.executeFindPaymentOptionTypeByIdUseCase = executeFindPaymentOptionTypeByIdUseCase;
    }

    @RequestMapping
    public ResponseEntity<?> savePaymentOptionType(@Valid @RequestBody PaymentOptionTypeDTO paymentOptionTypeDTO) {
        final var paymentOptionDomainEntityInput = PaymentOptionTypeMappers.mapToPaymentOptionTypeDomainEntityInput(paymentOptionTypeDTO);

        final var paymentOptionType = executeSavePaymentOptionTypeUseCase.execute(paymentOptionDomainEntityInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentOptionType);
    }

    @GetMapping
    public ResponseEntity<?> findAllPaymentOptionTypes() {
        final var paymentOptions = executeFindAllPaymentOptionsTypeUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(paymentOptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findPaymentOptionTypes(@PathVariable Long id) {
        final var paymentOption = executeFindPaymentOptionTypeByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(paymentOption);
    }
}
