import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static Character[][] arr;
    static Character[][] arr2;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, 1, -1, 0};

    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new Character[n][n];
        arr2 = new Character[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
                arr2[i][j] = (str.charAt(j) == 'G') ? 'R' : str.charAt(j);
            }
        }
        
        int answer1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    answer1++;
                    bfs(i, j, arr, arr[i][j]);
                }
            }
        }
        System.out.println(answer1);


        visited = new boolean[n][n];
        int answer2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    answer2++;
                    bfs(i, j, arr2, arr2[i][j]);
                }
            }
        }
        System.out.println(answer2);
    }

    static void bfs(int y, int x, Character[][] arr, char ch) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (0 <= ny && ny < n && 0 <= nx && nx < n &&
                        !visited[ny][nx] && arr[ny][nx] == ch) {
                    q.add(new Node(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
