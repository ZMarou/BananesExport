package com.example.bananesexport.infrastructure.adapter;

import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.outbound.GetRecipientPort;
import com.example.bananesexport.infrastructure.converter.RecipientConverter;
import com.example.bananesexport.infrastructure.entities.RecipientEntity;
import com.example.bananesexport.infrastructure.entities.RecipientId;
import com.example.bananesexport.infrastructure.repository.RecipientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GetRecipientAdapter implements GetRecipientPort {

    private RecipientRepository recipientRepository;

    @Override
    public Optional<Recipient> getRecipient(Recipient recipient) {
        Optional<RecipientEntity> recipientEntity = recipientRepository.findById(RecipientId.builder()
                .name(recipient.name())
                .address(recipient.address())
                .zipCode(recipient.zipCode())
                .city(recipient.city())
                .country(recipient.country())
                .build());
        return recipientEntity.map(RecipientConverter::convertFromEntity);
    }

    @Override
    public List<Recipient> getAllRecipient() {
        List<RecipientEntity> list = recipientRepository.findAll();
        return list.stream().map(RecipientConverter::convertFromEntity).toList();
    }
}
