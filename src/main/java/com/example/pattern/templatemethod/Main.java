package com.example.pattern.templatemethod;

import com.example.pattern.templatemethod.model.EndlessRunnerGame;
import com.example.pattern.templatemethod.model.FootballGame;

public class Main {
    public static void main(String[] args) {
        Game footballGame = new FootballGame();
        footballGame.play();

        System.out.println("============");

        Game endlessRunnerGame = new EndlessRunnerGame();
        endlessRunnerGame.play();
    }
}
