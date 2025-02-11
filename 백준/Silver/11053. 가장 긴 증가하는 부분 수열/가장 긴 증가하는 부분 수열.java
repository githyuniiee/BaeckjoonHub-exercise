import java.io.*;
import java.util.StringTokenizer;
 
public class Main {
 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        int answer = 0;

        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                answer= Math.max(dp[i], answer);
            }
        }

        System.out.println(answer);


	}

	
}