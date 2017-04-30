package com.javarush.task.task25.task2515;

/**
 * Created by Gia on 30.04.2017.
 */
public class Bomb extends BaseObject {
    public Bomb(double x, double y) {
        super(x, y, 1);
    }

    public void move() {
        setY(getY() + 1);
    }

    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'B');
    }
}
