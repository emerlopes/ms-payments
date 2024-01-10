package com.techchallenge.mspayments.application.entrypoint.rest.paymentoption;

import com.techchallenge.mspayments.application.entrypoint.rest.paymentoption.dto.PaymentOptionDTO;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityOutput;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.IExecuteSavePaymentOptionUseCase;
import com.techchallenge.mspayments.domain.usecase.IExecuteFindPaymentOptionsUseCase;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteFindPaymentOptionTypeByIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class PaymentOptionControllerTest {

    @InjectMocks
    private PaymentOptionController paymentOptionController;

    @Mock
    private IExecuteSavePaymentOptionUseCase createPaymentOptionUseCase;

    @Mock
    private IExecuteFindPaymentOptionsUseCase findPaymentOptionsUseCase;

    @Mock
    private IExecuteFindPaymentOptionTypeByIdUseCase findPaymentOptionTypeByIdUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    public void testSavePaymentOption() {
        PaymentOptionDTO paymentOptionDTO = new PaymentOptionDTO();
        // Set up necessary mocks for createPaymentOptionUseCase and findPaymentOptionTypeByIdUseCase

        when(createPaymentOptionUseCase.execute(any())).thenReturn(new CustomData<PaymentOptionDomainEntityOutput>());
        when(findPaymentOptionTypeByIdUseCase.execute(any())).thenReturn(new CustomData<PaymentOptionTypeDomainEntityOutput>());

        ResponseEntity<?> responseEntity = paymentOptionController.savePaymentOption(paymentOptionDTO);

        verify(createPaymentOptionUseCase).execute(any());
        verify(findPaymentOptionTypeByIdUseCase).execute(any());
        // Add assertions for the responseEntity and other validations as needed
    }

    @Test
    public void testFindPaymentOptions() {
        // Set up necessary mocks for findPaymentOptionsUseCase

        when(findPaymentOptionsUseCase.execute()).thenReturn(new CustomData<List<PaymentOptionDomainEntityOutput>>());

        ResponseEntity<?> responseEntity = paymentOptionController.findPaymentOptions();

        verify(findPaymentOptionsUseCase).execute();
        // Add assertions for the responseEntity and other validations as needed
    }
}
