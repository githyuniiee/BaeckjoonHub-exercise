import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    static int V,E;
    static List<ArrayList<Edge>> list;
    static int[]dist;
    static int INF = Integer.MAX_VALUE;

    static class Edge{
        int n;
        int v;

        Edge(int n, int v){
            this.n = n;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        dist = new int[V+1];

        Arrays.fill(dist, INF);

        for(int i=0; i<=V; i++){
            list.add(new ArrayList<>());
        }


        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.get(s).add(new Edge(e, value));
        }


        dijk(start);

        for(int i=1; i<=V; i++){

            if(dist[i] == INF){
                sb.append("INF" + "\n");
            }else{
                sb.append(dist[i] + "\n");
            }
        }

        System.out.println(sb.toString().trim());

    }

    static void dijk(int start){
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2) -> o1.v - o2.v);
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            for(Edge nxt : list.get(now.n)){

                if(dist[nxt.n] > dist[now.n] + nxt.v){
                    dist[nxt.n] = dist[now.n] + nxt.v;
                    pq.add(new Edge(nxt.n, dist[nxt.n]));
                }
            }
        }
    }

}
