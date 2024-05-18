
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = n-1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = arr[start] + arr[end];

        while(start < end){

            if(sum == m){
                sum = 0;
                count++;
                start++;
                end--;
                sum = arr[start] + arr[end];

            }else if( sum < m){

                sum -= arr[start];
                start++;
                sum += arr[start];

            }else{
                sum -= arr[end];
                end--;
                sum += arr[end];

            }
        }

        System.out.println(count);




    }
}
