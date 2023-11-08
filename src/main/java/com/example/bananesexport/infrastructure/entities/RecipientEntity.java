package com.example.bananesexport.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@IdClass(RecipientId.class)
@Table(name = "recipient")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecipientEntity {

    @Id
    private String name;
    @Id
    private String address;
    @Id
    private String zipCode;
    @Id
    private String city;
    @Id
    private String country;
}
