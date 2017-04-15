package com.javarush.task.task22.task2203;

/* 
Между табуляциями

Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        if(string == null)throw new TooShortStringException();
        String rezult;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String substring = string;
        while(substring.contains("\t")){
            substring = substring.substring(substring.indexOf("\t")+1);
            count++;
        }
        if (count < 2)
            throw new TooShortStringException();
        String[] strArr = string.split("\t");

        sb.append(strArr[1]);
        rezult = sb.toString();
        return rezult;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
