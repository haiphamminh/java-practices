package com.example.pattern.memento;

public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setMemento(Memento memento) {
        state = memento.getState();

    }

    public Memento createMemento() {
        return new Memento(state);
    }
}
