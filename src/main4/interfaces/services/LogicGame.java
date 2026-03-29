package main4.interfaces.services;

import main4.interfaces.model.IGame;

public class LogicGame implements IGame {
    @Override
    public void a() { System.out.println("LogicGame: method a()"); }
    @Override
    public void b() { System.out.println("LogicGame: method b()"); }
    @Override
    public void c() { System.out.println("LogicGame: method c()"); }
    @Override
    public void d() { System.out.println("LogicGame: method d()"); }
}