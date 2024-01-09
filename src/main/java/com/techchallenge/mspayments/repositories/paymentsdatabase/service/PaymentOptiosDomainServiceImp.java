package com.techchallenge.mspayments.repositories.paymentsdatabase.service;

import com.techchallenge.mspayments.application.mapper.PaymentOptionMappers;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.service.IPaymentOptiosDomainService;
import com.techchallenge.mspayments.repositories.paymentsdatabase.repository.IPaymentOptionEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentOptiosDomainServiceImp implements IPaymentOptiosDomainService {

    private final IPaymentOptionEntityRepository paymentOptionEntityRepository;

    public PaymentOptiosDomainServiceImp(IPaymentOptionEntityRepository paymentOptionEntityRepository) {
        this.paymentOptionEntityRepository = paymentOptionEntityRepository;
    }

    @Override
    public PaymentOptionDomainEntityOutput createPaymentOption(PaymentOptionDomainEntityInput input) {
        final var entity = PaymentOptionMappers.mapToPaymentEntity(input);
        final var entitySaved = paymentOptionEntityRepository.save(entity);

        return PaymentOptionMappers.mapToPaymentOptionDomainEntityOutput(entitySaved);
    }

    @Override
    public List<PaymentOptionDomainEntityOutput> findPaymentOptions() {
        final var entities = paymentOptionEntityRepository.findAll();
        return PaymentOptionMappers.mapToPaymentOptionsDomainEntitiesOutput(entities);
    }
}
