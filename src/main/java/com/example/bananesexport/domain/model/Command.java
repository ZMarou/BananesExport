package com.example.bananesexport.domain.model;

import com.example.bananesexport.domain.exception.DeliveryDateException;
import com.example.bananesexport.domain.exception.QuantityException;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.example.bananesexport.domain.model.Constants.*;
import static java.util.Objects.isNull;

@Data
public class Command {

    private long id;
    private LocalDate deliveryDate;
    private int quantity;
    private Price pricePerKilo;
    private Recipient recipient;
    private Price price;

    public Command(long id, LocalDate deliveryDate, int quantity, Price pricePerKilo, Recipient recipient)
            throws DeliveryDateException, QuantityException {
        checkRules(deliveryDate, quantity, pricePerKilo, recipient);
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.pricePerKilo = pricePerKilo;
        this.recipient = recipient;
    }

    private void checkRules(LocalDate deliveryDate, int quantity, Price pricePerKilo, Recipient recipient) throws DeliveryDateException, QuantityException {
        if (isNull(deliveryDate)) throw new IllegalArgumentException("Delivery date is null");
        if (isNull(pricePerKilo)) throw new IllegalArgumentException("Price per kilo is null");
        if (isNull(recipient)) throw new IllegalArgumentException("Recipient is null");
        if (LocalDate.now().plusDays(REGULATORY_NUMBER_OF_DAY).isAfter(deliveryDate))
            throw new DeliveryDateException("Delivery date is before regulatory date");
        if (quantity < QUANTITY_MIN || quantity > QUANTITY_MAX || quantity % WEIGHT_OF_BANANAS_BOX != 0)
            throw new QuantityException("Quantity is not supported");
    }

    public void calculatePrice() {
        price = new Price(pricePerKilo.value().multiply(BigDecimal.valueOf(quantity)));
    }
}
