package com.example.bananesexport.infrastructure.converter;

import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.model.Price;
import com.example.bananesexport.infrastructure.entities.CommandEntity;
import com.example.bananesexport.infrastructure.entities.RecipientEntity;

public final class CommandConverter {

    public static CommandEntity convertToEntity(Command command, RecipientEntity recipientEntity) {
        return CommandEntity
                .builder()
                .id(command.getId())
                .deliveryDate(command.getDeliveryDate())
                .quantity(command.getQuantity())
                .pricePerKilo(command.getPricePerKilo().value())
                .recipient(recipientEntity)
                .build();
    }

    public static Command convertFromEntity(CommandEntity commandEntity) {
        return new Command(commandEntity.getId(),
                commandEntity.getDeliveryDate(),
                commandEntity.getQuantity(),
                new Price(commandEntity.getPricePerKilo()),
                RecipientConverter.convertFromEntity(commandEntity.getRecipient()));
    }
}
