package com.example.bananesexport.application;

import com.example.bananesexport.domain.exception.DeliveryDateException;
import com.example.bananesexport.domain.exception.QuantityException;
import com.example.bananesexport.domain.exception.RecipientException;
import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.inbound.CreateCommandUseCase;
import com.example.bananesexport.domain.ports.inbound.GetCommandsByRecipientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/commands")
@AllArgsConstructor
public class CommandController {

    private final CreateCommandUseCase createCommandUseCase;
    private final GetCommandsByRecipientUseCase getCommandsByRecipientUseCase;

    @PostMapping
    public ResponseEntity<String> createCommand(@Valid @RequestBody Command command) {
        try {
            Command cmd = createCommandUseCase.createCommand(command);
            return ResponseEntity.ok().body(cmd.toString());
        } catch (DeliveryDateException | QuantityException | RecipientException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Command>> getCommandsByRecipient(@Valid @RequestBody Recipient recipient) {
        return ResponseEntity.ok().body(getCommandsByRecipientUseCase.getCommandsByRecipient(recipient));
    }
}
