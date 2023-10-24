package com.example.bananesexport.domain.model;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record Recipient(String name, String address, String zipCode, String city, String country) {

    public Recipient {
        if (isBlank(name)) throw new IllegalArgumentException("Name is null");
        if (isBlank(address)) throw new IllegalArgumentException("Address is null");
        if (isBlank(zipCode)) throw new IllegalArgumentException("Zip code is null");
        if (isBlank(city)) throw new IllegalArgumentException("City is null");
        if (isBlank(country)) throw new IllegalArgumentException("Country is null");
    }
}
