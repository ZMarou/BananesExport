package com.example.bananesexport.infrastructure;

import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.outbound.GetCommandPort;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.bananesexport.infrastructure.Database.commandTable;

@Repository
public class GetCommandAdapter implements GetCommandPort {

    @Override
    public List<Command> getCommandsByRecipient(Recipient recipient) {
        return commandTable.stream().filter(cmd -> cmd.getRecipient().equals(recipient)).toList();
    }
}
