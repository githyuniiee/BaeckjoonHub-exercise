import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		visited = new boolean[n];
		dfs(n,m,0);

		System.out.println(sb);

    }


	static void dfs(int n, int m, int depth){
		if(depth == m){
			for(int a : arr){
				sb.append(a).append(' ');
			}

			sb.append('\n');
			return;
		}

		for(int i=0; i<n; i++){

			if(!visited[i]){
				visited[i] = true;
				arr[depth] = i + 1;
				dfs(n,m,depth + 1);
				visited[i] = false;
			}
		}


	}
}