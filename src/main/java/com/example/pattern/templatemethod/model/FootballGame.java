package com.example.pattern.templatemethod.model;

import com.example.pattern.templatemethod.Game;

public class FootballGame extends Game {

    @Override
    public void initialize() {
        System.out.println("Football Game initializing....");
    }

    @Override
    public void startPlay() {
        System.out.println("Football Game starting....");
    }

    @Override
    public void endPlay() {
        System.out.println("Football Game ending....");
    }
}
