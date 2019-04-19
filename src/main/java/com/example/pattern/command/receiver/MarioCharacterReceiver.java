package com.example.pattern.command.receiver;

public class MarioCharacterReceiver {
    private String name;

    public void moveUp() {
        System.out.println(name + " moving up");
    }

    public void moveDown() {
        System.out.println(name + " moving down");
    }

    public void moveLeft() {
        System.out.println(name + " moving left");
    }

    public void moveRight() {
        System.out.println(name + " moving right");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
