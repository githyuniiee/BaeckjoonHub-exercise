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
    static int n;
    static int m;
    static ArrayList<Integer>[] list;
    static boolean visited[];
    static int[] rank;
    static int a = 0;

    static void bfs(int x){

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        rank[x] = a;

        while (!q.isEmpty()) {
            int num = q.poll();
            a++;
            rank[num] = a;

            for (int a : list[num]) {
                if(!visited[a]) {
                    q.add(a);
                    visited[a] = true;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        visited = new boolean[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        bfs(start);

        for (int i = 1; i <= n; i++) {
            System.out.println(rank[i]);
        }
    }

}