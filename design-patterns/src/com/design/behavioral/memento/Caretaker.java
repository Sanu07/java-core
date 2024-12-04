package com.design.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    private List<Memento> mementos = new ArrayList<>();

    public void saveState(Memento memento) {
        mementos.add(memento);
    }

    public Memento restoreState(int index) {
        return mementos.get(index);
    }
}
