package com.example.pattern.command.model;

import com.example.pattern.command.interfaces.Command;
import com.example.pattern.command.receiver.KirbyCharacterReceiver;

public class KirbyLeftCommand implements Command {
    private KirbyCharacterReceiver receiver;

    public KirbyLeftCommand(KirbyCharacterReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveLeft();
    }
}
