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
        int m = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[n];
        long answer = Long.MAX_VALUE;
    

        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long low = 0;
        long high = arr[n - 1] * m;


        while(low <= high){
            long mid = (low + high) / 2;
            long sum = 0;

            for(int i=0; i<n; i++){
                sum += mid / arr[i];

                if(sum >= m) break;
            }

            if(sum < m){
                low = mid + 1;
            }else{

                high = mid -1;
                answer = Math.min(answer, mid);
            }


        }

        System.out.println(answer);



    }
}