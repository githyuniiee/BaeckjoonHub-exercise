import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n,m,v;
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();

    static void dfs(int start){
        visited[start] = true;
        sb.append(start + " ");

        for(int i=1; i<=n; i++){
            if( graph[start][i] == 1 && !visited[i]){
               dfs(i);
            }
        }
    }

    static void bfs(int start) {

        //시작할 노드 번호 넣기
        q.offer(start);

        //시작 노드 방문 처리
        visited[start] = true;

        while (!q.isEmpty()) {
            int nodeIndex = q.poll();
            sb.append(nodeIndex + " ");

            for (int i = 1; i <= n; i++) {

                if (graph[nodeIndex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];



        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(v);
        sb.append("\n");
        visited = new boolean[n + 1];

        bfs(v);

        System.out.println(sb);
    }
}


