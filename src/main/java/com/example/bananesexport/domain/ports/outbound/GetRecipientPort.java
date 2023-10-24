package com.example.bananesexport.domain.ports.outbound;

import com.example.bananesexport.domain.model.Recipient;

import java.util.List;

public interface GetRecipientPort {

    Recipient getRecipient(Recipient recipient);
    List<Recipient> getAllRecipient();
}
