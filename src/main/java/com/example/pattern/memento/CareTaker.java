package com.example.pattern.memento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CareTaker {
    private List<Memento> stateList = new ArrayList<>();

    public void addMementos(Memento... mementos) {
        Collections.addAll(stateList, mementos);
    }

    public Memento getMemento(int idx) {
        return stateList.get(idx);
    }
}
