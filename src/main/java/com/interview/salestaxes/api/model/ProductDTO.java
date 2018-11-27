package com.interview.salestaxes.api.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    private String description;
    private CategoryDTO category;
    private Double price;
}
