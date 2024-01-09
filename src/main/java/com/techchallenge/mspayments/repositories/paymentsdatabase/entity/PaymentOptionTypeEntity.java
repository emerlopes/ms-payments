package com.techchallenge.mspayments.repositories.paymentsdatabase.entity;

import com.techchallenge.mspayments.repositories.paymentsdatabase.dto.PaymentOptionTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "payment_option_type")
public class PaymentOptionTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_option_type_id")
    private Long paymentOptionTypeId;

    @Column(name = "payment_option_type_name")
    private PaymentOptionTypeEnum paymentOptionType;

}
