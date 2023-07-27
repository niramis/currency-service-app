package com.currency_service.domain;

import com.currency_service.domain.model.Account;
import com.currency_service.domain.AccountService;
import com.currency_service.domain.IdGenerator;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Tag("unit")
class AccountServiceTest {

    private IdGenerator fakeIdGenerator;
    private final String ACCOUNT_ID = "ABC";
    private final String FIRST_NAME = "FIRST_NAME";
    private final String LAST_NAME = "LAST_NAME";
    private double BALANCE = 10.0;

    @BeforeEach
    void setUp() {
        fakeIdGenerator = mock(IdGenerator.class);
    }

    @Test
    void accountService_shouldAddNewAccount() {
        val accountService = createAccountService();
        when(fakeIdGenerator.generateId()).thenReturn(ACCOUNT_ID);

        val actualAccount = accountService.createAccount(FIRST_NAME, LAST_NAME, BALANCE);

        assertThat(actualAccount).isEqualTo(createAccount());
    }

    private AccountService createAccountService() {
        return new AccountService(fakeIdGenerator);
    }

    private Account createAccount() {
        return Account.builder()
                .accountId(ACCOUNT_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .balance(BALANCE)
                .build();
    }
}