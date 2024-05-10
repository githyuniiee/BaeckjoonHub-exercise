
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    final static int MAX = 3 + 10;
    static int map[][];
    static boolean visited[][];
    static int n;
    static boolean answer;

    public static void dfs(int x, int y){

        if (x == n && y == n) {
            answer = true;
            return;
        }

        visited[x][y] = true;
        int value = map[x][y];

        int dirY[] = {value, 0};
        int dirX[] = {0, value};



            for (int i = 0; i < 2; i++) {
                int nX = x + dirX[i];
                int nY = y + dirY[i];

                if (nX <= n && nY <=n && !visited[nX][nY]) {
                    dfs(nX, nY);
                }
            }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());

        map = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        //입력
        for (int i = 1; i <= n; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dfs
        dfs(1,1);

        //답
        if(answer == true){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }




    }



}
