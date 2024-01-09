package com.techchallenge.mspayments.domain.service;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;

import java.util.List;

public interface IPaymentOptiosDomainService {

    PaymentOptionDomainEntityOutput createPaymentOption(PaymentOptionDomainEntityInput input);

    List<PaymentOptionDomainEntityOutput> findPaymentOptions();

}
