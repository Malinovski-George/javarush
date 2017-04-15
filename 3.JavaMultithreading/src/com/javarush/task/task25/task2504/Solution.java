package com.javarush.task.task25.task2504;

/* 
Switch для нитей


Обработай список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запусти ее.
2. Если нить в ожидании, то прерви ее.
3. Если нить работает, то проверь маркер isInterrupted.
4. Если нить прекратила работу, то выведи в консоль ее приоритет.
Используй switch.

*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод\
        for (Thread t : threads
                ) {
            switch (t.getState().toString()) {
                case "NEW":
                    t.start();
                    break;
                case "RUNNABLE":
                    t.isInterrupted();
                    break;
                case "BLOCKED":
                    t.interrupt();
                    break;
                case "TIMED_WAITING":
                    t.interrupt();
                    break;
                case "WAITING":
                    t.interrupt();
                    break;
                case "TERMINATED":
                    System.out.println(t.getPriority());
                    break;
            }

        }
    }

    public static void main(String[] args) {
    }
}
