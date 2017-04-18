package com.javarush.task;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Gia on 03.04.2017.
 */


    public class Solution implements Comparator{
        public static void main(String[] args) {
            System.out.println(sumDigitsInNumber(546));
        }

        public static int sumDigitsInNumber(int number) {
            //напишите тут ваш код

      int  a = (number - number%100)/100;
            int  b = (number - number%10 - a*100)/10;
             int  c = (number - a*100 - b*10);

            AtomicInteger ii = new AtomicInteger(1);
            int i = ii.addAndGet(1);


            return i;
        }

    //@Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}


