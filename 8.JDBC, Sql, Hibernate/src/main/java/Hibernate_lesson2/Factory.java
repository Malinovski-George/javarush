package Hibernate_lesson2;

import Hibernate_lesson2.DAO.BusDAO;
import Hibernate_lesson2.DAO.ImplDAO.BusDAOImpl;

/**
 * Created by Gia on 14.05.2017.
 */
public class Factory {


    private static BusDAO busDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public BusDAO getBusDAO() {
        if (busDAO == null) {
            busDAO = new BusDAOImpl();
        }
        return busDAO;
    }

}

