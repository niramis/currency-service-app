package com.currency_service.adapter;

import com.currency_service.domain.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/usd")
    public ResponseEntity<Double> getCurrencyRate() {
        var currency = currencyService.getUsdExchangeRate();
        return new ResponseEntity<>(currency, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Double> calculateUsdBalance(@RequestParam("balance") double balance) {
        var usdBalance = currencyService.calculateUsdBalance(balance);
        return new ResponseEntity<>(usdBalance, HttpStatus.OK);
    }
}
