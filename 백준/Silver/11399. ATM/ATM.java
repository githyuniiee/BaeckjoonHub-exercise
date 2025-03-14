import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        
        dp[0] = arr[0];
        int sum = dp[0];

        for(int i=1; i<n; i++){
            dp[i] = dp[i-1] + arr[i];
            sum += dp[i];
        }

        System.out.println(sum);

    


	}

	
}