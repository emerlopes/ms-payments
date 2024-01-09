package com.techchallenge.mspayments.repositories.paymentsdatabase.service;

import com.techchallenge.mspayments.application.mapper.PaymentOptionTypeMappers;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityOutput;
import com.techchallenge.mspayments.domain.service.IPaymentOptionTypeDomainService;
import com.techchallenge.mspayments.repositories.paymentsdatabase.repository.IPaymentOptionTypeEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentOptionTypeDomainServiceImpl implements IPaymentOptionTypeDomainService {

    private final IPaymentOptionTypeEntityRepository paymentOptionTypeEntityRepository;

    public PaymentOptionTypeDomainServiceImpl(IPaymentOptionTypeEntityRepository paymentOptionTypeEntityRepository) {
        this.paymentOptionTypeEntityRepository = paymentOptionTypeEntityRepository;
    }

    @Override
    public PaymentOptionTypeDomainEntityOutput savePaymentOptionType(PaymentOptionTypeDomainEntityInput input) {
        final var entity = PaymentOptionTypeMappers.mapToPaymentOptionEntity(input);
        final var entitySaved = paymentOptionTypeEntityRepository.save(entity);

        return PaymentOptionTypeMappers.mapToPaymentOptionTypeDomainEntityOutput(entitySaved);
    }

    @Override
    public PaymentOptionTypeDomainEntityOutput findPaymentOptionTypeById(Long input) {
        final var entity = paymentOptionTypeEntityRepository.findById(input);
        return PaymentOptionTypeMappers.mapToPaymentOptionTypeDomainEntityOutput(entity.get());
    }

    @Override
    public List<PaymentOptionTypeDomainEntityOutput> findAllPaymentOptions() {
        final var paymentOptions = paymentOptionTypeEntityRepository.findAll();
        return PaymentOptionTypeMappers.mapToPaymentOptionsTypesDomainEntitiesOutput(paymentOptions);
    }

}
