package com.example.bananesexport.infrastructure;

import com.example.bananesexport.domain.model.Command;
import com.example.bananesexport.domain.model.Recipient;

import java.util.ArrayList;
import java.util.List;

public final class Database {

    public static List<Recipient> recipientTable = new ArrayList<>();
    public static List<Command> commandTable = new ArrayList<>();
}
