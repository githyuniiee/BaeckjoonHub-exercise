import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];

            for(int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            

            long max = 0;
            long ans = 0;

            for(int j=n-1; j>=0; j--){
                if(arr[j] < max){
                    ans += max - arr[j];
                }else{
                    max = arr[j];
                }
            }

            sb.append(ans).append("\n");
        }


        System.out.println(sb);
     

    }
}