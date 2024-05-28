import java.io.*;
import java.util.*;

public class Main {
    static int n,m,k,x;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static long[] count;
    static int answer = 0;


    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int num = queue.peek();
            queue.poll();

            for (int i : graph.get(num)) {
                if(!visited[i]){
                    queue.add(i);
                    count[i] = count[num] + 1;
                    visited[i] = true;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        count = new long[n+1];
        count[x] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        bfs(x);

        for(int i=0; i<=n; i++){
            if(count[i] == k){
                System.out.println(i);
                answer++;
            }
        }

        if (answer == 0) {
            System.out.println(-1);
        }




    }
}
