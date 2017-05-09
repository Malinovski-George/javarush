package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gia on 09.05.2017.
 */
public class Model {

    public List<String> getStringDataList() {
        return new Service().getData();
    }

}
