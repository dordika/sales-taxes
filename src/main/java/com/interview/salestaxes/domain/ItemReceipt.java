package com.interview.salestaxes.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class ItemReceipt  extends BaseEntity {

    private Integer amount;
    private Product product;
    private Double tax;
    private BigDecimal priceTaxed;

}
