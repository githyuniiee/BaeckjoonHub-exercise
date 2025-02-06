import java.io.*;
import java.util.*;
 
public class Main {
 
	public static class Point implements Comparable<Point>{
		
		int index;
		int distance;
		
		public Point(int index, int distace) {
			this.index = index;
			this.distance = distace;
		}
		@Override
		public int compareTo(Point o) {
			return this.distance - o.distance;
		}
	}
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int INF = 100_000_000;
	
	public static int N;
	public static int E;
	
	public static ArrayList<ArrayList<Point>> route;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken()); 
		E = Integer.parseInt(st.nextToken());
		
		int point1 = 0;
		int point2 = 0;
		
		route = new ArrayList<ArrayList<Point>>();
		
		for(int i = 0 ; i <= N; i++) {
			route.add(new ArrayList<>());
		}
		
		
		for(int i = 0; i < E; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			
			point1 = Integer.parseInt(st1.nextToken());
			point2 = Integer.parseInt(st1.nextToken());
			int distance = Integer.parseInt(st1.nextToken());
			
			route.get(point1).add(new Point(point2,distance));
			route.get(point2).add(new Point(point1,distance));
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
		int target1 = Integer.parseInt(st2.nextToken());
		int target2 = Integer.parseInt(st2.nextToken());
		
		
		int[] startAtS = dijkstra(1);
		int[] startAt1 = dijkstra(target1);
		int[] startAt2 = dijkstra(target2);
	
		
		int sum1 = startAtS[target1] + startAt1[target2] + startAt2[N];
		int sum2 = startAtS[target2] + startAt2[target1] + startAt1[N];
		
		int min = Math.min(sum1, sum2);
		
		if(min >= INF)
			System.out.println("-1");
		else
			System.out.println(min);
	}
	
	public static int[] dijkstra(int start) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		int[] dp = new int[N+1];
		Arrays.fill(dp, INF);
		
		pq.add(new Point(start, 0));
		dp[start] = 0;
		
		while(!pq.isEmpty()) {
			Point pos = pq.poll();
			
			int to = pos.index;
			
			if(visited[to]) continue;
			
			visited[to] = true;
			
			for(Point next : route.get(to)) {
				if(dp[to] + next.distance < dp[next.index]) {
					dp[next.index] = dp[to] + next.distance;
					pq.add(new Point(next.index, dp[next.index]));
				}
			}
		}
		
		return dp;
	}
	
}