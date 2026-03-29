package main4.interfaces.services;

import main4.interfaces.model.CanHavePizza;
import main4.interfaces.model.CanHaveRetake;
import main4.interfaces.model.Movable;

public class Student extends Person implements CanHavePizza, CanHaveRetake, Movable {
    @Override
    public void eatPizza() {
        System.out.println("Student is eating pizza during break");
    }

    @Override
    public void retakeExam() {
        System.out.println("Student is taking retake exam");
    }

    @Override
    public void move() {
        System.out.println("Student is moving to the next lecture");
    }

    @Override
    public void dance() {
        System.out.println("Student is dancing at the party");
    }
}