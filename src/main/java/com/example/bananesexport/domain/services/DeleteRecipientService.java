package com.example.bananesexport.domain.services;

import com.example.bananesexport.domain.exception.RecipientException;
import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.inbound.DeleteRecipientUseCase;
import com.example.bananesexport.domain.ports.outbound.DeleteRecipientPort;
import com.example.bananesexport.domain.ports.outbound.GetCommandPort;
import com.example.bananesexport.domain.ports.outbound.GetRecipientPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@AllArgsConstructor
@Service
public class DeleteRecipientService implements DeleteRecipientUseCase {

    private DeleteRecipientPort deleteRecipientPort;

    private GetRecipientPort getRecipientPort;

    private GetCommandPort getCommandPort;

    @Override
    public void deleteRecipient(Recipient recipient) {
        Recipient recipientFounded = getRecipientPort.getRecipient(recipient);
        List<Command> commandList = getCommandPort.getCommandsByRecipient(recipient);
        if (recipientFounded == null || CollectionUtils.isEmpty(commandList)) {
            deleteRecipientPort.deleteRecipient(recipientFounded);
        } else {
            throw new RecipientException("Recipient can't be deleted");
        }
    }
}
