
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    final static int MAX = 50 + 10;
    static char map[][];
    static boolean visited[][];
    static int m,n;
    static int dirY[] = {-1, -1,-1, 0,0,1,1,1};
    static int dirX[] = {-1, 0, 1, -1, 1,-1,0,1};
    static int answer = 0;

    public static void dfs(int y, int x){

        visited[y][x] = true;

       if(map[y][x] == '-' && map[y][x+1] == '-') dfs(y, x+1);
       if(map[y][x] == '|' && map[y+1][x] == '|') dfs(y+1, x);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken()); // y 7
            m = Integer.parseInt(st.nextToken()); // x 8 가로

            map = new char[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for (int i = 1; i <= n; i++) {
                String str = br.readLine();
                for (int j = 1; j <= m; j++) {
                    map[i][j] = str.charAt(j-1);
                }
            }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(!visited[i][j]){
                    dfs(i,j);
                    answer++;
                }
            }
        }

        System.out.println(answer);


    }



}
