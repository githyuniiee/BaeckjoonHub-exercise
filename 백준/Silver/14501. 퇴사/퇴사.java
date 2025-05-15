import java.io.*;
import java.util.StringTokenizer;

public class Main {

	

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		int[] day = new int[n+1];
		int[] cost = new int[n+1];
		int[] dp = new int[n+2];


		for(int i=1; i<=n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=n; i>=1; i--){
			int next = i + day[i];

			if(next <= n + 1){
				dp[i] = Math.max(dp[i+1], dp[next] + cost[i]);

			}else{
				dp[i] = dp[i+1];
			}

			ans = Math.max(dp[i], ans);
		}

		

		System.out.println(ans);

		
	}
}
