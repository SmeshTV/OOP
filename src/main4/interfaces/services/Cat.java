package main4.interfaces.services;

import main4.interfaces.model.CanHavePizza;

public class Cat implements CanHavePizza {
    @Override
    public void eatPizza() {
        System.out.println("Cat is eating pizza with pleasure! Meow~");
    }
}