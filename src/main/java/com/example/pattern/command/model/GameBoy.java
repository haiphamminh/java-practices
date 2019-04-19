package com.example.pattern.command.model;

import com.example.pattern.command.interfaces.Command;

public class GameBoy {
    private Command upCmd;
    private Command downCmd;
    private Command leftCmd;
    private Command rightCmd;

    public GameBoy(Command upCmd, Command downCmd, Command leftCmd,
                   Command rightCmd) {
        this.upCmd = upCmd;
        this.downCmd = downCmd;
        this.leftCmd = leftCmd;
        this.rightCmd = rightCmd;
    }

    public void arrowUp() {
        upCmd.execute();
    }

    public void arrowDown() {
        downCmd.execute();
    }

    public void arrowLeft() {
        leftCmd.execute();
    }

    public void arrowRight() {
        rightCmd.execute();
    }
}
