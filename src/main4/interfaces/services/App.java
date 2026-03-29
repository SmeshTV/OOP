package main4.interfaces.services;

import main4.interfaces.model.Game;

public class App {
    public void getStatistics(Game g) {
        System.out.println("Getting statistics for game: " + g.getClass().getSimpleName());
        g.a();
        g.b();
        g.c();
    }
}