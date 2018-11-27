package com.interview.salestaxes.api.model;

import com.interview.salestaxes.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ShoppingBasketDTO extends BaseEntity {

    private List<OrderDTO> orders = new ArrayList<>();

}
