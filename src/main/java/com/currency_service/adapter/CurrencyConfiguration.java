package com.currency_service.adapter;

import com.currency_service.domain.AccountService;
import com.currency_service.domain.CurrencyService;
import com.currency_service.domain.IdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CurrencyConfiguration {

    @Bean
    public AccountService accountService(final IdGenerator idGenerator) {
        return new AccountService(idGenerator);
    }

    @Bean
    public CurrencyService currencyService(final WebClient webClient) {
        return new CurrencyService(webClient);
    }

    @Bean
    public IdGenerator idGenerator() {
        return new IdGenerator();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.create("https://api.nbp.pl");
    }
}
