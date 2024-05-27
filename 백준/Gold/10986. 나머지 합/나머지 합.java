import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0L;

        int len = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] sumArr = new int[m];
        int sum = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < len; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % m;
            sumArr[sum]++;
        }

        answer = sumArr[0];
        for (int i = 0; i < m; i++) {
            answer += (long) sumArr[i] * (sumArr[i] -1 ) /2;
        }
        System.out.println(answer);
    }
}
