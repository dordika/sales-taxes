package com.interview.salestaxes.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *  This class track the items bought,
 *  the total price for all the items, the tax rate,
 */
@Getter
@Setter
@NoArgsConstructor
public class Receipt extends  BaseEntity {

    List<ItemReceipt> itemReceipts = new ArrayList<>();
    private BigDecimal sumSalesTaxe;
    private BigDecimal tot;
}
