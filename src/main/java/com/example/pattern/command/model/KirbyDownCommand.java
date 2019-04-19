package com.example.pattern.command.model;

import com.example.pattern.command.interfaces.Command;

public class KirbyDownCommand implements Command {
    private com.example.pattern.command.receiver.KirbyCharacterReceiver receiver;

    public KirbyDownCommand(com.example.pattern.command.receiver.KirbyCharacterReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveDown();
    }
}
