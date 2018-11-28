package com.interview.salestaxes.domain;


public enum  TaxRate {

    EXEMPT(0), //Rate for free catefory
    BASIC_TAX (0.10), //Basic Tax Rate 10%
    IMPORT_DUTY (0.05); //Rate to add to basic taxes in case of imported

    private double rate;

    TaxRate(double rate) {
        this.rate = rate;
    }

    public double getRate(){
        return this.rate;
    }
}
