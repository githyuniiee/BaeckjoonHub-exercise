import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int p1;
    static int p2;
    static int[][] graph;
    static boolean[] visited;
    static int count = 0;
    static int answer = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

        dfs(p1, count);
        System.out.println(answer);

    }

    public static void dfs(int start, int count){
        visited[start] = true;

        if(start == p2) {
            answer = count;
            return;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i] && graph[start][i] == 1){
                dfs(i, count+1);

            }
        }
        
    }
}


