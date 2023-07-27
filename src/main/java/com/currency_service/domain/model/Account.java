package com.currency_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Account {
    private String accountId;
    private String firstName;
    private String lastName;
    private double balance;
}
