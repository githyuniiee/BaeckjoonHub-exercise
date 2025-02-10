import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {

    static int n,m,k;
    static ArrayList<ArrayList<Node>> road;
    

    static class Node {
        int node;
        long weight;
        int cnt;

        public Node(int node, long weight, int cnt){
            this.node = node;
            this.weight = weight;
            this.cnt = cnt;
        }
    }
 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        road = new ArrayList<>();
        for(int i=0; i<=n; i++){
            road.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            road.get(start).add(new Node(end, val, 0));
            road.get(end).add(new Node(start, val, 0));

        }

        System.out.println(dij(1));
		

	}

    static long dij(int start){
        long[][] distance = new long[n+1][k+1];

        for(int i=0; i<=n; i++){
            Arrays.fill(distance[i], Long.MAX_VALUE);
        }

        distance[start][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.weight, o2.weight));
        pq.add(new Node(start, 0,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.weight > distance[cur.node][cur.cnt]){
                continue;
            }

            for (Node next : road.get(cur.node)) {

                //도로를 포장했을경우 => next 노드의 weight 값을 합산 x
                if(cur.cnt<k && distance[next.node][cur.cnt+1] > distance[cur.node][cur.cnt] ){
                    distance[next.node][cur.cnt+1] = distance[cur.node][cur.cnt] ;
                    pq.add(new Node(next.node,distance[next.node][cur.cnt+1],cur.cnt+1));
                }

                 //도로를 포장하지 않았을 경우 => next 노드의 weight 값 합산
                if(distance[next.node][cur.cnt] > distance[cur.node][cur.cnt] + next.weight ){
                    distance[next.node][cur.cnt] = distance[cur.node][cur.cnt] + next.weight;
                    pq.add(new Node(next.node,distance[next.node][cur.cnt],cur.cnt));
                }
            }
        }

    long minDistance = Long.MAX_VALUE;
    for (int i = 0; i <= k; i++) {
        minDistance = Math.min(minDistance, distance[n][i]);
    }
    return minDistance;

    }

	
}