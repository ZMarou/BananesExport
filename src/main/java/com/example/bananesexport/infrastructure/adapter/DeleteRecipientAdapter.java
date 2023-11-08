package com.example.bananesexport.infrastructure.adapter;

import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.outbound.DeleteRecipientPort;
import com.example.bananesexport.infrastructure.converter.RecipientConverter;
import com.example.bananesexport.infrastructure.repository.RecipientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteRecipientAdapter implements DeleteRecipientPort {

    private RecipientRepository recipientRepository;

    @Override
    public void deleteRecipient(Recipient recipient) {
        recipientRepository.delete(RecipientConverter.convertToEntity(recipient));
    }
}
