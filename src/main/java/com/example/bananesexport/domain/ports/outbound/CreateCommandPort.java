package com.example.bananesexport.domain.ports.outbound;

import com.example.bananesexport.domain.model.Command;

public interface CreateCommandPort {

    Command createCommand(Command command);
}
