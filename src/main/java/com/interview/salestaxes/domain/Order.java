package com.interview.salestaxes.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
public class Order extends  BaseEntity {

    private Integer amount;
    private Product product;
    private boolean imported;

}
