package com.javarush.task.task01.task0130;

/* 
Наш первый конвертер!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertCelsiumToFahrenheit(40));
    }

    public static double convertCelsiumToFahrenheit(int celsium) {
        double Fahrenheit = (celsium * 1.8)+ 32;
        return   Fahrenheit;
        //напишите тут ваш код
    }
}