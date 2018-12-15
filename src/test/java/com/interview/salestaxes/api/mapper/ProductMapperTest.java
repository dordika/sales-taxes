package com.interview.salestaxes.api.mapper;

import com.interview.salestaxes.api.model.ProductDTO;
import com.interview.salestaxes.domain.Category;
import com.interview.salestaxes.domain.Product;
import com.interview.salestaxes.domain.TaxRate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ProductMapperTest {

    public static final String DESCRIPTION = "prefum";
    public static final BigDecimal PRICE = new BigDecimal(43.73);
    Category food;

    ProductMapper productMapper = ProductMapper.INSTANCE;


    @BeforeEach
    public void setUp() throws Exception {
        //given
        food = new Category();
        food.setBaseTaxRate(TaxRate.EXEMPT);
        food.setDescription("Food");
    }

    @Test
    public void productToProductDTO() {
         //given
        Product product = new Product();
        product.setDescription(DESCRIPTION);
        product.setPrice(PRICE);
        product.setCategory(food);

        //when
        ProductDTO productDTO = productMapper.productToProductDTO(product);

        //then
        assertNotNull(productDTO);
        assertEquals(DESCRIPTION,productDTO.getDescription());
        assertEquals(food.getDescription(), productDTO.getCategory().getDescription());
    }

    @Test
    public void productDtoToCustomer() {
    }
}