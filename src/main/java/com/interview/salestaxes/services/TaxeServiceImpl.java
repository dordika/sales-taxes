package com.interview.salestaxes.services;

import com.interview.salestaxes.api.model.ItemReceiptDTO;
import com.interview.salestaxes.api.model.OrderDTO;
import com.interview.salestaxes.api.model.ReceiptDTO;
import com.interview.salestaxes.api.model.ShoppingBasketDTO;
import com.interview.salestaxes.domain.TaxRate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;


@Slf4j
@Service
public class TaxeServiceImpl implements TaxeService {

    @Override
    public ReceiptDTO applyTaxes(ShoppingBasketDTO shoppingBasketDTO) {
        log.debug("applying tax");

        ReceiptDTO receiptDTO = new ReceiptDTO();
        double sumAmountOfTaxes =  0;
        double totReciep =  0;

        for (OrderDTO order : shoppingBasketDTO.getOrders()) {
            ItemReceiptDTO itemReceipt = calculateTax(order);
            receiptDTO.getItemReceipts().add(itemReceipt);
            sumAmountOfTaxes+= itemReceipt.getTax();
            totReciep += order.getProduct().getPrice();
        }

        sumAmountOfTaxes = roundValue(sumAmountOfTaxes);
        totReciep += sumAmountOfTaxes;
        receiptDTO.setSumSalesTaxe(sumAmountOfTaxes);
        receiptDTO.setTot(round2decimal(totReciep));

        return receiptDTO;
    }

    private ItemReceiptDTO calculateTax(OrderDTO order) {

        ItemReceiptDTO itemReceipt = new ItemReceiptDTO();

        double tax = order.getProduct().getPrice() * calculateRate(order);


        double totTax = tax * order.getAmount();

        double totPriceTaxed = (order.getProduct().getPrice() * order.getAmount()) + totTax;

        itemReceipt.setAmount(order.getAmount());
        itemReceipt.setProduct(order.getProduct());
        itemReceipt.setTax(totTax);
        itemReceipt.setPriceTaxed(round2decimal(totPriceTaxed));
        return itemReceipt;
    }

    private double calculateRate(OrderDTO order) {
        double rate = order.getProduct().getCategory().getBaseTaxRate().getRate();
        return order.isImported() ? rate + TaxRate.IMPORT_DUTY.getRate() : rate;
    }

    private double roundValue(double value){
        // To round to the upper .05
        return (Math.ceil(value*20)/20);
    }

    public double round2decimal(double val) {
        DecimalFormat df = new DecimalFormat("#.##");

        return Double.valueOf(df.format(val));
    }

}
