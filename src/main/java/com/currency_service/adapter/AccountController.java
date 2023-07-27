package com.currency_service.adapter;

import com.currency_service.domain.CurrencyService;
import com.currency_service.domain.model.Account;
import com.currency_service.domain.AccountService;
import com.currency_service.domain.model.AccountNotFoundException;
import com.currency_service.domain.model.AccountResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final CurrencyService currencyService;

//    @Autowired
//    public AccountController(AccountService accountService) {
//        this.accountService = accountService;
//    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        var createdAccount = accountService.createAccount(account.getFirstName(), account.getLastName(), account.getBalance());
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<AccountResponse> getAccount(@RequestParam("id") String accountId) {
        var account = accountService
                .findAccountById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(accountId));

        var usdBalance = currencyService.calculateUsdBalance(account.getBalance());

        var accountResponse = AccountResponse.builder()
                .accountId(account.getAccountId())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .plnBalance(account.getBalance())
                .usdBalance(usdBalance)
                .build();

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }
}
