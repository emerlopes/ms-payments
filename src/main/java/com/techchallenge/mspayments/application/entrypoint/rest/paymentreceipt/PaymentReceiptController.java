package com.techchallenge.mspayments.application.entrypoint.rest.paymentreceipt;

import com.techchallenge.mspayments.application.entrypoint.rest.paymentreceipt.dto.PaymentReceiptDTO;
import com.techchallenge.mspayments.application.mapper.ParkingPaymentReceiptMappers;
import com.techchallenge.mspayments.domain.usecase.parkingpaymenteeceipt.ExecuteIssuanceReceiptPaymentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment-receipts")
public class PaymentReceiptController {

    private final ExecuteIssuanceReceiptPaymentUseCase executeIssuanceReceiptPaymentUseCase;

    public PaymentReceiptController(ExecuteIssuanceReceiptPaymentUseCase executeIssuanceReceiptPaymentUseCase) {
        this.executeIssuanceReceiptPaymentUseCase = executeIssuanceReceiptPaymentUseCase;
    }

    @PostMapping
    public ResponseEntity<?> savePaymentReceipt(@RequestBody PaymentReceiptDTO paymentReceiptDTO) {
        final var input = ParkingPaymentReceiptMappers.mapToParkingPaymentReceiptDomainEntityInput(paymentReceiptDTO);
        final var result = executeIssuanceReceiptPaymentUseCase.execute(input);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
