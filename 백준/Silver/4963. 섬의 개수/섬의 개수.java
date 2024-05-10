
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    final static int MAX = 50 + 10;
    static int map[][];
    static boolean visited[][];
    static int w,h;
    static int dirY[] = {-1, -1,-1, 0,0,1,1,1};
    static int dirX[] = {-1, 0, 1, -1, 1,-1,0,1};
    static int answer = 0;

    public static void dfs(int y, int x){

        visited[y][x] = true;
        for(int i=0; i<8; i++){
            int ny = y + dirY[i];
            int nx = x + dirX[i];

            if (!visited[ny][nx] && map[ny][nx] == 1) {

                dfs(ny, nx);
            }


        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= w; j++) {
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            //dfs
            for (int i = 1; i <= h; i++) {

                for (int j = 1; j <= w; j++) {
                    if (map[j][i] == 1 && !visited[j][i]) {
                        dfs(j, i);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
            answer = 0;


        }
    }



}
