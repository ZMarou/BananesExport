package com.example.bananesexport.domain.ports.inbound;

import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.model.Recipient;

import java.util.List;

public interface GetCommandsByRecipientUseCase {

    List<Command> getCommandsByRecipient(Recipient recipient);
}
