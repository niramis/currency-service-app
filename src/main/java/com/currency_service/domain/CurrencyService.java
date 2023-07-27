package com.currency_service.domain;

import com.currency_service.domain.model.CurrencyResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@AllArgsConstructor
public class CurrencyService {

    private final WebClient webClient;
    private final String URL = "/api/exchangerates/rates/a/usd/";
    private static final DecimalFormat dfZero = new DecimalFormat("0.00");

    public double getUsdExchangeRate() {
        return webClient.get()
                .uri(URL)
                .retrieve()
                .bodyToMono(CurrencyResponse.class)
                .block()
                .getRates()
                .get(0)
                .getMid();
    }

    public double calculateUsdBalance(double balance) {
        var rate = getUsdExchangeRate();
        return new BigDecimal(balance / rate).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
