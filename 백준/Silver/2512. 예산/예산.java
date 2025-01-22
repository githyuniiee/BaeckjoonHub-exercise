import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] str = br.readLine().split(" ");


        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        long m = Long.parseLong(br.readLine());

        Arrays.sort(arr);

        long start = 1;
        long end = arr[arr.length - 1];
        long answer = 0;
        long max = 0;

        while (start <= end) {

            long mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if(arr[i] >= mid){
                    sum += mid;
                }else{
                    sum += arr[i];
                }
            }

            if(sum <= m){
                if(max < sum){
                    max = sum;
                    answer = mid;
                }
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}