package com.example.pattern.command.model;

import com.example.pattern.command.interfaces.Command;

public class KirbyUpCommand implements Command {
    private com.example.pattern.command.receiver.KirbyCharacterReceiver receiver;

    public KirbyUpCommand(com.example.pattern.command.receiver.KirbyCharacterReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveUp();
    }
}
