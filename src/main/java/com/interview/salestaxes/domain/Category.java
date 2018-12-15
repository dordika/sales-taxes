package com.interview.salestaxes.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseEntity{

    private String description;
    private TaxRate baseTaxRate;

    @Builder
    public Category(Long id, String description,TaxRate baseTaxRate) {
        super(id);
        this.description = description;
        this.baseTaxRate = baseTaxRate;
    }
}
