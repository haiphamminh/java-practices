package com.example.pattern.command;

import com.example.pattern.command.model.GameBoy;
import com.example.pattern.command.model.KirbyDownCommand;
import com.example.pattern.command.model.KirbyLeftCommand;
import com.example.pattern.command.model.KirbyRightCommand;
import com.example.pattern.command.model.KirbyUpCommand;
import com.example.pattern.command.model.MarioDownCommand;
import com.example.pattern.command.model.MarioLeftCommand;
import com.example.pattern.command.model.MarioRightCommand;
import com.example.pattern.command.model.MarioUpCommand;
import com.example.pattern.command.receiver.KirbyCharacterReceiver;
import com.example.pattern.command.receiver.MarioCharacterReceiver;

public class Main {
    public static void main(String[] args) {
        MarioCharacterReceiver marioCharacterReceiver = new MarioCharacterReceiver();
        marioCharacterReceiver.setName("Mario");

        KirbyCharacterReceiver kirbyCharacterReceiver = new KirbyCharacterReceiver();
        kirbyCharacterReceiver.setName("Kirby");

        MarioUpCommand marioUpCommand = new MarioUpCommand(marioCharacterReceiver);
        MarioDownCommand marioDownCommand = new MarioDownCommand(marioCharacterReceiver);
        MarioLeftCommand marioLeftCommand = new MarioLeftCommand(marioCharacterReceiver);
        MarioRightCommand marioRightCommand = new MarioRightCommand(marioCharacterReceiver);

        KirbyUpCommand kirbyUpCommand = new KirbyUpCommand(kirbyCharacterReceiver);
        KirbyDownCommand kirbyDownCommand = new KirbyDownCommand(kirbyCharacterReceiver);
        KirbyLeftCommand kirbyLeftCommand = new KirbyLeftCommand(kirbyCharacterReceiver);
        KirbyRightCommand kirbyRightCommand = new KirbyRightCommand(kirbyCharacterReceiver);

        System.out.println("Playing Mario");
        GameBoy gameBoy = new GameBoy(marioUpCommand, marioDownCommand, marioLeftCommand, marioRightCommand);
        gameBoy.arrowUp();
        gameBoy.arrowDown();
        gameBoy.arrowLeft();
        gameBoy.arrowRight();

        System.out.println("-------------------------------");
        System.out.println("Playing Kirby");
        gameBoy = new GameBoy(kirbyUpCommand, kirbyDownCommand, kirbyLeftCommand, kirbyRightCommand);
        gameBoy.arrowUp();
        gameBoy.arrowDown();
        gameBoy.arrowLeft();
        gameBoy.arrowRight();
    }
}
