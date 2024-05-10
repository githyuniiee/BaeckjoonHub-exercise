import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    final static int MAX = 1000 + 10;
    static boolean map[][];
    static boolean visited[][];
    static int n,m;
    static int dirY[] = {-1, 1, 0, 0};
    static int dirX[] = {0, 0, -1, 1};
    static boolean answer;

    public static void dfs(int y, int x){

        if(y == n){
            answer = true;
            return;
        }
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {

            int nY = y + dirY[i];
            int nX = x + dirX[i];

            if (!visited[nY][nX] && map[nY][nX]) {
                dfs(nY, nX);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = (str.charAt(j - 1) == '0') ? true : false;
            }
        }

        //dfs 수정
        for (int j = 1; j <= m; j++) {
            if (map[1][j]) {
                dfs(1, j);
            }
        }

        if (answer) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }






    }



}







