package com.example.bananesexport.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecipientTest {

    @Test
    public void should_create_recipient_when_all_field_filled() {
        Recipient recipient = new Recipient("Dupont", "avenue charles de gaulle", "75008", "Paris", "France");
        assertNotNull(recipient);
    }

    @Test
    public void should_return_illegal_argument_exception_when_name_is_null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Recipient("", "avenue charles de gaulle", "75008", "Paris", "France"));
        assertEquals("Name is null", exception.getMessage());
    }

    @Test
    public void should_return_illegal_argument_exception_when_address_is_null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Recipient("Dupont", "", "75008", "Paris", "France"));
        assertEquals("Address is null", exception.getMessage());
    }

    @Test
    public void should_return_illegal_argument_exception_when_zip_code_is_null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Recipient("Dupont", "avenue charles de gaulle", "", "Paris", "France"));
        assertEquals("Zip code is null", exception.getMessage());
    }

    @Test
    public void should_return_illegal_argument_exception_when_city_is_null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Recipient("Dupont", "avenue charles de gaulle", "75008", "", "France"));
        assertEquals("City is null", exception.getMessage());
    }

    @Test
    public void should_return_illegal_argument_exception_when_country_is_null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Recipient("Dupont", "avenue charles de gaulle", "75008", "Paris", ""));
        assertEquals("Country is null", exception.getMessage());
    }


}
