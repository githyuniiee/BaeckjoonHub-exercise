import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int[][] graph;
    static boolean[] visited;
    static int answer;
    static int num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        graph = new int[num + 1][num + 1];
        visited = new boolean[num + 1];
        answer = Integer.MAX_VALUE;

        for (int i = 1; i <= num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= num; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= num; i++) {
            visited[i] = true;
            solve(i,i,0,0);
        }

        System.out.println(answer);
    }

    static void solve(int start, int now, int depth, int sum) {

        if (depth == num-1) {
            if (graph[now][start] != 0) {
                sum += graph[now][start];
                answer = Math.min(answer, sum);
            }
            return;
        }

        for (int i = 1; i <= num; i++) {
            if(!visited[i] && graph[now][i] > 0){
                visited[i] = true;
                solve(start, i, depth + 1, sum + graph[now][i]);
                visited[i] = false;
            }
        }
    }
}
