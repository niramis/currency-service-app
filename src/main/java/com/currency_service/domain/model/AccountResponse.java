package com.currency_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AccountResponse {
    private String accountId;
    private String firstName;
    private String lastName;
    private double plnBalance;
    private double usdBalance;
}
