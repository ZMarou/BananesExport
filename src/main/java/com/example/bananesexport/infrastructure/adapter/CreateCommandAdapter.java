package com.example.bananesexport.infrastructure.adapter;

import com.example.bananesexport.domain.exception.RecipientException;
import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.ports.outbound.CreateCommandPort;
import com.example.bananesexport.infrastructure.converter.CommandConverter;
import com.example.bananesexport.infrastructure.entities.CommandEntity;
import com.example.bananesexport.infrastructure.entities.RecipientEntity;
import com.example.bananesexport.infrastructure.entities.RecipientId;
import com.example.bananesexport.infrastructure.repository.CommandRepository;
import com.example.bananesexport.infrastructure.repository.RecipientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CreateCommandAdapter implements CreateCommandPort {

    private CommandRepository commandRepository;
    private RecipientRepository recipientRepository;

    @Override
    public Command createCommand(Command command) {
        Optional<RecipientEntity> recipientEntity = recipientRepository.findById(RecipientId.builder()
                .name(command.getRecipient().name())
                .address(command.getRecipient().address())
                .zipCode(command.getRecipient().zipCode())
                .city(command.getRecipient().city())
                .country(command.getRecipient().country())
                .build());
        if (recipientEntity.isEmpty()) throw new RecipientException("Recipient is not exists");
        CommandEntity commandEntity = commandRepository.save(CommandConverter.convertToEntity(command, recipientEntity.get()));
        return CommandConverter.convertFromEntity(commandEntity);
    }
}
