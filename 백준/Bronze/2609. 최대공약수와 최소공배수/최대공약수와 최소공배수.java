import java.io.*;
import java.util.*;

public class Main {
    static int answer1,answer2 = 0;
    static int a,b;

    public static void gcd(int x, int y){
        while (true) {
            if(x%y == 0){
                answer1 = y;
                answer2 = (a / answer1) * (b / answer1) * answer1;
                break;
            }

            int temp = x % y;
            x = y;
            y = temp;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if (a > b) {

            gcd(a, b);
        } else {

            gcd(b, a);
        }


        System.out.println(answer1);
        System.out.println(answer2);
        }
        
}
