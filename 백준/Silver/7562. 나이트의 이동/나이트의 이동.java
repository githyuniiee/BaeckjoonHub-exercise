import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};

    static void bfs(int start_x, int start_y, int end_x, int end_y, int n) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start_x, start_y));

        int[][] visited = new int[n][n];
        for (int[] row : visited) {
            Arrays.fill(row, -1); // 방문 배열을 -1로 초기화
        }
        visited[start_x][start_y] = 0;

        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            int now_x = nowNode.x;
            int now_y = nowNode.y;

            // 종료 조건: 목표 지점에 도달
            if (now_x == end_x && now_y == end_y) {
                System.out.println(visited[end_x][end_y]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if (next_x >= 0 && next_y >= 0 && next_x < n && next_y < n && visited[next_x][next_y] == -1) {
                    q.add(new Node(next_x, next_y));
                    visited[next_x][next_y] = visited[now_x][now_y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            bfs(start_x, start_y, end_x, end_y, n);
        }
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
