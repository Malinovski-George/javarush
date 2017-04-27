package com.javarush.task.task22.task2213;

/**
 * Created by Gia on 27.04.2017.
 */
public class Field {

    private int width;
    private int height;

    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;

        matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    void print() {

    }

    void removeFullLines() {

    }

    Integer getValue(int x, int y) {
        return matrix[y][x];
    }

    void setValue(int x, int y, int value) {

    }


}
