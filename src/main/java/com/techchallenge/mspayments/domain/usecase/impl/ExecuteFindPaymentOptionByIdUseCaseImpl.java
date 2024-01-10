package com.techchallenge.mspayments.domain.usecase.impl;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.service.IPaymentOptiosDomainService;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.IExecuteFindPaymentOptionByIdUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExecuteFindPaymentOptionByIdUseCaseImpl implements IExecuteFindPaymentOptionByIdUseCase {

    private final IPaymentOptiosDomainService paymentOptiosDomainService;

    public ExecuteFindPaymentOptionByIdUseCaseImpl(IPaymentOptiosDomainService paymentOptiosDomainService) {
        this.paymentOptiosDomainService = paymentOptiosDomainService;
    }

    @Override
    public CustomData<PaymentOptionDomainEntityOutput> execute(UUID domainObject) {
        final var output = paymentOptiosDomainService.findPaymentOptionExternalDriverId(domainObject);
        CustomData<PaymentOptionDomainEntityOutput> customData = new CustomData<>();
        customData.setData(output);
        return customData;
    }
}
