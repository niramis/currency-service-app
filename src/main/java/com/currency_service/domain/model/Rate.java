package com.currency_service.domain.model;

import lombok.Data;

@Data
public class Rate {
    private String no;
    private String effectiveDate;
    private double mid;
}
