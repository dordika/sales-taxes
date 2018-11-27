package com.interview.salestaxes.domain;

import java.math.BigDecimal;

public enum  TaxRate {

    EXEMPT(BigDecimal.ZERO), //Rate for free catefory
    BASIC_TAX (new BigDecimal(.10)), //Basic Tax Rate 10%
    IMPORT_DUTY (new BigDecimal(0.05)); //Rate to add to basic taxes in case of imported

    private BigDecimal rate;

    TaxRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate(){
        return this.rate;
    }
}
