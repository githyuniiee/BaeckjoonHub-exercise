import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    static int a,b;

    public static void lcm(int x, int y){
        while (true) {
            if(x%y == 0){
                int num = y;
                answer = (a/num) * (b/num) * num;
                break;
            }

            int temp = x % y;
            x = y;
            y = temp;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a > b) {
                lcm(a,b);
            }else{

                lcm(b,a);
            }

            System.out.println(answer);
        }


    }
}
