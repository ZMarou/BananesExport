package com.example.bananesexport.infrastructure.converter;

import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.infrastructure.entities.RecipientEntity;

public final class RecipientConverter {

    public static RecipientEntity convertToEntity(Recipient recipient) {
        return RecipientEntity
                .builder()
                .name(recipient.name())
                .address(recipient.address())
                .zipCode(recipient.zipCode())
                .city(recipient.city())
                .country(recipient.country())
                .build();
    }

    public static Recipient convertFromEntity(RecipientEntity recipientEntity) {
        return new Recipient(
                recipientEntity.getName(),
                recipientEntity.getAddress(),
                recipientEntity.getZipCode(),
                recipientEntity.getCity(),
                recipientEntity.getCountry());
    }
}
