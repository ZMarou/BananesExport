package com.example.bananesexport.domain.services;

import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.model.Price;
import com.example.bananesexport.domain.model.Recipient;
import com.example.bananesexport.infrastructure.adapter.CreateCommandAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateCommandServiceTest {

    public static final Price PRICE_PER_KILO = new Price(BigDecimal.TEN);
    public static final Recipient RECIPIENT = new Recipient("Dupont", "avenue charles de gaulle", "75008", "Paris", "France");
    public static final LocalDate DELIVERY_DATE = LocalDate.now().plusDays(9);

    @InjectMocks
    private CreateCommandService createCommandService;

    @Mock
    private CreateCommandAdapter createCommandPort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_create_command_when_recipient_exits() {
        Command cmd = new Command(UUID.randomUUID(), DELIVERY_DATE, 25, PRICE_PER_KILO, RECIPIENT);
        when(createCommandPort.createCommand(any())).thenReturn(cmd);
        Command result = createCommandService.createCommand(cmd);
        assertNotNull(result);
        assertNotEquals(0, result.getId());
        assertEquals(0, BigDecimal.valueOf(250L).compareTo(result.getPrice().value()));
        verify(createCommandPort, times(1)).createCommand(any());
    }
}
