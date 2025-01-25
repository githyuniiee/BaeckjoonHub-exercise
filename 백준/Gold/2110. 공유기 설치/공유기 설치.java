import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long low = 1;
        long high = arr[n-1] - arr[0] + 1;
        long answer = 0;


        while(low<= high){
            long mid = (low + high) / 2;
            int count = 1;
            long nowPoint = arr[0];


            for (int i = 1; i < n; i++) {
                if (arr[i] - nowPoint >= mid) {
                    count++;
                    nowPoint = arr[i];
                }
            }

            if(count < c){

                high = mid-1;
            }else{
                
                answer = Math.max(answer, mid);
                
                low = mid+1;
            }


        }

        System.out.println(answer);

    }
}