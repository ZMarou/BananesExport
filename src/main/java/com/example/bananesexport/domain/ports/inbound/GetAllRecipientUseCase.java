package com.example.bananesexport.domain.ports.inbound;

import com.example.bananesexport.domain.model.Recipient;

import java.util.List;

public interface GetAllRecipientUseCase {

    List<Recipient> getAllRecipient();
}
