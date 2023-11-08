package com.example.bananesexport.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "command")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommandEntity {

    @Id
    private UUID id;
    @Column
    private LocalDate deliveryDate;
    @Column
    private int quantity;
    @Column
    private BigDecimal pricePerKilo;
    @ManyToOne
    @JoinColumns( {
            @JoinColumn(name="name", referencedColumnName="name"),
            @JoinColumn(name="address", referencedColumnName="address"),
            @JoinColumn(name="zipCode", referencedColumnName="zipCode"),
            @JoinColumn(name="city", referencedColumnName="city"),
            @JoinColumn(name="country", referencedColumnName="country")
    } )
    private RecipientEntity recipient;
}
