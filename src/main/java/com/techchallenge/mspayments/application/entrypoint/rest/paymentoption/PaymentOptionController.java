package com.techchallenge.mspayments.application.entrypoint.rest.paymentoption;

import com.techchallenge.mspayments.application.entrypoint.rest.paymentoption.dto.PaymentOptionDTO;
import com.techchallenge.mspayments.application.mapper.PaymentOptionMappers;
import com.techchallenge.mspayments.application.mapper.PaymentOptionTypeMappers;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.IExecuteFindPaymentOptionByExternalDriverIdUseCase;
import com.techchallenge.mspayments.domain.usecase.IExecuteSavePaymentOptionUseCase;
import com.techchallenge.mspayments.domain.usecase.IExecuteFindPaymentOptionsUseCase;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteFindPaymentOptionTypeByIdUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment-options")
@Tag(name = "Payment Options", description = "API de Opções de Pagamento")
public class PaymentOptionController {

    private final IExecuteSavePaymentOptionUseCase executeCreatePaymentOptionUseCase;
    private final IExecuteFindPaymentOptionsUseCase executeFindPaymentOptionsUseCase;
    private final IExecuteFindPaymentOptionTypeByIdUseCase executeFindPaymentOptionTypeByIdUseCase;
    private final IExecuteFindPaymentOptionByExternalDriverIdUseCase iExecuteFindPaymentOptionByExternalDriverIdUseCase;

    public PaymentOptionController(IExecuteSavePaymentOptionUseCase executeCreatePaymentOptionUseCase, IExecuteFindPaymentOptionsUseCase executeFindPaymentOptionsUseCase, IExecuteFindPaymentOptionTypeByIdUseCase executeFindPaymentOptionTypeByIdUseCase, IExecuteFindPaymentOptionByExternalDriverIdUseCase iExecuteFindPaymentOptionByExternalDriverIdUseCase) {
        this.executeCreatePaymentOptionUseCase = executeCreatePaymentOptionUseCase;
        this.executeFindPaymentOptionsUseCase = executeFindPaymentOptionsUseCase;
        this.executeFindPaymentOptionTypeByIdUseCase = executeFindPaymentOptionTypeByIdUseCase;
        this.iExecuteFindPaymentOptionByExternalDriverIdUseCase = iExecuteFindPaymentOptionByExternalDriverIdUseCase;
    }

    @Operation(
            summary = "Salvar uma nova opção de pagamento",
            description = "Salva uma nova opção de pagamento com os dados fornecidos em PaymentOptionDTO. O campo 'paymentOptionTypeId' deve ser preenchido com uma das opções disponíveis: 1 (CREDIT_CARD), 2 (DEBIT_CARD) ou 3 (PIX)."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação bem-sucedida, nova opção de pagamento criada e retornada.")
    })
    @PostMapping
    public ResponseEntity<CustomData<PaymentOptionDomainEntityOutput>> savePaymentOption(@Valid @RequestBody PaymentOptionDTO paymentOptionDTO) {
        final var paymentOptionDoamainEntityInput = PaymentOptionMappers.mapToPaymentOptionDomainEntityInput(paymentOptionDTO);
        final var paymentOptionType = executeFindPaymentOptionTypeByIdUseCase.execute(paymentOptionDTO.getPaymentOptionTypeId());
        final var paymentOptionTypeEntity = PaymentOptionTypeMappers.mapToPaymentOptionEntity(paymentOptionType.getData());

        paymentOptionDoamainEntityInput.setPaymentOptionType(paymentOptionTypeEntity);

        final var paymentOption = executeCreatePaymentOptionUseCase.execute(paymentOptionDoamainEntityInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentOption);
    }

    @Operation(summary = "Buscar todas as opções de pagamento", description = "Retorna todas as opções de pagamento disponíveis."
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200", description = "Operação bem-sucedida, lista de opções de pagamento retornada.")
    })
    @GetMapping
    public ResponseEntity<CustomData<List<PaymentOptionDomainEntityOutput>>> findPaymentOptions() {
        final var paymentOptions = executeFindPaymentOptionsUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(paymentOptions);
    }

    @Operation(summary = "Buscar opção de pagamento por ID externo", description = "Retorna uma opção de pagamento específica por condutor com base em seu ID externo."
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200", description = "Operação bem-sucedida, opção de pagamento encontrada e retornada.")
    })
    @GetMapping("/{externalDriverId}")
    public ResponseEntity<CustomData<PaymentOptionDomainEntityOutput>> findPaymentOptionByExternalDriverId(@PathVariable UUID externalDriverId) {
        final var paymentOption = iExecuteFindPaymentOptionByExternalDriverIdUseCase.execute(externalDriverId);
        return ResponseEntity.status(HttpStatus.OK).body(paymentOption);
    }
}
