package main4.interfaces.services;

import main4.interfaces.model.SellableAndPluggable;

public class iPhone implements SellableAndPluggable {
    @Override
    public void sell() {
        System.out.println("iPhone is being sold");
    }

    @Override
    public void plug() {
        System.out.println("iPhone is being plugged in");
    }
}