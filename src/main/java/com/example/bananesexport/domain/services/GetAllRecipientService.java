package com.example.bananesexport.domain.services;

import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.inbound.GetAllRecipientUseCase;
import com.example.bananesexport.domain.ports.outbound.GetRecipientPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GetAllRecipientService implements GetAllRecipientUseCase {

    private GetRecipientPort getRecipientPort;
    @Override
    public List<Recipient> getAllRecipient() {
        return getRecipientPort.getAllRecipient();
    }
}
