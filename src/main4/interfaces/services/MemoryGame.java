package main4.interfaces.services;

import main4.interfaces.model.Game;

public class MemoryGame implements Game {
    @Override
    public void a() { System.out.println("MemoryGame: method a()"); }
    @Override
    public void b() { System.out.println("MemoryGame: method b()"); }
    @Override
    public void c() { System.out.println("MemoryGame: method c()"); }
}