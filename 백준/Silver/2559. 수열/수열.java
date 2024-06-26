import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        int max = sum;

        int left = 0;
        int right = m;

        while (right < n) {

            sum -= arr[left];
            sum += arr[right];

            max = Math.max(max, sum);

            left++;
            right++;

        }

        System.out.println(max);




    }
}