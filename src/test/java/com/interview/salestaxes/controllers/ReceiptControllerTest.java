package com.interview.salestaxes.controllers;

import com.interview.salestaxes.api.model.CategoryDTO;
import com.interview.salestaxes.api.model.OrderDTO;
import com.interview.salestaxes.api.model.ProductDTO;
import com.interview.salestaxes.api.model.ShoppingBasketDTO;
import com.interview.salestaxes.domain.TaxRate;
import com.interview.salestaxes.services.TaxeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReceiptControllerTest extends AbstractRestControllerTest {

    @Mock
    TaxeService taxeService;

    @InjectMocks
    ReceiptController receiptController;

    MockMvc mockMvc;

    CategoryDTO food;
    CategoryDTO book;
    CategoryDTO medical;
    CategoryDTO others;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(receiptController)
                .build();

        food = CategoryDTO.builder().description("Food").baseTaxRate(TaxRate.EXEMPT).build();
        book = CategoryDTO.builder().description("Food").baseTaxRate(TaxRate.EXEMPT).build();
        medical = CategoryDTO.builder().description("Food").baseTaxRate(TaxRate.EXEMPT).build();
        others = CategoryDTO.builder().description("Others").baseTaxRate(TaxRate.BASIC_TAX).build();
    }

    @Test
    public void getReceipt() throws Exception {
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

        String basketJson = asJsonString(shoppingBasketDTO);

        mockMvc.perform(post(ReceiptController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(basketJson))
                .andExpect(status().isOk());
    }
}