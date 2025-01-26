import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static ArrayList<ArrayList<Node>> list;
    static boolean[] visited;
    static int low = Integer.MAX_VALUE;
    static int high = Integer.MIN_VALUE;
    static int start,end;
    static int answer = 0;

    static class Node{
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, weight));
            list.get(e).add(new Node(s, weight));

            low = Math.min(low, weight);
            high = Math.max(high, weight);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        while(low <= high){

            int mid = (low + high) / 2;
            visited = new boolean[n + 1];

            if(bfs(mid)){
                answer = Math.max(answer, mid);
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean bfs(int weight){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if(node.v == end){
                return true;
            }

            for(Node nd : list.get(node.v)) {
                if (!visited[nd.v] && nd.w >= weight) {
                    visited[nd.v] = true;
                    q.add(nd);
                }
            }
        }
        return false;
    }

}