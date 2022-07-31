package com.microservice.currencyconversion.repository;

import com.microservice.currencyconversion.beans.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByFromCurrencyAndToCurrency(String currencyFrom, String currencyTo);
}
