package com.techchallenge.mspayments.domain.usecase;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.shared.IExecuteArgs;

import java.util.UUID;

public interface IExecuteFindPaymentOptionByIdUseCase extends IExecuteArgs<CustomData<PaymentOptionDomainEntityOutput>, UUID> {
}
