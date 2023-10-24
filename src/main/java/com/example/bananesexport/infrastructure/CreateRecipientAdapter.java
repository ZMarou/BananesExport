package com.example.bananesexport.infrastructure;

import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.outbound.CreateRecipientPort;
import org.springframework.stereotype.Repository;

import static com.example.bananesexport.infrastructure.Database.recipientTable;

@Repository
public class CreateRecipientAdapter implements CreateRecipientPort {

    @Override
    public void createRecipient(Recipient recipient) {
        recipientTable.add(recipient);
    }
}
