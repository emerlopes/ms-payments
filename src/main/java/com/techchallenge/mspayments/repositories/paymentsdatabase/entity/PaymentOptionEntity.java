package com.techchallenge.mspayments.repositories.paymentsdatabase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_options")
public class PaymentOptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_option_id")
    private Long paymentOptionId;

    @Column(name = "external_driver_id")
    private UUID externalDriverId;

    @ManyToOne
    @JoinColumn(name = "payment_option_type_id")
    private PaymentOptionTypeEntity paymentOptionType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
