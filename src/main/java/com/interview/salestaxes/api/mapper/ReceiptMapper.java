package com.interview.salestaxes.api.mapper;

import com.interview.salestaxes.api.model.ReceiptDTO;
import com.interview.salestaxes.domain.Receipt;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ReceiptMapper {

    ReceiptMapper INSTANCE = Mappers.getMapper(ReceiptMapper.class);

    ReceiptDTO receiptToReceiptDto (Receipt receipt);

    Receipt receiptDtoToReceipt(ReceiptDTO receiptDTO);
}
