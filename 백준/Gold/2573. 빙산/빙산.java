import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;


public class Main {


    static int n,m;
    static int[][] arr;
    static boolean[][] visited;
    static int year = 0;
    static int[] dy = new int[]{-1, 0, 0, 1};
    static int[] dx = new int[]{0, 1, -1, 0};

    static class Point{
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] strArr = str.split(" ");

            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        while(true){
            visited = new boolean[n][m];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] >0 && !visited[i][j]) {
                        cnt++;
                        bfs(i,j);
                    }
                }
            }

            if(cnt >= 2){
                System.out.println(year);
                break;
            }

            if(cnt == 0){
                System.out.println(0);
                break;
            }

            year++;
            meltIce();

        }
    }


    static void bfs(int y, int x){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];

                if (0 <= ny && ny < n && 0 <= nx && nx < m && arr[ny][nx] > 0) {
                    if(!visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.add(new Point(ny, nx));
                    }
                }
            }
        }
    }

    static void meltIce(){
        int[][] melting = new int[n][m]; // 빙하가 녹는 양 저장

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 0) {
                    int seaCount = 0;

                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if (0 <= ny && ny < n && 0 <= nx && nx < m && arr[ny][nx] == 0) {
                            seaCount++;
                        }
                    }

                    melting[i][j] = seaCount;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = Math.max(0, arr[i][j] - melting[i][j]);
            }
        }
    }
}