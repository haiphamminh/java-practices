package com.example.pattern.mediator;

public class Main {
    public static void main(String[] args) {
        ATCMediator atcMediator = new ATCMediatorImpl();

        // Create a few aircrafts
        AirCraft boeing1 = new AirCraftImpl(atcMediator, "Boeing 1");
        AirCraft helicopter = new AirCraftImpl(atcMediator, "Helicopter");
        AirCraft boeing707 = new AirCraftImpl(atcMediator, "Boeing 707");
        atcMediator.addAirCraft(boeing1, helicopter, boeing707);

        boeing1.sendMessage("Hello from Boeing 1");
    }
}
