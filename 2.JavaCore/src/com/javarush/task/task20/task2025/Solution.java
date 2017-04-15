package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import static java.lang.Integer.MAX_VALUE;

/*
Алгоритмы-числа
Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static void main(String[] args) {
        int number = 1000000;
        long freeMemory = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();
        long[] a = getNumbers(number);
        long memoryAfterCalculate = Runtime.getRuntime().freeMemory();
        long delta = memoryAfterCalculate - freeMemory;
        long stopTime = System.currentTimeMillis();
        System.out.println("Calculating time: " + (stopTime - startTime));
        System.out.println("Used JVM memory: " + delta);
        for (long i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static long[] getNumbers(long N) {
        Vector<Integer> v = new Vector<>();
        for (int i = 1; i < N; i++) {
            if (checkFormula(i)) v.add(i);
        }
        long[] result = new long[v.size()];
        for (int i = 0; i < v.size(); i++) {
            result[i] = v.get(i);
        }
        return result;
    }

    public static boolean checkFormula(int number) {
        if (number == 0) return false;
        else if (number >= 1 && number < 10) return true;
        int     rest = number,
                sum = 0,
                digit = 0,
                digitCount = 1 + (int) Math.log10(number);
        for (int i = 0; i < digitCount; i++) {
            digit = rest % 10;
            rest = rest / 10;
            int prod = digit;
            for (int j = 1; j < digitCount; j++) {
                prod *= digit;
            }
            sum += prod;
        }
        if (sum == number)
            return true;
        else
            return false;
    }
}



/*
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        ArrayList<Long> list = new ArrayList<Long>();
        for (int i = 1; i < N; i++) {

            if (whoIsAmstrongNumber(i)) {
                list.add((long) i);

            }
        }
        result = new long[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }

    public static byte countAmstNum(int ArmstrongNumber) {
        byte i = 0;
        //int temp=0;
        //Проверяем сколько цифр в числе

        //for(byte i=0;i<;)
        if (ArmstrongNumber > 0)
            while (ArmstrongNumber != 0) {
                ArmstrongNumber = ArmstrongNumber / 10;
                i++;
            }
        //System.out.println(i);
        return i;
    }

    public static boolean whoIsAmstrongNumber(int ArmstrongNumber)

    {
        int drob = 0;

        int result = 0;
        int orig = ArmstrongNumber;
        byte count = countAmstNum(ArmstrongNumber);

        while (ArmstrongNumber != 0) {
//выделяем поледнюю цифру в числе
            int stepen = 1;
            drob = ArmstrongNumber % 10;

            if (count > 1)
            for (int i = 0; i < count; i++) {
                stepen = stepen*drob;
            }

            result = result + stepen;
            ArmstrongNumber = ArmstrongNumber / 10;
        }

        if (orig == result) return true;

        return false;

    }


    public static void main(String[] args) {
        long startMemory = Runtime.getRuntime().totalMemory();
        long startTime = System.currentTimeMillis();

        long[] rezult = getNumbers(1_000_000_000);


        System.out.println("использовано памяти: " + (-startMemory + Runtime.getRuntime().totalMemory()));
        System.out.println("заняло времени: " + (-startTime + System.currentTimeMillis()));

        for (Long i : rezult) {
            System.out.println(i);
        }

    }
}
*/
