import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long day[] = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            day[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        //처음
        for (int i = 0; i < m; i++) {
            sum += day[i];
        }

        long max = sum;

        //슬라이딩 윈도우
        for (int i = m; i < n; i++) {
            sum += day[i];
            sum -= day[i - m];

            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
