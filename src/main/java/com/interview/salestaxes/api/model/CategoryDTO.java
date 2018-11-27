package com.interview.salestaxes.api.model;

import com.interview.salestaxes.domain.BaseEntity;
import com.interview.salestaxes.domain.TaxRate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private String description;
    private TaxRate baseTaxRate;

    @Builder
    public CategoryDTO(String description, TaxRate baseTaxRate) {
        this.description = description;
        this.baseTaxRate = baseTaxRate;
    }
}
