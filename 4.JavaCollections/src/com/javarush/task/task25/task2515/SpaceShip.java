package com.javarush.task.task25.task2515;

/**
 * Created by Gia on 30.04.2017.
 */
public class SpaceShip extends BaseObject {

    private double dx;

    public SpaceShip(double x, double y) {
        super(x, y, 3);
        dx = 0;
    }

    public void moveLeft() {
        dx = -1;
    }

    public void moveRight() {
        dx = 1;
    }

    public void move() {
        x = x + dx;
        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() + 1);
    }

    public void draw(Canvas canvas) {

    }

    public void fire() {
        Space.game.getRockets().add(new Rocket(x - 2, y));
        Space.game.getRockets().add(new Rocket(x + 2, y));
    }
}
