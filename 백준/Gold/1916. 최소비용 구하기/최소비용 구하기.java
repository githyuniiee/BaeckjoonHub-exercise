import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] list = new ArrayList[n+1];
        for(int i=1; i<=n ;i++){
            list[i] = new ArrayList<Edge>();
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[start].add(new Edge(end, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;


        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(start, 0));

        while(!q.isEmpty()){
            Edge e = q.poll();
            int current = e.vertex;

            if(!visited[current]){
                visited[current] = true;

                for(int i=0; i<list[current].size(); i++){
                    Edge eg = list[current].get(i);
                    int next = eg.vertex;
                    int next_value = eg.value;
                    if(cost[next] > cost[current] + next_value){
                        cost[next] = cost[current] + next_value;
                        q.add(new Edge(next, cost[next]));
                    }
                }


            }

        }

        System.out.println(cost[end]);






    }
}

class Edge implements Comparable<Edge>{
    int vertex;
    int value;

    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e) {

        if(this.value > e. value) return 1;
        return -1;
    }
}