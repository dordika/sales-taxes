package com.interview.salestaxes.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ShoppingBasket extends BaseEntity {

    private List<Order> orders = new ArrayList<>();

}
