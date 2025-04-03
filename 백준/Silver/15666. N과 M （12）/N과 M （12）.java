import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	static int[] arr;
	static int[] ans;
	static boolean[] visited;
	static Set<String> set;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		visited = new boolean[n];
		ans = new int[m];
		set = new LinkedHashSet<>();

		st = new StringTokenizer(br.readLine());

		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);


		dfs(0,0);
		
		for(String s : set){
			System.out.println(s);
		}
		
    }

	static void dfs(int now, int depth){
		if(depth == m){
			String str = "";
			for(int a : ans){
				str += a + " ";
			}
			set.add(str);
			return;
		}

		for(int i=now; i<n; i++){
		
			visited[i] = true;
			ans[depth] = arr[i];
			dfs(i, depth + 1);
			visited[i] = false;
			
		}

	}

	


}