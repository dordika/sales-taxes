package com.interview.salestaxes.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class ReceiptDTO  {

    List<ItemReceiptDTO> itemReceipts = new ArrayList<>();
    private BigDecimal sumSalesTaxe;
    private BigDecimal tot;
}
