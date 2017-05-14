package Hibernate_lesson2;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Gia on 14.05.2017.
 */
public class Main {
    public static void main(String[] args) throws SQLException {

        Collection busses = Factory.getInstance().getBusDAO().getAllBusses();
        Iterator iterator = busses.iterator();
        System.out.println("========Все автобусы=========");
        while (iterator.hasNext()) {
            Bus bus = (Bus) iterator.next();
            busses = Factory.getInstance().getBusDAO().getAllBusses();
            Iterator iterator2 = busses.iterator();
            System.out.println("Автобус № " + bus.getNumber());


        }
    }

}


