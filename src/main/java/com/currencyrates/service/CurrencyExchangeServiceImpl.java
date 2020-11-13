package com.currencyrates.service;

import com.currencyrates.domain.CurrencyExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CurrencyExchangeRepository repository;

    public String storeData(String url) {
        String resp = restTemplate.getForObject(url, String.class);
        JSONObject object = new JSONObject(resp);
        CurrencyExchange exchange = new CurrencyExchange();
        String base = object.getString("base");
        exchange.setBase(base);
        String date = object.getString("date");
        exchange.setDate(date);
        JSONObject object1 = object.getJSONObject("rates");
        Map<String, Double> map = new HashMap<String, Double>();
        Iterator<String> keys = object1.keys();
        while (keys.hasNext()) {
            String key = keys.next();
         if(key.equals("GBP") || key.equals("USD") || key.equals("HKD")) {
             Double value = (Double) object1.get(key);
             map.put(key, value);
         }
        }
        exchange.setRates(map);
        repository.save(exchange);
        return "Data Retrived Success and Inserted Local Data base";

    }

    public CurrencyExchange displayData(String date) {
        CurrencyExchange exchange = new CurrencyExchange();
        List<CurrencyExchange> fromDatabase = repository.findByDate(date);
        for (CurrencyExchange cexchange : fromDatabase) {
            exchange.setId(cexchange.getId());
            exchange.setBase(cexchange.getBase());
            exchange.setDate(cexchange.getDate());
            exchange.setRates(cexchange.getRates());
        }
        return exchange;
    }
}

