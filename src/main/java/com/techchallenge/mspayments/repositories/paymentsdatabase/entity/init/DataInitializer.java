package com.techchallenge.mspayments.repositories.paymentsdatabase.entity.init;

import com.techchallenge.mspayments.repositories.paymentsdatabase.dto.PaymentOptionTypeEnum;
import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionTypeEntity;
import com.techchallenge.mspayments.repositories.paymentsdatabase.repository.IPaymentOptionTypeEntityRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer {

    private final IPaymentOptionTypeEntityRepository repository;

    public DataInitializer(IPaymentOptionTypeEntityRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        if (repository.count() == 0) {
            for (PaymentOptionTypeEnum type : PaymentOptionTypeEnum.values()) {
                PaymentOptionTypeEntity entity = new PaymentOptionTypeEntity();
                entity.setPaymentOptionType(type);
                repository.save(entity);
            }
        }
    }
}
