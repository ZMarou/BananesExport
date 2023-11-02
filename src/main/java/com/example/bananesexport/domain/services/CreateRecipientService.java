package com.example.bananesexport.domain.services;

import com.example.bananesexport.domain.exception.RecipientException;
import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.inbound.CreateRecipientUseCase;
import com.example.bananesexport.domain.ports.outbound.CreateRecipientPort;
import com.example.bananesexport.domain.ports.outbound.GetRecipientPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateRecipientService implements CreateRecipientUseCase {

    private CreateRecipientPort createRecipientPort;

    private GetRecipientPort getRecipientPort;

    @Override
    public void createRecipient(Recipient recipient) {
        Recipient recipientFounded = getRecipientPort.getRecipient(recipient);
        if (recipientFounded == null) {
            createRecipientPort.createRecipient(recipient);
        } else {
            throw new RecipientException("Recipient is already exists");
        }
    }
}
