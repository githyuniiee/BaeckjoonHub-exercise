import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long right = arr[n-1];
        long left = 1;
        long count, half;

        while(left <= right){
            count = 0;
            half = (left + right) / 2;

            for(int i=0; i<n; i++){
                count += arr[i] / half;
            }

            if(count < m) right = half - 1;
            else left = half + 1;
        }

        System.out.println(right);






    }

}

