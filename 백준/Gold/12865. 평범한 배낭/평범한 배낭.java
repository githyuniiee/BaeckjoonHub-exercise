
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        int[][] dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            weight[i] = w;
            value[i] = v;

        }

        for(int i=1; i<=n; i++){

            for(int j=1; j<=k; j++){

                //담을 수 X
                if(weight[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    //담을 수 O
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[n][k]);




        

    }
}
