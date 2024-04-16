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

        int[] arr = new int[n + 1];
        int[] sum = new int[n+1];

        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            sum[i] = 1;
            for(int j=1; j<i; j++){
                if(arr[j] > arr[i]){
                    sum[i] = Math.max(sum[i], sum[j] + 1);
                }
            }
            result = Math.max(result, sum[i]);
        }

        System.out.println(result);



    }

}


