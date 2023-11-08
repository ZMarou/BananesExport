package com.example.bananesexport.infrastructure.adapter;

import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.outbound.CreateRecipientPort;
import com.example.bananesexport.infrastructure.converter.RecipientConverter;
import com.example.bananesexport.infrastructure.repository.RecipientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateRecipientAdapter implements CreateRecipientPort {

    private RecipientRepository recipientRepository;

    @Override
    public void createRecipient(Recipient recipient) {
        recipientRepository.save(RecipientConverter.convertToEntity(recipient));
    }
}
