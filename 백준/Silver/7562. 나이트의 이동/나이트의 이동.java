import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int[][] visited;

    static int dx[] = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    static int dy[] = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};

    static void bfs(int start_x, int start_y, int end_x, int end_y) {
        Queue<Node> q = new LinkedList<>();
        Node node = new Node(start_x, start_y);
        q.add(node);

        visited[start_x][start_y] = 0;

        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            int now_x = nowNode.x;
            int now_y = nowNode.y;


            if(now_x == end_x && now_y == end_y){
                System.out.println(visited[end_x][end_y]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];


                if (next_x >= 0 && next_y >= 0
                        && next_x < visited.length && next_y < visited.length
                        && visited[next_x][next_y] == 0) {
                    Node nextNode = new Node(next_x, next_y);
                    q.add(nextNode);
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
            
            visited = new int[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            bfs(start_x , start_y , end_x, end_y );


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