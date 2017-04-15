package com.javarush.task.task22.task2202;

/* 
Найти подстроку

Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
«JavaRush — лучший сервис обучения Java.»

Результат:
«— лучший сервис обучения»

На некорректные данные бросить исключение TooShortStringException (сделать исключением).
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("JavaRush-лучший сервис обучения     Java."));
    }

    public static String getPartOfString(String string) {
     if(string == null)throw new TooShortStringException();
         String rezult;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String substring = string;
        while(substring.contains(" ")){
            substring = substring.substring(substring.indexOf(" ")+1);
            count++;
        }
        if (count < 4)
            throw new TooShortStringException();
        String[] strArr = string.split(" ");

        sb.append(strArr[1] + " ");
        sb.append(strArr[2] + " ");
        sb.append(strArr[3] + " ");
        sb.append(strArr[4]);


        rezult = sb.toString();


        return rezult;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
