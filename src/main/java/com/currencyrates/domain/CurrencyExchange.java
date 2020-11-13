package com.currencyrates.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

@Data
@AllArgsConstructor
@Entity
public class CurrencyExchange
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String base;
    private String date;
    @ElementCollection
    private Map<String,Double> rates;

    public CurrencyExchange() {
    }
}
