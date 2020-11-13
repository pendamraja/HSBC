package com.currencyrates.service;

import com.currencyrates.domain.CurrencyExchange;

public interface CurrencyExchangeService
{
   String storeData(String url);
   CurrencyExchange displayData(String date);
}
