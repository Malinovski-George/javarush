package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Добавим определение победителя.
 * В классе Hippodrome сделаем два метода:
 * public Horse getWinner() и public void printWinner()
 * <p>
 * Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
 * Метод printWinner выводит на экран имя победителя в виде: Winner is <name>!
 * <p>
 * Пример:
 * Winner is Lucky!
 */
public class Hippodrome {

    public Hippodrome() {
    }

    static Hippodrome game;

    public Hippodrome(List list) {

        this.horses = list;
    }

    private List<Horse> horses = new ArrayList<Horse>();

   Horse winHorse;

    public void run() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            Thread.sleep(200);
            move();
            print();
        }
    }

    public void move() {

        for (Horse horse : horses
                ) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses
                ) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }


    public List getHorses() {
        return horses;
    }

    public Horse getWinner() {
        double max = 0;
        for (Horse horse : horses
                ) {
            if (max < horse.distance)
                max = horse.distance;
        }
        winHorse = null;
        for (Horse horse : horses
                ) {
            if (max == horse.distance)
                winHorse = horse;
        }

        return winHorse;
    }

    public void printWinner() {
        System.out.println(String.format("Winner is %s!",getWinner().getName()));
    }

    public static void main(String[] args) throws InterruptedException {
        Hippodrome.game = new Hippodrome();

        Horse h1 = new Horse("1", 3, 0);
        Horse h2 = new Horse("2", 3, 0);
        Horse h3 = new Horse("3", 3, 0);


        Hippodrome.game.getHorses().add(h1);
        Hippodrome.game.getHorses().add(h2);
        Hippodrome.game.getHorses().add(h3);

        game.run();

        Horse winHorse = game.getWinner();
        game.printWinner();

    }
}
