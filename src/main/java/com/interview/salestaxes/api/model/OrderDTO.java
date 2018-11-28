package com.interview.salestaxes.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private Integer amount;
    private ProductDTO product;
    private boolean imported;

    @Builder
    public OrderDTO(Integer amount, ProductDTO product, boolean imported) {
        this.amount = amount;
        this.product = product;
        this.imported = imported;
    }
}
