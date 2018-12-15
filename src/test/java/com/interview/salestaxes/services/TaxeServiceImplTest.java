package com.interview.salestaxes.services;

import com.interview.salestaxes.api.model.*;
import com.interview.salestaxes.domain.TaxRate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static org.junit.Assert.*;

public class TaxeServiceImplTest {

    CategoryDTO food;
    CategoryDTO book;
    CategoryDTO medical;
    CategoryDTO others;

    TaxeService taxeService;


    @BeforeEach
    public void setUp() throws Exception {

        taxeService = new TaxeServiceImpl();

        food = CategoryDTO.builder().description("Food").baseTaxRate(TaxRate.EXEMPT).build();
        book = CategoryDTO.builder().description("Food").baseTaxRate(TaxRate.EXEMPT).build();
        medical = CategoryDTO.builder().description("Food").baseTaxRate(TaxRate.EXEMPT).build();
        others = CategoryDTO.builder().description("Others").baseTaxRate(TaxRate.BASIC_TAX).build();

    }

    /**
     * TEST SHOPPING BASKET 1
     * INPUT
     * 1 book at 12.49
     * 1 music CD at 14.99
     * 1 chocolate bar at 0.85
     * #####################
     * OUTPUT
     * 1 book : 12.49
     * 1 music CD: 16.49
     * 1 chocolate bar: 0.85
     * Sales Taxes: 1.50
     * Total: 29.83
     */
    @Test
    public void applyTaxesInput1() {
        ShoppingBasketDTO shoppingBasketDTO = new ShoppingBasketDTO();

        String descriptionBook = "Book";
        double priceBook = 12.49;
        ProductDTO bookProd = ProductDTO.builder().description(descriptionBook).price(priceBook).category(book).build();
        ProductDTO musicCd = ProductDTO.builder().description("music CD").price(14.99).category(others).build();
        ProductDTO chocBar = ProductDTO.builder().description("music CD").price(0.85).category(food).build();


        shoppingBasketDTO.getOrders().add(OrderDTO.builder().amount(1).product(bookProd).imported(false).build());
        shoppingBasketDTO.getOrders().add(OrderDTO.builder().amount(1).product(musicCd).imported(false).build());
        shoppingBasketDTO.getOrders().add(OrderDTO.builder().amount(1).product(chocBar).imported(false).build());

        ReceiptDTO receiptDTO = taxeService.applyTaxes(shoppingBasketDTO);

        assertNotNull(receiptDTO);

        assertEquals(descriptionBook, receiptDTO.getItemReceipts().stream()
                .filter(itemReceiptDTO -> itemReceiptDTO.getProduct().getDescription().equals(descriptionBook))
                .findFirst().get().getProduct().getDescription());

        assertEquals(priceBook, receiptDTO.getItemReceipts().stream()
                .filter(itemReceiptDTO -> itemReceiptDTO.getProduct().getDescription().equals(descriptionBook))
                .findFirst().get().getProduct().getPrice(),0);

        assertEquals(1.5,receiptDTO.getSumSalesTaxe(),0);
        assertEquals(29.83,receiptDTO.getTot(),0);

    }

    /**
     * TEST SHOPPING BASKET 2
     * INPUT
     * 1 imported box of chocolates at 10.00
     * 1 imported bottle of perfume at 47.50
     * #####################
     * OUTPUT
     * 1 imported box of chocolates: 10.50
     * 1 imported bottle of perfume: 54.65
     * Sales Taxes: 7.65
     * Total: 65.15
     */
    @Test
    public void applyTaxesInput2() {
        ShoppingBasketDTO shoppingBasketDTO = new ShoppingBasketDTO();

        String descriptionBoxChoc = "Box of choc";
        double priceChoc = 10;
        ProductDTO boxChoc = ProductDTO.builder().description(descriptionBoxChoc).price(priceChoc).category(food).build();
        ProductDTO perfum = ProductDTO.builder().description("Bottle of perfum").price(47.5).category(others).build();

        shoppingBasketDTO.getOrders().add(OrderDTO.builder().amount(1).product(boxChoc).imported(true).build());
        shoppingBasketDTO.getOrders().add(OrderDTO.builder().amount(1).product(perfum).imported(true).build());

        ReceiptDTO receiptDTO = taxeService.applyTaxes(shoppingBasketDTO);

        assertNotNull(receiptDTO);

        assertEquals(descriptionBoxChoc, receiptDTO.getItemReceipts().stream()
                .filter(itemReceiptDTO -> itemReceiptDTO.getProduct().getDescription().equals(descriptionBoxChoc))
                .findFirst().get().getProduct().getDescription());

        assertEquals(priceChoc, receiptDTO.getItemReceipts().stream()
                .filter(itemReceiptDTO -> itemReceiptDTO.getProduct().getDescription().equals(descriptionBoxChoc))
                .findFirst().get().getProduct().getPrice(),0);

        assertEquals(7.65,receiptDTO.getSumSalesTaxe(),0);
        assertEquals(65.15,receiptDTO.getTot(),0);

    }

    /**
     * TEST SHOPPING BASKET 3
     * INPUT
     * 1 imported bottle of perfume at 27.99
     * 1 bottle of perfume at 18.99
     * 1 packet of headache pills at 9.75
     * 1 box of imported chocolates at 11.25
     * #####################
     * OUTPUT
     * 1 imported bottle of perfume: 32.19
     * 1 bottle of perfume: 20.89
     * 1 packet of headache pills: 9.75
     * 1 imported box of chocolates: 11.85
     * Sales Taxes: 6.70
     * Total: 74.68
     */
    @Test
    public void applyTaxesInput3() {
        ShoppingBasketDTO shoppingBasketDTO = new ShoppingBasketDTO();


        String descriptionPills = "packet headache pills";
        double pricehePills = 9.75;

        ProductDTO perfum = ProductDTO.builder().description("Bottle of perfum").price(27.99).category(others).build();
        ProductDTO perfum2 = ProductDTO.builder().description("Bottle of perfum").price(18.99).category(others).build();
        ProductDTO pills = ProductDTO.builder().description(descriptionPills).price(pricehePills).category(medical).build();
        ProductDTO boxChoc = ProductDTO.builder().description("Box of chocolates").price(11.25).category(food).build();

        shoppingBasketDTO.getOrders().add(OrderDTO.builder().amount(1).product(perfum).imported(true).build());
        shoppingBasketDTO.getOrders().add(OrderDTO.builder().amount(1).product(perfum2).imported(false).build());
        shoppingBasketDTO.getOrders().add(OrderDTO.builder().amount(1).product(pills).imported(false).build());
        shoppingBasketDTO.getOrders().add(OrderDTO.builder().amount(1).product(boxChoc).imported(true).build());

        ReceiptDTO receiptDTO = taxeService.applyTaxes(shoppingBasketDTO);

        assertNotNull(receiptDTO);

        assertEquals(descriptionPills, receiptDTO.getItemReceipts().stream()
                .filter(itemReceiptDTO -> itemReceiptDTO.getProduct().getDescription().equals(descriptionPills))
                .findFirst().get().getProduct().getDescription());

        assertEquals(pricehePills, receiptDTO.getItemReceipts().stream()
                .filter(itemReceiptDTO -> itemReceiptDTO.getProduct().getDescription().equals(descriptionPills))
                .findFirst().get().getProduct().getPrice(),0);


        assertEquals(6.7,receiptDTO.getSumSalesTaxe(),0);
        assertEquals(74.68,receiptDTO.getTot(),0);

    }

}