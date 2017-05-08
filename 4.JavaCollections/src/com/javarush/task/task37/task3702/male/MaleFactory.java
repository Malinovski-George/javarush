package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * Created by Gia on 08.05.2017.
 */
public class MaleFactory implements AbstractFactory {

    @Override
    public Human getPerson(int age) {
        if (age <= 12) return new KidBoy();
        return age <= 19 ? new TeenBoy() : new Man();
    }
}
