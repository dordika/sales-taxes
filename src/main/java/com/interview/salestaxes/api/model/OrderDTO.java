package com.interview.salestaxes.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    @ApiModelProperty(required = true)
    private Integer amount;
    @ApiModelProperty(required = true)
    private ProductDTO product;
    @ApiModelProperty(value = "true/false", required = true)
    private boolean imported;

    @Builder
    public OrderDTO(Integer amount, ProductDTO product, boolean imported) {
        this.amount = amount;
        this.product = product;
        this.imported = imported;
    }
}
