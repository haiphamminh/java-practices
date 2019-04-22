package com.example.pattern.templatemethod.model;

import com.example.pattern.templatemethod.Game;

public class EndlessRunnerGame extends Game {

    @Override
    public void initialize() {
        System.out.println("Endless Runner initializing....");
    }

    @Override
    public void startPlay() {
        System.out.println("Endless Runner starting....");
    }

    @Override
    public void endPlay() {
        System.out.println("Endless Runner ending....");
    }

    // Add more methods...
}
