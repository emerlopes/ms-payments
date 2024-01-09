package com.techchallenge.mspayments.domain.service;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityOutput;

import java.util.List;

public interface IPaymentOptionTypeDomainService {

    PaymentOptionTypeDomainEntityOutput savePaymentOptionType(PaymentOptionTypeDomainEntityInput input);

    PaymentOptionTypeDomainEntityOutput findPaymentOptionTypeById(PaymentOptionTypeDomainEntityInput input);

    List<PaymentOptionTypeDomainEntityOutput> findAllPaymentOptions();


}
