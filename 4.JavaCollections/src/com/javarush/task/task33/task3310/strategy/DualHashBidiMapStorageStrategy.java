package com.javarush.task.task33.task3310.strategy;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

/**
 * Created by a.zinov on 22.05.2017.
 */
public class DualHashBidiMapStorageStrategy implements StorageStrategy {

    private DualHashBidiMap data;

    public DualHashBidiMapStorageStrategy() {
        data = new DualHashBidiMap();
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
        return (Long) data.getKey(value);
    }

    @Override
    public String getValue(Long key) {
        return (String) data.get(key);
    }
}
