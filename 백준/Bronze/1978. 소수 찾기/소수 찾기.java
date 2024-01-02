import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {

            //소수인 경우 true, 아닌 경우 false
            boolean isPrime = true;
            int num = Integer.parseInt(st.nextToken());

            if (num == 1) { //1인 경우 다음 반복문
                 continue;
            }
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    isPrime = false; //소수가 아니므로 false
                    break;
                }
            }
            if (isPrime) { //소수인경우 count 값 1 증가
                count++;
            }
        }
        System.out.println(count);
    }
}
