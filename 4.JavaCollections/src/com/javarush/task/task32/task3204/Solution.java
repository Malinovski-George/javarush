package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Random random = new Random();
        HashSet<Byte> characters = new HashSet<>();

        // digits
        for (int i = 0; i < 3; i++) {
            characters.add((byte)(48 + random.nextInt(10)));
        }

        // lower letters
        for (int i = 0; i < 3; i++) {
            characters.add((byte)(65 + random.nextInt(26)));
        }

        // capital letters
        for (int i = 0; i < 2; i++) {
            characters.add((byte) (97 + random.nextInt(26)));
        }

        for (Byte letter : characters) {
            byteArrayOutputStream.write(letter);
        }

        return byteArrayOutputStream;
    }
}
