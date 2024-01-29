package com.techchallenge.mspayments.application.entrypoint.rest.paymentreceipt;

import com.techchallenge.mspayments.application.entrypoint.rest.paymentreceipt.dto.PaymentReceiptDTO;
import com.techchallenge.mspayments.application.mapper.ParkingPaymentReceiptMappers;
import com.techchallenge.mspayments.domain.entity.ParkingPaymentReceiptDomainEntityOutput;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.parkingpaymenteeceipt.ExecuteIssuanceReceiptPaymentUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment-receipts")
@Tag(name = "Payment Receipts", description = "API de Comprovantes de Pagamento")
public class PaymentReceiptController {

    private final ExecuteIssuanceReceiptPaymentUseCase executeIssuanceReceiptPaymentUseCase;

    public PaymentReceiptController(ExecuteIssuanceReceiptPaymentUseCase executeIssuanceReceiptPaymentUseCase) {
        this.executeIssuanceReceiptPaymentUseCase = executeIssuanceReceiptPaymentUseCase;
    }

    @Operation(
            summary = "Salvar um novo comprovante de pagamento",
            description = "Salva um novo comprovante de pagamento com os dados fornecidos em PaymentReceiptDTO."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação bem-sucedida, novo comprovante de pagamento criado e retornado.")
    })
    @PostMapping
    public ResponseEntity<CustomData<ParkingPaymentReceiptDomainEntityOutput>> savePaymentReceipt(@RequestBody PaymentReceiptDTO paymentReceiptDTO) {
        final var input = ParkingPaymentReceiptMappers.mapToParkingPaymentReceiptDomainEntityInput(paymentReceiptDTO);
        final var result = executeIssuanceReceiptPaymentUseCase.execute(input);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
