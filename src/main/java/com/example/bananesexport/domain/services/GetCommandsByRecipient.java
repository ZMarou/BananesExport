package com.example.bananesexport.domain.services;

import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.inbound.GetCommandsByRecipientUseCase;
import com.example.bananesexport.domain.ports.outbound.GetCommandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GetCommandsByRecipient implements GetCommandsByRecipientUseCase {

    private GetCommandPort getCommandPort;

    @Override
    public List<Command> getCommandsByRecipient(Recipient recipient) {
        return getCommandPort.getCommandsByRecipient(recipient)
                .stream()
                .peek(Command::calculatePrice)
                .toList();
    }
}
