package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.

Пример
getTokens("level22.lesson13.task01", ".")

Возвращает
{"level22", "lesson13", "task01"}

*/
public class Solution {
    public static void main(String[] args) {


getTokens("sda","asd");

    }
    public static String [] getTokens(String query, String delimiter) {



        ArrayList<String> delimeterStrings = new ArrayList<String>();
        StringTokenizer tokenizer =
                new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()) {
            delimeterStrings.add(tokenizer.nextToken());

        }


        String[] resultString = new String[delimeterStrings.size()];

int i = 0;
        for (String s : delimeterStrings
             ) {
            resultString[i] = s;
            i++;

        }


        return resultString;
    }
}
