import java.io.*;
import java.util.*;

public class Main {
    static long answer = 0;
    static long a,b;

    public static void gcd(long x, long y){
        while (true) {
            if(x%y == 0){
                answer = y;
                break;
            }

            long temp = x % y;
            x = y;
            y = temp;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());


        if (a > b) {

            gcd(a, b);
        } else {

            gcd(b, a);
        }

        for (int i = 0; i < answer; i++) {
            sb.append(1);
        }

        System.out.println(sb);

        }

}
