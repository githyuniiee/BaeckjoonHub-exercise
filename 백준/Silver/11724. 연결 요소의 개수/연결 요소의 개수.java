import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visitied;
    static int node, edge;
    static int partionNum;
    static int count;

    static void dfs(int start) {
        visitied[start] = true;

        for (int i = 1; i <= node; i++) {
            if (graph[start][i] == 1 && !visitied[i]) {
                dfs(i);
            }
        }
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        graph = new int[node + 1][node + 1];
        visitied = new boolean[node + 1];


        while (edge --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        for (int i = 1; i <= node; i++) {
            if(!visitied[i]){
                dfs(i);
                partionNum++;
            }
        }


        System.out.println(partionNum);
    }
}


