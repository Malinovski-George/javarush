package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable{
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public static void serializeStatic(ObjectOutputStream oos) throws IOException{
            oos.writeObject(staticString);
        }
        public static void deserializeStatic(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            staticString= (String) ois.readObject();
        }


    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ClassWithStatic a = new ClassWithStatic();
        System.out.println(a);
        String path = "serial.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        ClassWithStatic.serializeStatic(oos);
        oos.writeObject(a);
        a = new ClassWithStatic();
        System.out.println(a);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        ClassWithStatic.deserializeStatic(ois);
        a = (ClassWithStatic)ois.readObject();
        System.out.println(a);

    }
}
