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
        long m = Long.parseLong(st.nextToken());

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long start = arr[0];
        long end = arr[n-1] * m;
        long answer = Long.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                sum += (mid / arr[i]);

                if(sum >= m){
                    break;
                }
            }

            if(sum >= m){
                answer = Math.min(answer, mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(answer);



    }
}