package com.javarush.task.task35.task3512;

import java.lang.reflect.InvocationTargetException;

public class Generator<T> {

    Class<T> clas;

    public Generator(Class<T> clas) {
        this.clas = clas;
    }

    T newInstance() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return clas.getConstructor().newInstance();
    }
}
