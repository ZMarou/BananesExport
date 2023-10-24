package com.example.bananesexport.infrastructure;

import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.ports.outbound.CreateCommandPort;
import org.springframework.stereotype.Repository;

import static com.example.bananesexport.infrastructure.Database.commandTable;

@Repository
public class CreateCommandAdapter implements CreateCommandPort {

    @Override
    public Command createCommand(Command command) {
        commandTable.add(command);
        return command;
    }
}
