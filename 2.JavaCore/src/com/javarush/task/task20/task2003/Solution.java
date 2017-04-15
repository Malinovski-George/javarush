package com.javarush.task.task20.task2003;

/*Знакомство с properties
        В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
        Про .properties почитать тут — http://ru.wikipedia.org/wiki/.properties
        Реализуй логику записи в файл и чтения из файла для карты properties.*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties props = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream is = new FileInputStream(reader.readLine());
        load(is);
        reader.close();


    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        for (Map.Entry<String, String> entry: properties.entrySet()
             ) {
            props.put(entry.getKey(), entry.getValue());
                    }
        props.store(outputStream, "");


    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        props.load(inputStream);
        Set<String> list = props.stringPropertyNames();
        for (String str : list)
            properties.put(str, props.getProperty(str));
    }

    public static void main(String[] args) {

    }
}
