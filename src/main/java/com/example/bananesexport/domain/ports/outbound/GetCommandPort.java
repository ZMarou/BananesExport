package com.example.bananesexport.domain.ports.outbound;

import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.model.Recipient;

import java.util.List;

public interface GetCommandPort {

    List<Command> getCommandsByRecipient(Recipient recipient);
}
