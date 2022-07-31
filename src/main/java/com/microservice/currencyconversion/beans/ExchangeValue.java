package com.microservice.currencyconversion.beans;

import lombok.Data;
import java.math.BigDecimal;
import javax.persistence.Id;
import javax.persistence.Entity;

@Data
@Entity
public class ExchangeValue {
    @Id
    private Long id;
    private Integer port;
    private String toCurrency;
    private String fromCurrency;
    private BigDecimal conversionMultiple;

    public ExchangeValue(){}

    public ExchangeValue(Long id, String fromCurrency, String toCurrency, BigDecimal conversionMultiple){
        this.id = id;
        this.toCurrency = toCurrency;
        this.fromCurrency = fromCurrency;
        this.conversionMultiple = conversionMultiple;
    }
}