package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        double count = 0.0;
        double summ = 0.0;
        while ((i = Integer.parseInt(reader.readLine())) != -1) {
            count++;
            summ += i;
        }

        if (summ > 0) System.out.println(summ/count);

    }
}

