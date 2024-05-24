import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[31][31];

        for (int i = 1; i <= 30; i++) {
            dp[i][i] = 1;
            dp[1][i] = i;
        }

        for (int i = 2; i <= 30; i++) {
            for (int j = 1; j <= 30; j++) {
                if(i==j){
                    continue;
                }
                dp[i][j] = dp[i-1][j - 1] + dp[i][j-1];
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(dp[a][b]);
        }






    }

}