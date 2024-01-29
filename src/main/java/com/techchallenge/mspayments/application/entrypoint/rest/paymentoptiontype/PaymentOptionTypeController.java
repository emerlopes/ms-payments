package com.techchallenge.mspayments.application.entrypoint.rest.paymentoptiontype;

import com.techchallenge.mspayments.application.entrypoint.rest.paymentoptiontype.dto.PaymentOptionTypeDTO;
import com.techchallenge.mspayments.application.mapper.PaymentOptionTypeMappers;
import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityOutput;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteFindAllPaymentOptionsTypeUseCase;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteFindPaymentOptionTypeByIdUseCase;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteSavePaymentOptionTypeUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-options-type")
@Tag(name = "Payment Option Types", description = "API de Tipos de Opções de Pagamento")
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

    @Operation(
            summary = "Salvar um novo tipo de opção de pagamento",
            description = "Salva um novo tipo de opção de pagamento com os dados fornecidos em PaymentOptionTypeDTO."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação bem-sucedida, novo tipo de opção de pagamento criado e retornado.")
    })
    @PostMapping
    public ResponseEntity<CustomData<PaymentOptionTypeDomainEntityOutput>> savePaymentOptionType(@Valid @RequestBody PaymentOptionTypeDTO paymentOptionTypeDTO) {
        final var paymentOptionDomainEntityInput = PaymentOptionTypeMappers.mapToPaymentOptionTypeDomainEntityInput(paymentOptionTypeDTO);

        final var paymentOptionType = executeSavePaymentOptionTypeUseCase.execute(paymentOptionDomainEntityInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentOptionType);
    }

    @Operation(
            summary = "Buscar todos os tipos de opções de pagamento",
            description = "Retorna todos os tipos de opções de pagamento disponíveis."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida, lista de tipos de opções de pagamento retornada.")
    })
    @GetMapping
    public ResponseEntity<
            CustomData<List<PaymentOptionTypeDomainEntityOutput>>> findAllPaymentOptionTypes() {
        final var paymentOptions = executeFindAllPaymentOptionsTypeUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(paymentOptions);
    }

    @Operation(
            summary = "Buscar tipo de opção de pagamento por ID",
            description = "Retorna um tipo de opção de pagamento específico com base em seu ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida, tipo de opção de pagamento encontrado e retornado.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CustomData<PaymentOptionTypeDomainEntityOutput>> findPaymentOptionTypes(@PathVariable Long id) {
        final var paymentOption = executeFindPaymentOptionTypeByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(paymentOption);
    }
}
