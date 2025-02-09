import java.io.*;
import java.util.*;

public class Main {

    static int n, d;
    static List<Street> streets;
    static int[] dp;

    static class Street {
        int s, e, v;

        Street(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        streets = new ArrayList<>();
        dp = new int[d + 1];

        for (int i = 0; i <= d; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            if (end <= d) { 
                streets.add(new Street(start, end, val));
            }
        }

       
		Collections.sort(streets, ((o1,o2) -> o1.s - o2.s));
        dijkstra(0);

        System.out.println(dp[d]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Street> pq = new PriorityQueue<>((o1,o2) -> o1.v - o2.v);

        pq.add(new Street(0, 0, 0));

        dp[start] = 0;

        while(!pq.isEmpty()){
            Street street = pq.poll();
            int now = street.e;

            for(Street str : streets){
                if(str.s >= now){
                    if(dp[str.e] > dp[now] + str.v + (str.s - now)){
                        dp[str.e] = dp[now] + str.v + (str.s - now);
                        pq.add(new Street(now, str.e , dp[str.e]));
                    }
                }
            }
            dp[d] = Math.min(dp[now] + d - now, dp[d]);

        }
    }
}
