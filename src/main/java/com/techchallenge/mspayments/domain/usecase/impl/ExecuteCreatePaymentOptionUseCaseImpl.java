package com.techchallenge.mspayments.domain.usecase.impl;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.IExecuteCreatePaymentOptionUseCase;
import org.springframework.stereotype.Service;

@Service
public class ExecuteCreatePaymentOptionUseCaseImpl implements IExecuteCreatePaymentOptionUseCase {
    @Override
    public CustomData<PaymentOptionDomainEntityOutput> execute(PaymentOptionDomainEntityInput input) {
        return null;
    }
}
