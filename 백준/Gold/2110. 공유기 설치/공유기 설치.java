import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long start = 0;
        long end = arr[n-1] - arr[0];
        long ans = 0;

        while(start <= end){

            long cnt = 1;
            int now = arr[0];

            long mid = (start + end) / 2;

            for(int i=1; i<n; i++){

                if(cnt >= c) break;

                if(arr[i] >= now + mid){
                    now = arr[i];
                    cnt++;
                }
            }

            if(cnt < c){
                end = mid -1;
            }else{
                start = mid + 1;
                ans = mid;
            }
        }

        System.out.println(ans);

       


    }

}