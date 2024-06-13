import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int start = 0;
        int end = 0;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (start < arr[i]) {
                start = arr[i];
            }
            end += arr[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            int sum = 0;

            for (int i = 0; i < n; i++) {

                if(sum + arr[i] > mid){
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }

            count++;

            if(count <= m){
                result = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(result);




    }


}
