package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by a.zinov on 22.05.2017.
 */
public class HashMapStorageStrategy implements StorageStrategy {

    private HashMap<Long, String> data;

    public HashMapStorageStrategy() {
        data = new HashMap<>();
    }

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {

        Set<Long> collection = data.keySet();
        for (Long key : collection) {
            String s = data.get(key);
            if (key != null){
                if (s.equals(value)){
                    return key;
                }
            }
        }

        return null;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
