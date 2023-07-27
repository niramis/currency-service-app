package com.currency_service.domain;

import com.currency_service.domain.model.Account;
import lombok.AllArgsConstructor;
import lombok.val;

import java.util.*;

@AllArgsConstructor
public class AccountService {
    private IdGenerator idGenerator;
    private final Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(final String firstName, final String lastName, double balance) {
        var accountId = idGenerator.generateId();
        var account = new Account(accountId,firstName, lastName, balance);
        accounts.put(accountId, account);
        return account;
    }

    public Optional<Account> findAccountById(final String accountId){
        return Optional.ofNullable(accounts.get(accountId));
    }

}
