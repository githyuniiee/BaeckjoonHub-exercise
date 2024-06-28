import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int count = 0;
        int maxRange = 100000;
        boolean[] visited = new boolean[maxRange + 1];


        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Edge edge = new Edge(start, count);
        pq.add(edge);

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int e_now = e.now;
            int e_time = e.time;

            if (e_now == end) {
                System.out.println(e_time);
                break;
            }

            if (e_now >= 0 && e_now <= maxRange && !visited[e_now]) {
                visited[e_now] = true;

                pq.add(new Edge(e_now + 1, e_time + 1));
                pq.add(new Edge(e_now - 1, e_time + 1));
                pq.add(new Edge(e_now * 2, e_time));
            }
        }



    }

}

class Edge implements Comparable<Edge>{

    int now;
    int time;

    Edge(int now, int count) {
        this.now = now;
        this.time = count;
    }

    public int compareTo(Edge e) {
        if(this.time > e.time) return 1;
        return -1;
    }
}
