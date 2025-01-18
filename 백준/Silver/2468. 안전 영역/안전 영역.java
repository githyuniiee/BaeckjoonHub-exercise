import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = new int[]{-1, 0, 0, 1};
    static int[] dx = new int[]{0, -1, 1, 0};

    static class Node{
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i][j], max);
            }
        }

        int answer = 0;

        for(int depth= 0; depth <=max; depth++){
            visited = new boolean[n][n];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visited[i][j] && arr[i][j] > depth){
                        cnt++;
                        bfs(depth, i, j);
                    }
                }
            }

            answer = Math.max(answer, cnt);

        }

        System.out.println(answer);

    }

    static void bfs(int depth, int y, int x){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(0<=ny && ny < n && 0<=nx && nx < n && !visited[ny][nx]
                && arr[ny][nx] > depth){
                    visited[ny][nx] = true;
                    q.add(new Node(ny,nx));
                }
            }
        }

    }
}
