package com.currency_service.adapter;

import com.currency_service.adapter.CurrencyConfiguration;
import com.currency_service.domain.AccountService;
import com.currency_service.domain.CurrencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SpringBootTest
@Import(CurrencyConfiguration.class)
class CurrencyConfigurationIntegrationTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CurrencyService currencyService;

    @Test
    void currencyConfiguration_shouldAlwaysWireBeans() {
        assertSoftly(softly -> {
            softly.assertThat(accountService).isNotNull();
            softly.assertThat(currencyService).isNotNull();
        });
    }
}