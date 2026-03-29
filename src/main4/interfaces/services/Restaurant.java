package main4.interfaces.services;

import main4.interfaces.model.CanHavePizza;

public class Restaurant {
    public boolean servePizza(CanHavePizza eater) {
        eater.eatPizza();
        if (eater instanceof Person) {
            System.out.println("Processing payment for Person");
        }
        return true;
    }
}