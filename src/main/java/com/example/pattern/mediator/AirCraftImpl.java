package com.example.pattern.mediator;

public class AirCraftImpl extends AirCraft {
    public AirCraftImpl(ATCMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println(name + " : Sending message = " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receiveMessage(String msg) {
        System.out.println(name + " : Receiving message = " + msg);
    }
}
