package com.example.bananesexport.domain.ports.outbound;

import com.example.bananesexport.domain.model.Recipient;

public interface DeleteRecipientPort {

    void deleteRecipient(Recipient recipient);
}
