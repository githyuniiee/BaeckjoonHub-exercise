import java.io.*;
import java.util.*;

public class Main {

	static List<Integer>[] list;
	static boolean[] check;
	static int[] d;
	public static void main(String[] args) throws  IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		check = new boolean[m+1];
		d = new int[m+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			for(int j=0; j<s; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));	
			}
		}
		
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			Arrays.fill(check, false);
			if(dfs(i)) cnt++;
		}
		System.out.println(cnt);
	}
	
	static boolean dfs(int here) {
		for(int nxt : list[here]) {
			if(!check[nxt]) {
				check[nxt] = true;
				if(d[nxt] == 0 || dfs(d[nxt])) {
					d[nxt] = here;
					return true;
				}
			}
		}
		return false;
	}
}