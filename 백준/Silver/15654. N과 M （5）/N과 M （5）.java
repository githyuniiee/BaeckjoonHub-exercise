import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int[] ans;
	static boolean[] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		visited = new boolean[n];
		ans = new int[m];

		st = new StringTokenizer(br.readLine());

		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		dfs(0);
		System.out.println(sb);
		
    }

	static void dfs(int depth){
		if(depth == m){
			for(int a : ans){
				sb.append(a).append(' ');
			}
			sb.append('\n');
			return;
		}

		for(int i=0; i<n; i++){
			if(!visited[i]){
				visited[i] = true;
				ans[depth] = arr[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}

	


}