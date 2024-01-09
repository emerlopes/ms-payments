package com.techchallenge.mspayments.application.entrypoint.rest.paymentoptiontype;

import com.techchallenge.mspayments.application.entrypoint.rest.paymentoptiontype.dto.PaymentOptionTypeDTO;
import com.techchallenge.mspayments.application.mapper.PaymentOptionTypeMappers;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteFindAllPaymentOptionsTypeUseCase;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteSavePaymentOptionTypeUseCase;
import com.techchallenge.mspayments.repositories.paymentsdatabase.dto.PaymentOptionTypeEnum;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment-options-type")
public class PaymentOptionTypeController {

    private final IExecuteSavePaymentOptionTypeUseCase executeSavePaymentOptionTypeUseCase;

    private final IExecuteFindAllPaymentOptionsTypeUseCase executeFindAllPaymentOptionsTypeUseCase;

    public PaymentOptionTypeController(
            IExecuteSavePaymentOptionTypeUseCase executeSavePaymentOptionTypeUseCase,
            IExecuteFindAllPaymentOptionsTypeUseCase executeFindPaymentOptionsTypeUseCase) {
        this.executeSavePaymentOptionTypeUseCase = executeSavePaymentOptionTypeUseCase;
        this.executeFindAllPaymentOptionsTypeUseCase = executeFindPaymentOptionsTypeUseCase;
    }

    @RequestMapping
    public ResponseEntity<?> savePaymentOptionType(@Valid @RequestBody PaymentOptionTypeDTO paymentOptionTypeDTO) {
        final var paymentOptionDomainEntityInput = PaymentOptionTypeMappers.mapToPaymentOptionTypeDomainEntityInput(paymentOptionTypeDTO);

        final var paymentOptionType = executeSavePaymentOptionTypeUseCase.execute(paymentOptionDomainEntityInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentOptionType);
    }

    @GetMapping
    public ResponseEntity<?> findAllPaymentOptions() {
        final var paymentOptions = executeFindAllPaymentOptionsTypeUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(paymentOptions);
    }
}
