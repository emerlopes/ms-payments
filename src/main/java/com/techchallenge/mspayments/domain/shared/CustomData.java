package com.techchallenge.mspayments.domain.shared;

import lombok.experimental.Accessors;

@lombok.Data
@Accessors(chain = true)
public class CustomData<T> {

    private T data;

}
