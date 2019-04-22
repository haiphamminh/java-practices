package com.example.pattern.facade;

public class Main {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade(new CPU(), new Memory(), new HardDrive());
        computerFacade.start();
    }
}
