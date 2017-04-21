import java.io.BufferedReader;
import java.io.InputStreamReader;

public class we {
    public static void main(String[] args) throws Exception { //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        double b = 0;
        double k = 0;
        while (a != -1) {
            a = Integer.parseInt(br.readLine());
            b += a;
            k += 1;
        }
        b = b + 1;
        k = b / (k - 1);
        System.out.println(k);
    }
}