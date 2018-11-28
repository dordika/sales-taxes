package com.interview.salestaxes.services;

import com.interview.salestaxes.api.model.ReceiptDTO;
import com.interview.salestaxes.api.model.ShoppingBasketDTO;

/***
 * This interface is implemented to prevent different tax regulations
 * respecting Reliability and Maintainability
 */
public interface TaxeService {
    ReceiptDTO applyTaxes(ShoppingBasketDTO shoppingBasketDTO);
}
