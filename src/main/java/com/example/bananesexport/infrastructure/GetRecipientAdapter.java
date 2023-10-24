package com.example.bananesexport.infrastructure;

import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.outbound.GetRecipientPort;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.bananesexport.infrastructure.Database.recipientTable;

@Repository
public class GetRecipientAdapter implements GetRecipientPort {

    @Override
    public Recipient getRecipient(Recipient recipient) {
        return recipientTable.stream().filter(rec -> rec.equals(recipient)).findFirst().orElse(null);
    }

    @Override
    public List<Recipient> getAllRecipient() {
        return recipientTable;
    }
}
