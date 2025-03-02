import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] map;
    static int[][][] dp;
    static int minCost = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m][3]; //0왼쪽 대각선, 1아래, 2오른쪽 대각선

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(i==0){
                    dp[i][j][0] = map[i][j];
                    dp[i][j][1] = map[i][j];
                    dp[i][j][2] = map[i][j];
                }

                if(j==m-1){
                    //왼쪽에서 오는 경우 없음
                    dp[i][j][0] = Integer.MAX_VALUE;
                }

                if(j==0){
                    //오른쪽에서 오는 경우 없음
                    dp[i][j][2] = Integer.MAX_VALUE;
                }   
            }
        }

        solution();
        System.out.println(minCost);


    }

    static void solution(){
        
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){

                if (isValid(i - 1, j + 1))
					dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + map[i][j];

				if (isValid(i - 1, j))
					dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + map[i][j];

				if (isValid(i - 1, j - 1))
					dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + map[i][j];
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<3; j++){
                minCost = Math.min(minCost, dp[n-1][i][j]);
            }
        }
    }

    static boolean isValid(int y, int x){
        if(0<=y && y< n && 0<=x && x<m){
            return true;
        }

        return false;
    }



}