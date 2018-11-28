package com.interview.salestaxes.controllers;

import com.interview.salestaxes.api.model.ReceiptDTO;
import com.interview.salestaxes.api.model.ShoppingBasketDTO;
import com.interview.salestaxes.services.TaxeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ReceiptController.BASE_URL)
public class ReceiptController {

    public static final String BASE_URL = "/api/receipt";

    private final TaxeService taxeService;

    public ReceiptController(TaxeService taxeService) {
        this.taxeService = taxeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ReceiptDTO getReceipt(@RequestBody ShoppingBasketDTO basketDTO) {
        return taxeService.applyTaxes(basketDTO);
    }
}
