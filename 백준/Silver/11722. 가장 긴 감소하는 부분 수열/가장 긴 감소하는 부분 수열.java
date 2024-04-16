import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1]; //입력 배열
        int[] dp = new int[n+1]; //dp 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i=1; i<=n; i++){
            //시작은 1
            dp[i] = 1;
            for(int j=1; j<i; j++){
                //시작값과 이전값 비교
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                    System.out.println(i +" " + dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);




    }

}


