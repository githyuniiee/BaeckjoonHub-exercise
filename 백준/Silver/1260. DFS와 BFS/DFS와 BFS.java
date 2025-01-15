import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main {

    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];


        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }


        boolean[] visited = new boolean[n + 1];
        String answer1 = dfs(v, visited);
        System.out.println(answer1);

        visited = new boolean[n + 1];
        String answer2 = bfs(v, visited);
        System.out.println(answer2);

    }

    static String dfs(int start, boolean[] visited){

        sb.append(start + " ");
        visited[start] = true;

        for(int i=0; i<list[start].size(); i++){
            int next = list[start].get(i);

            if(!visited[next]){
                dfs(next, visited);
            }

        }

        return sb.toString().trim();

    }

    static String bfs(int start, boolean[] visited) {

        sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        sb.append(start + " ");
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);

                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    sb.append(next + " ");
                }

            }
        }

        return sb.toString().trim();
    }

}


