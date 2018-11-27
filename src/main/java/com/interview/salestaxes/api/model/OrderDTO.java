package com.interview.salestaxes.api.model;

import com.interview.salestaxes.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO extends  BaseEntity {

    private Integer amount;
    private ProductDTO product;
    private boolean imported;

}
