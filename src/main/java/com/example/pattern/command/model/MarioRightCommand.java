package com.example.pattern.command.model;

import com.example.pattern.command.interfaces.Command;
import com.example.pattern.command.receiver.MarioCharacterReceiver;

public class MarioRightCommand implements Command {
    private MarioCharacterReceiver receiver;

    public MarioRightCommand(MarioCharacterReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveRight();
    }
}
