import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        int k = Integer.parseInt(br.readLine());
        double result = 0;

        for (int i = 0; i < m; i++) {
            if (arr[i] >= k) {
                double probability = 1.0;
                for (int j = 0; j < k; j++) {
                    probability *= (double)(arr[i] - j) / (total - j);
                }
                result += probability;
            }
        }

        System.out.println(result);




    }

}
