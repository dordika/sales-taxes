package com.interview.salestaxes.api.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    private String description;
    private CategoryDTO category;
    private double price;

    @Builder
    public ProductDTO(String description, CategoryDTO category, double price) {
        this.description = description;
        this.category = category;
        this.price = price;
    }
}
