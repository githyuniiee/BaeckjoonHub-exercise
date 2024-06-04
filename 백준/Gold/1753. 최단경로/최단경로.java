import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] list = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<Edge>();
        }
        boolean[] visited = new boolean[v + 1];
        int[] distance = new int[v + 1];
        for(int i=1; i<=v; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(V, w));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(k, 0));
        distance[k] = 0;

        while (!q.isEmpty()) {
            Edge current = q.poll();
            int c_v = current.vertex;

            if(visited[c_v]) continue;
            visited[c_v] = true;

            for (int i = 0; i < list[c_v].size(); i++) {
                Edge tmp = list[c_v].get(i);
                int next = tmp.vertex;
                int value = tmp.value;

                if(distance[next] > distance[c_v] + value){
                    distance[next] = distance[c_v] + value;
                    q.add(new Edge(next, distance[next]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if(visited[i]){
                System.out.println(distance[i]);
            }else{
                System.out.println("INF");
            }
        }

    }
}

class Edge implements Comparable<Edge>{
    int vertex;
    int value;

    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    public int compareTo(Edge e){
        if(this.value > e.value) return 1;
        else return -1;
    }
}