package com.interview.salestaxes.api.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class ItemReceiptDTO {

    private Integer amount;
    private ProductDTO product;
    private Double tax;
    private BigDecimal priceTaxed;

}
