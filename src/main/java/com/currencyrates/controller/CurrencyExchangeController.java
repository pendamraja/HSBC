package com.currencyrates.controller;

import com.currencyrates.domain.CurrencyExchange;
import com.currencyrates.service.CurrencyExchangeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController
{
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${test.url}")
    private  String API_URI;
    @Autowired
    CurrencyExchangeServiceImpl currencyExchangeServiceImpl;

    @GetMapping(value="/latest")
    public String getlatestCurrencyrates()
    {
        log.info("API URL:",API_URI);
        return currencyExchangeServiceImpl.storeData(API_URI);


    }
    @GetMapping(value="/Inmemory/{date}")
    public CurrencyExchange displayInMemoryInfo(@PathVariable(value = "date") String date)
    {
        log.info("Display InMomoryInfo");
       return currencyExchangeServiceImpl.displayData(date);
    }
}
