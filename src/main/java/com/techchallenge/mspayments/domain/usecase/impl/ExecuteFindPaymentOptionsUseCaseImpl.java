package com.techchallenge.mspayments.domain.usecase.impl;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.service.IPaymentOptiosDomainService;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.IExecuteFindPaymentOptionsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecuteFindPaymentOptionsUseCaseImpl implements IExecuteFindPaymentOptionsUseCase {

    private final IPaymentOptiosDomainService paymentOptiosDomainService;

    public ExecuteFindPaymentOptionsUseCaseImpl(IPaymentOptiosDomainService paymentOptiosDomainService) {
        this.paymentOptiosDomainService = paymentOptiosDomainService;
    }


    @Override
    public CustomData<List<PaymentOptionDomainEntityOutput>> execute() {
        final var paymentOptions = paymentOptiosDomainService.findPaymentOptions();
        CustomData<List<PaymentOptionDomainEntityOutput>> customData = new CustomData<>();
        customData.setData(paymentOptions);
        return customData;
    }
}
