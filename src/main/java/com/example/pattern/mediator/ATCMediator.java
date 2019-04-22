package com.example.pattern.mediator;

public interface ATCMediator {
    void sendMessage(String msg, AirCraft airCraft);

    void addAirCraft(AirCraft... airCraft);
}
