import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Edge>[] list;
    static boolean[] visited;
    static int[] distance;

    public static void bfs(int index) {

        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;
        while (!q.isEmpty()) {
            int now_node = q.poll();
            for (Edge i : list[now_node]) {
                int e  = i.node;
                int v = i.value;
                if (!visited[e]) {
                    visited[e] = true;
                    q.add(e);
                    distance[e] = distance[now_node] + v;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visited = new boolean[n+1];
        distance = new int[n + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while(true){
                int b = Integer.parseInt(st.nextToken());
                if(b == -1){
                    break;
                }
                int c = Integer.parseInt(st.nextToken());
                list[a].add(new Edge(b,c));
            }
        }

        bfs(1);
        int MAX = 1;

        for (int i = 2; i <= n; i++) {
            if(distance[MAX] < distance[i]){
                MAX = i;
            }
        }

        visited = new boolean[n+1];
        distance = new int[n + 1];
        bfs(MAX);

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, distance[i]);
        }

        System.out.println(answer);

    }
}
class Edge{
    int node;
    int value;

    public Edge(int node, int value){
        this.node = node;
        this.value = value;
    }
}



