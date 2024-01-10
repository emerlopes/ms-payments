package com.techchallenge.mspayments.domain.usecase.impl;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.service.IPaymentOptiosDomainService;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.IExecuteSavePaymentOptionUseCase;
import org.springframework.stereotype.Service;

@Service
public class ExecuteSavePaymentOptionUseCaseImpl implements IExecuteSavePaymentOptionUseCase {

    private final IPaymentOptiosDomainService paymentOptiosDomainService;

    public ExecuteSavePaymentOptionUseCaseImpl(IPaymentOptiosDomainService paymentOptiosDomainService) {
        this.paymentOptiosDomainService = paymentOptiosDomainService;
    }

    @Override
    public CustomData<PaymentOptionDomainEntityOutput> execute(PaymentOptionDomainEntityInput input) {
        final var paymentOption = paymentOptiosDomainService.savePaymentOption(input);
        CustomData<PaymentOptionDomainEntityOutput> customData = new CustomData<>();
        customData.setData(paymentOption);
        return customData;
    }
}
