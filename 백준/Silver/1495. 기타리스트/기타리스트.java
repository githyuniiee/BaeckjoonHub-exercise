import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, s, m;
    static int[] change;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        change = new int[n];
        dp = new boolean[n+1][m+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            change[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][s] = true;

        for(int i=0; i<n; i++){
            for(int v = 0; v<=m; v++){
                if(dp[i][v]){
                    if (v + change[i] <= m) {  
                        dp[i + 1][v + change[i]] = true;
                    }
                    if (v - change[i] >= 0) {  
                        dp[i + 1][v - change[i]] = true;
                    }
                }
            }
        }

        int answer = -1;
        for(int v = m; v>=0; v--){
            if(dp[n][v]){
                answer = v;
                break;
            }
        }

        System.out.println(answer);

        
    }

   
}
