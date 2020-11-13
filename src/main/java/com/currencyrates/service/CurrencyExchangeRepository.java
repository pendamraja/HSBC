package com.currencyrates.service;

import com.currencyrates.domain.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, String> {
    List<CurrencyExchange> findByDate(String date);
}
