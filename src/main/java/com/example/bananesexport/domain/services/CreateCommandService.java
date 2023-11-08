package com.example.bananesexport.domain.services;

import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.ports.inbound.CreateCommandUseCase;
import com.example.bananesexport.domain.ports.outbound.CreateCommandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class CreateCommandService implements CreateCommandUseCase {

    private CreateCommandPort createCommandPort;

    @Override
    public Command createCommand(Command command) {
        Command cmd = createCommandPort.createCommand(new Command(UUID.randomUUID(), command.getDeliveryDate(), command.getQuantity(), command.getPricePerKilo(), command.getRecipient()));
        cmd.calculatePrice();
        return cmd;
    }
}
