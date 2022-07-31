package com.microservice.currencyconversion.controllers;

import com.microservice.currencyconversion.repository.ExchangeValueRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.currencyconversion.beans.ExchangeValue;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromCurrencyAndToCurrency(from.toUpperCase(), to.toUpperCase());

        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        return exchangeValue;
    }
}
