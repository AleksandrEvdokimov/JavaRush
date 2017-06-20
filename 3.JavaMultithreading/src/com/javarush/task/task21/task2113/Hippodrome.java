package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saneok on 18.06.17.
 */
public class Hippodrome {

    private List<Horse> horses;

    static Hippodrome game;

    public Hippodrome (List<Horse> horses) {
        this.horses = horses;
    }

    public List getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses)
            horse.move();
    }

    public void print() {
        for (Horse horse : horses)
            horse.print();
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public  Horse getWinner () {
        Horse winner = horses.get(0);
        for (Horse horse : horses)
            if (horse.getDistance() > winner.getDistance())
                winner = horse;
        return winner;
    }

    public void printWinner () {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        Horse horse1 = new Horse("Sabaka", 3, 0);
        Horse horse3 = new Horse("Chybaka", 3, 0);
        Horse horse2 = new Horse("Ebaka", 3, 0);
        List<Horse> horses = new ArrayList<Horse>();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
