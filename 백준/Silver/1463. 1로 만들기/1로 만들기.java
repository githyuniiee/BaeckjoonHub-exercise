import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

    public static int d[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        d = new int[number + 1];

        d[1] = 0;
        for (int i = 2; i < number + 1; i++) {

            d[i] = d[i-1] + 1;
            if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                d[i] = d[i/2]+ 1;
            }
            if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                d[i] = d[i/3] + 1;
            }
        }
        System.out.println(d[number]);


    }
}
