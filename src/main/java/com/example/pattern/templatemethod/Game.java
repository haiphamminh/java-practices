package com.example.pattern.templatemethod;

public abstract class Game {
    protected abstract void initialize();

    protected abstract void startPlay();

    protected abstract void endPlay();

    // template method
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
