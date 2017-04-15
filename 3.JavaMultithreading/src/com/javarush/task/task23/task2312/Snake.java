package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gia on 01.03.2017.
 */
public class Snake {

    private SnakeDirection direction;

    private boolean isAlive;

    private List<SnakeSection> sections;


    public SnakeDirection getDirection() {
        return direction;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }


    public Snake(int x, int y) {
        this.sections = new ArrayList<SnakeSection>();
        this.sections.add(new SnakeSection(x, y));
        this.isAlive = true;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }


    /* *
      * Метод перемещает змею на один ход.
      * Направление перемещения задано переменной direction.*/
    public void move() {
        if (!isAlive) return;

        if (direction == SnakeDirection.UP)
            move(0, -1);
        else if (direction == SnakeDirection.RIGHT)
            move(1, 0);
        else if (direction == SnakeDirection.DOWN)
            move(0, 1);
        else if (direction == SnakeDirection.LEFT)
            move(-1, 0);
    }


    /*  * Метод перемещает змею в соседнюю клетку.
      * Кординаты клетки заданы относительно текущей головы с помощью переменных (dx, dy).*/
    public void move(int dx, int dy) {
        //Создаем новую голову - новый "кусочек змеи".

    }


    private void checkBody(SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }


    private void checkBorders(SnakeSection head) {
        if ((head.getX() < 0 || head.getX() >= Room.game.getWidth()) || head.getY() < 0 || head.getY() >= Room.game.getHeight()) {
            isAlive = false;
        }
    }

}