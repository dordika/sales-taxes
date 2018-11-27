package com.interview.salestaxes.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
public class Product  extends  BaseEntity {

    private String description;
    private Category category;
    private Double price;
}
