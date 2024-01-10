package com.techchallenge.mspayments.domain.service;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;

import java.util.List;
import java.util.UUID;

public interface IPaymentOptiosDomainService {

    PaymentOptionDomainEntityOutput savePaymentOption(PaymentOptionDomainEntityInput input);

    List<PaymentOptionDomainEntityOutput> findPaymentOptions();

    PaymentOptionDomainEntityOutput findPaymentOptionExternalDriverId(UUID id);

}
