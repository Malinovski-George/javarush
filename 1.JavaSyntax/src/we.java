import java.util.ArrayList;

/**
 * Created by Gia on 02.03.2017.
 */
public class we {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            System.out.print(i + " : ");
            list.add(i);
            int sleep = getSleep(i);
            System.out.println(sleep);
        }
    }

    public static int getSleep(int i) {

        int sleep = 0;

            sleep = 500 - (200 * (i - 1) / 9);

        return sleep;
    }

}

