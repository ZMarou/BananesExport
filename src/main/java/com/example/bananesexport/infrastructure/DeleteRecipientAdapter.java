package com.example.bananesexport.infrastructure;

import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.outbound.DeleteRecipientPort;
import org.springframework.stereotype.Repository;

import static com.example.bananesexport.infrastructure.Database.recipientTable;

@Repository
public class DeleteRecipientAdapter implements DeleteRecipientPort {

    @Override
    public void deleteRecipient(Recipient recipient) {
        recipientTable.remove(recipient);
    }
}
