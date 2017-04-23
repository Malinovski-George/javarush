package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString().length() + "   " + password.toString());
        }
    }

    public static ByteArrayOutputStream getPassword() {

        ByteArrayOutputStream byteArrayOutputStream;
        do {
            byteArrayOutputStream = new ByteArrayOutputStream();
            Random random = new Random();
            HashSet<Byte> characters = new HashSet<>();


            for (int i = 0; i < 3; i++) {
                byte digits = (byte) (48 + random.nextInt(10));
                characters.add(digits);
             //   System.out.print(digits + ".");
            }


            for (int i = 0; i < 3; i++) {
                byte lowerLetters = (byte) (65 + random.nextInt(26));
                characters.add(lowerLetters);
            //    System.out.print(lowerLetters + ".");
            }


            for (int i = 0; i < 2; i++) {
                byte capitalLetters = (byte) (97 + random.nextInt(26));
                characters.add(capitalLetters);
            //    System.out.print(capitalLetters + ".");
            }
            int count = 0;
            for (Byte letter : characters) {
                if (count < 8) {
                    byteArrayOutputStream.write(letter);
                    count++;

                }
            }
          //  System.out.println();
          //  System.out.println(byteArrayOutputStream.size());
        } while (byteArrayOutputStream.size() != 8);

        return byteArrayOutputStream;
    }
}
