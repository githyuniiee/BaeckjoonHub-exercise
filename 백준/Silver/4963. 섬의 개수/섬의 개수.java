import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int w,h;
    static int[] dy = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] arr;
    static boolean[][] visited;


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

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0){
                break;
            }

            arr = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        bfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }




    }

    static void bfs(int y, int x){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 8; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                

                if(0<=ny && ny < h && 0<=nx && nx < w
                && !visited[ny][nx] && arr[ny][nx] == 1){
                    q.add(new Node(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }




}


