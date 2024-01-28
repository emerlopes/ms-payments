package com.techchallenge.mspayments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class MsPaymentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPaymentsApplication.class, args);
    }

}
