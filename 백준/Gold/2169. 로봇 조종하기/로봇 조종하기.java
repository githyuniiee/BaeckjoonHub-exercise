import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        int N, M, map[][];
        int dp[][];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];

        // 입력 값을 map 배열에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 번째 행은 왼쪽에서 오는 값으로 누적합을 계산
        dp[0][0] = map[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }

        // 첫 번째 열은 위쪽에서 오는 값으로 누적합 계산
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }

        // 나머지 부분 계산
        for (int i = 1; i < N; i++) {

            int[] temp1 = new int[M];
            int[] temp2 = new int[M];

            // 왼쪽 -> 오른쪽 경로 계산
            temp1[0] = map[i][0] + dp[i - 1][0];
            for (int j = 1; j < M; j++) {
                temp1[j] = map[i][j] + Math.max(temp1[j - 1], dp[i - 1][j]);
            }

            // 오른쪽 -> 왼쪽 경로 계산
            temp2[M - 1] = map[i][M - 1] + dp[i - 1][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                temp2[j] = map[i][j] + Math.max(temp2[j + 1], dp[i - 1][j]);
            }

            // 두 경로 중 최댓값을 dp 배열에 저장
            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(temp1[j], temp2[j]);
            }
        }

        // 마지막 값 출력
        System.out.println(dp[N - 1][M - 1]);
    }
}
