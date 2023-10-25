package com.example.bananesexport.domain.model;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

public record Price(BigDecimal value) {

    public Price {
        if (isNull(value) || value.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Value is not supported");
    }
}
