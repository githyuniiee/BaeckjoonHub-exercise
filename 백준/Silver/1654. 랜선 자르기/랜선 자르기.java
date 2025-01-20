import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
        arr = new int[K];

        int max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        long start = 1;
        long end = max;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            int num = getCount(mid);

            if (num >= N) {
                result = Math.max(result, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }

    public static int getCount(long length) {
        int count = 0;
        for (int a : arr) {
            count += a / length;
        }
        return count;
    }
}
