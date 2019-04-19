package com.example.pattern.command.model;

import com.example.pattern.command.interfaces.Command;

public class MarioDownCommand implements Command {
    private com.example.pattern.command.receiver.MarioCharacterReceiver receiver;

    public MarioDownCommand(com.example.pattern.command.receiver.MarioCharacterReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveDown();
    }
}
