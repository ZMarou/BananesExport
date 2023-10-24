package com.example.bananesexport.domain.ports.inbound;

import com.example.bananesexport.domain.exception.DeliveryDateException;
import com.example.bananesexport.domain.exception.QuantityException;
import com.example.bananesexport.domain.exception.RecipientException;
import com.example.bananesexport.domain.model.Command;

public interface CreateCommandUseCase {

    Command createCommand(Command command) throws DeliveryDateException, QuantityException, RecipientException;
}
