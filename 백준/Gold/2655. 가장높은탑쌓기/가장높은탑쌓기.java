import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static Brick list[];
	static int dp[];

	static class Brick {
		int num;
		int s;
		int h;
		int w;

		Brick(int num, int s, int h, int w){
			this.num = num;
			this.s = s;
			this.h = h;
			this.w = w;
		}
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new Brick[n+1];
		dp = new int[n+1];
		Arrays.fill(dp, 0);

		list[0] = new Brick(0, 0, 0, 0);
		
		for(int i=1; i<=n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[i] = new Brick(i, s, h, w);
		}

		Arrays.sort(list, ((o1,o2) -> o1.s - o2.s));


		int max = 0;
		for(int i=1; i<=n; i++){
			for(int j=0; j<i; j++){
				if(list[i].w > list[j].w){
					dp[i] = Math.max(dp[i], dp[j] + list[i].h);
				}
			}
			max = Math.max(max, dp[i]);
		}

		Stack<Integer> ans = new Stack<>();
		while(n > 0){
			if(max == dp[n]){
				ans.add(list[n].num);
				max -= list[n].h;
			}
			n--;
		}

		System.out.println(ans.size());
		while(!ans.isEmpty()){
			System.out.println(ans.pop());
		}



    }
}

