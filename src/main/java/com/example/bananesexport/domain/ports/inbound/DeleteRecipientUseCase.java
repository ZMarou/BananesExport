package com.example.bananesexport.domain.ports.inbound;

import com.example.bananesexport.domain.exception.RecipientException;
import com.example.bananesexport.domain.model.Recipient;

public interface DeleteRecipientUseCase {

    void deleteRecipient(Recipient recipient) throws RecipientException;
}
