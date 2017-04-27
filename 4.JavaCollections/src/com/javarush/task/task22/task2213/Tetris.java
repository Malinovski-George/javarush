package com.javarush.task.task22.task2213;

/**
 * Created by Gia on 27.04.2017.
 */
public class Tetris {

    public static Tetris game;

    private Field field;

    public Figure getFigure() {
        return figure;
    }

    public Field getField() {
        return field;
    }

    private Figure figure;


    public static void main(String[] args) {

        game = new Tetris();
        game.run();
    }

    public void run() {
    }

    public void step() {

    }
}
