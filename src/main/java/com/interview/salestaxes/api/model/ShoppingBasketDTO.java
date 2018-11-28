package com.interview.salestaxes.api.model;

import com.interview.salestaxes.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ShoppingBasketDTO extends BaseEntity {

    @ApiModelProperty(required = true)
    private List<OrderDTO> orders = new ArrayList<>();

}
