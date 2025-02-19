import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        long start = 0;
        long end = arr[arr.length - 1];
        long ans = 0;
        

        while(start <= end){
            long mid = (start + end) / 2;
            long sum = 0;

            

            for(int i=0; i<n; i++){

                if(arr[i] > mid){
                    sum += mid;
                }else{
                    sum += arr[i];
                }
            }

            if(sum <= m){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }

          
        }

        System.out.println(ans);




    }

}