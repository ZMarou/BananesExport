package com.example.bananesexport.domain.services;

import com.example.bananesexport.domain.exception.DeliveryDateException;
import com.example.bananesexport.domain.exception.QuantityException;
import com.example.bananesexport.domain.exception.RecipientException;
import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.inbound.CreateCommandUseCase;
import com.example.bananesexport.domain.ports.outbound.CreateCommandPort;
import com.example.bananesexport.domain.ports.outbound.GetRecipientPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@AllArgsConstructor
@Service
public class CreateCommandService implements CreateCommandUseCase {

    private CreateCommandPort createCommandPort;

    private GetRecipientPort getRecipientPort;

    @Override
    public Command createCommand(Command command) throws DeliveryDateException, QuantityException, RecipientException {
        Recipient recipientFounded = getRecipientPort.getRecipient(command.getRecipient());
        if (recipientFounded != null) {
            Command cmd = createCommandPort.createCommand(new Command(new Random().nextLong(), command.getDeliveryDate(), command.getQuantity(), command.getPricePerKilo(), recipientFounded));
            cmd.calculatePrice();
            return cmd;
        } else {
            throw new RecipientException("Recipient is not exists");
        }
    }
}
