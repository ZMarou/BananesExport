package com.example.bananesexport.domain.ports.outbound;

import com.example.bananesexport.domain.model.Recipient;

import java.util.List;
import java.util.Optional;

public interface GetRecipientPort {

    Optional<Recipient> getRecipient(Recipient recipient);
    List<Recipient> getAllRecipient();
}
