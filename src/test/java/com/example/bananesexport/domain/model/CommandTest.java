package com.example.bananesexport.domain.model;

import com.example.bananesexport.domain.exception.DeliveryDateException;
import com.example.bananesexport.domain.exception.QuantityException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {

    public static final Price PRICE_PER_KILO = new Price(BigDecimal.TEN);
    public static final Recipient RECIPIENT = new Recipient("Dupont", "avenue charles de gaulle", "75008", "Paris", "France");
    public static final LocalDate DELIVERY_DATE = LocalDate.now().plusDays(9);

    @Test
    public void should_create_command_when_all_field_filled() throws DeliveryDateException, QuantityException {
        Command cmd = new Command(1L, DELIVERY_DATE, 25, PRICE_PER_KILO, RECIPIENT);
        assertNotNull(cmd);
    }

    @Test
    public void should_return_illegal_argument_exception_when_delivery_date_is_null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Command(1L, null, 0, PRICE_PER_KILO, RECIPIENT));
        assertEquals("Delivery date is null", exception.getMessage());
    }

    @Test
    public void should_return_illegal_argument_exception_when_price_per_kilo_is_null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Command(1L, DELIVERY_DATE, 0, null, RECIPIENT));
        assertEquals("Price per kilo is null", exception.getMessage());
    }

    @Test
    public void should_return_illegal_argument_exception_when_recipient_is_null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Command(1L, DELIVERY_DATE, 0, PRICE_PER_KILO, null));
        assertEquals("Recipient is null", exception.getMessage());
    }

    @Test
    public void should_return_delivery_date_exception_when_delivery_date_dont_respect_regulatory_date() {
        DeliveryDateException exception = assertThrows(DeliveryDateException.class, () -> new Command(1L, LocalDate.now().plusDays(6), 0, PRICE_PER_KILO, RECIPIENT));
        assertEquals("Delivery date is before regulatory date", exception.getMessage());
    }

    @Test
    public void should_return_quantity_exception_when_quantity_is_negative() {
        QuantityException exception = assertThrows(QuantityException.class, () -> new Command(1L, DELIVERY_DATE, -1, PRICE_PER_KILO, RECIPIENT));
        assertEquals("Quantity is not supported", exception.getMessage());
    }

    @Test
    public void should_return_quantity_exception_when_quantity_is_more_than_10000() {
        QuantityException exception = assertThrows(QuantityException.class, () -> new Command(1L, DELIVERY_DATE, 10005, PRICE_PER_KILO, RECIPIENT));
        assertEquals("Quantity is not supported", exception.getMessage());
    }

    @Test
    public void should_return_quantity_exception_when_quantity_is_not_multiples_of_25() {
        QuantityException exception = assertThrows(QuantityException.class, () -> new Command(1L, DELIVERY_DATE, 24, PRICE_PER_KILO, RECIPIENT));
        assertEquals("Quantity is not supported", exception.getMessage());
    }
}
