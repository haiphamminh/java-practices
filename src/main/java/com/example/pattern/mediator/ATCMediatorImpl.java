package com.example.pattern.mediator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ATCMediatorImpl implements ATCMediator {
    private List<AirCraft> airCrafts;

    public ATCMediatorImpl() {
        airCrafts = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, AirCraft airCraft) {
        for (AirCraft a : airCrafts) {
            if (a != airCraft) {
                a.receiveMessage(msg);
            }
        }
    }

    @Override
    public void addAirCraft(AirCraft... airCraft) {
        Collections.addAll(airCrafts, airCraft);
    }
}
