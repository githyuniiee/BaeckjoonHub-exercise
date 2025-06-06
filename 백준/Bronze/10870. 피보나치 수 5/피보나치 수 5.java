import java.io.*;
import java.util.ArrayList;
public class Main{

	static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[21];

		dp[1] = 1;
		
		for(int i=2; i<=20; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}

		System.out.println(dp[n]);
	
	}	
}