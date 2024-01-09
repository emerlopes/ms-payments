package com.techchallenge.mspayments.domain.usecase;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.shared.IExecuteNoArgs;

import java.util.List;

public interface IExecuteFindPaymentOptionsUseCase extends IExecuteNoArgs<CustomData<List<PaymentOptionDomainEntityOutput>>> {
}
