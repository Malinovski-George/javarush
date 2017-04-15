package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!

Инициализируй поле wheels используя данные из loadWheelNamesFromDB.
Выкинь исключение в случае некорректных данных.

Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new ArrayList<>();

            Set<String> set = new HashSet<>();

            for (String s : loadWheelNamesFromDB()
                    ) {
                set.add(s);
                System.out.println(set.isEmpty());
            }

            for (String wheel : loadWheelNamesFromDB()
                    ) {

                if (loadWheelNamesFromDB().length == 4 && Wheel.valueOf(wheel).toString() == wheel && set.contains(wheel) && !set.isEmpty()) {
                    try {

                        System.out.println(loadWheelNamesFromDB());
                        System.out.println(wheel);
                        System.out.println(set.size());
                        System.out.println(set.isEmpty());

                        wheels.add(Wheel.valueOf(wheel));
                        set.remove(wheel);

                    } catch (IllegalArgumentException e) {

                    }

                } else throw new IllegalArgumentException();
            }
            if (wheels.size() == 0)throw new IllegalArgumentException();
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{};

        }
    }

    public static void main(String[] args) {
Car car = new Car();
        for (Wheel s : car.wheels
                ) {
            System.out.println(s.toString());
            System.out.println(car.wheels.size());
        }
        System.out.println(car.wheels.size());
    }
}
