package com.techchallenge.mspayments.domain.shared;

public interface IExecuteArgs<T, J> {
    T execute(J domainObject);
}
