package com.javarush.task.task25.task2515;

/**
 * Created by Gia on 30.04.2017.
 */
public class Canvas {

    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setPoint(double x, double y, char c) {

        int xInt = (int) Math.round(x);
        int yInt = (int) Math.round(y);
        if (!(xInt < 0 || yInt < 0 || yInt >= matrix.length || xInt >= matrix[0].length)) {
            matrix[yInt][xInt] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }

    public void clear() {
        this.matrix = new char[height][width];
    }


    public void print() {
        System.out.println();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(" ");
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();
    }
}


