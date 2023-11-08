package com.example.bananesexport.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipientId implements Serializable {
    private String name;
    private String address;
    private String zipCode;
    private String city;
    private String country;
}
