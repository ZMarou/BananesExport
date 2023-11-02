package com.example.bananesexport.domain.ports.inbound;

import com.example.bananesexport.domain.model.Command;

public interface CreateCommandUseCase {

    Command createCommand(Command command);
}
