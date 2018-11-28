package com.interview.salestaxes.api.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class ItemReceiptDTO {

    private Integer amount;
    private ProductDTO product;
    private double tax;
    private double priceTaxed;

}
