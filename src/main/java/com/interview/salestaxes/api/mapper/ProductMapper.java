package com.interview.salestaxes.api.mapper;

import com.interview.salestaxes.api.model.ProductDTO;
import com.interview.salestaxes.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(Product product);

    Product productDtoToCustomer(ProductDTO productDTO);
}
