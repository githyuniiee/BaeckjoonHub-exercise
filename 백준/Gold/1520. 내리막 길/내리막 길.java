
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int m,n;

    static int[][] arr;
    static int[][] dp;
    static int[] dy = new int[]{-1,0,0,1};
    static int[] dx = new int[]{0,1,-1,0};
    static int count = 0;


    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        dp = new int[m][n];


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));

    }

    static int dfs(int y, int x){

        if(y == m-1 && x == n-1){
            return 1;
        }

        if(dp[y][x] != -1){
            return dp[y][x];
        }

        dp[y][x] = 0;


        for(int i=0; i<4; i++){
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if(0<=ny && ny < m && 0<= nx && nx < n && arr[y][x] > arr[ny][nx]){
                dp[y][x] += dfs(ny,nx);
            }
        }

        return dp[y][x];
    }
}
