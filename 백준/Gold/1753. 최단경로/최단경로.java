import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;




public class Main {

    static int v,e, s;
    static ArrayList<ArrayList<Node>> list;
    static int INF = Integer.MAX_VALUE;
    static int[] dp;

    static class Node {
        int num;
        int val;
    
        Node(int num, int val){
            this.num = num;
            this.val = val;
        }
    }
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        s = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        dp = new int[v+1];

        for(int i=0; i<=v; i++){
            list.add(new ArrayList<>());
            dp[i] = INF; 
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, val));
        }

        

        dij(s);

        for(int i=1; i<=v; i++){
            if(dp[i] == INF){
                System.out.println("INF");
            }else{

                System.out.println(dp[i]);
            }
        }

    }

    static void dij(int s){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> (o1.val - o2.val));
        pq.add(new Node(s, 0));
        dp[s] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            for(Node next : list.get(now.num)){

                if(dp[next.num] > dp[now.num] + next.val){
                    dp[next.num] = dp[now.num] + next.val;
                    pq.add(new Node(next.num, dp[next.num]));
                }

            }
        }

    }


    

}
