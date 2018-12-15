package com.interview.salestaxes.api.mapper;

import com.interview.salestaxes.api.model.ShoppingBasketDTO;
import com.interview.salestaxes.domain.ShoppingBasket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ShoppingBasketMapper {

    ShoppingBasketMapper INSTANCE = Mappers.getMapper(ShoppingBasketMapper.class);

    ShoppingBasketDTO shoppingBasketToShoppingBasketDTO(ShoppingBasket shoppingBasket);

    ShoppingBasket shoppingBasketDTOToShoppingBasket(ShoppingBasketDTO shoppingBasketDTO);
}
