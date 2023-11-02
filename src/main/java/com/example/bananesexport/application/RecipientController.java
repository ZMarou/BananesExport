package com.example.bananesexport.application;

import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.domain.ports.inbound.CreateRecipientUseCase;
import com.example.bananesexport.domain.ports.inbound.DeleteRecipientUseCase;
import com.example.bananesexport.domain.ports.inbound.GetAllRecipientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/recipients")
@AllArgsConstructor
public class RecipientController {

    private final CreateRecipientUseCase createRecipientUseCase;
    private final DeleteRecipientUseCase deleteRecipientUseCase;
    private final GetAllRecipientUseCase getAllRecipientUseCase;

    @PostMapping
    public ResponseEntity<String> createRecipient(@Valid @RequestBody Recipient recipient) {
        createRecipientUseCase.createRecipient(recipient);
        return ResponseEntity.ok().body("OK");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRecipient(@Valid @RequestBody Recipient recipient) {
        deleteRecipientUseCase.deleteRecipient(recipient);
        return ResponseEntity.ok().body("OK");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Recipient>> getAllRecipient() {
        return ResponseEntity.ok().body(getAllRecipientUseCase.getAllRecipient());
    }
}
