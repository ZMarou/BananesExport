package com.example.bananesexport.infrastructure.adapter;

import com.example.bananesexport.domain.exception.RecipientException;
import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.outbound.GetCommandPort;
import com.example.bananesexport.infrastructure.converter.CommandConverter;
import com.example.bananesexport.infrastructure.entities.CommandEntity;
import com.example.bananesexport.infrastructure.entities.RecipientEntity;
import com.example.bananesexport.infrastructure.entities.RecipientId;
import com.example.bananesexport.infrastructure.repository.CommandRepository;
import com.example.bananesexport.infrastructure.repository.RecipientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GetCommandAdapter implements GetCommandPort {

    private CommandRepository commandRepository;
    private RecipientRepository recipientRepository;

    @Override
    public List<Command> getCommandsByRecipient(Recipient recipient) {
        Optional<RecipientEntity> recipientEntity = recipientRepository.findById(RecipientId.builder()
                .name(recipient.name())
                .address(recipient.address())
                .zipCode(recipient.zipCode())
                .city(recipient.city())
                .country(recipient.country())
                .build());
        if (recipientEntity.isEmpty()) throw new RecipientException("Recipient is not exists");
        List<CommandEntity> list = commandRepository.findByRecipient(recipientEntity.get());
        return list.stream().map(CommandConverter::convertFromEntity).toList();
    }
}
