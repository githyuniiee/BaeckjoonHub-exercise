import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;

        // A: n 이상이면 안 됨 → 최대 n-1
        // B: m 이상이면 안 됨 → 최대 m-1
        int[][] dp = new int[len + 1][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[0][0] = 0; // 0개 물건, B 흔적 0 → A 흔적 0

        for (int i = 0; i < len; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];

            for (int j = m - 1; j >= 0; j--) { // 역순 for: 상태 업데이트 중복 방지
                if (dp[i][j] == Integer.MAX_VALUE) continue;

                // 1. 이 물건을 A가 훔칠 경우
                if (dp[i + 1][j] > dp[i][j] + aTrace) {
                    dp[i + 1][j] = dp[i][j] + aTrace;
                }

                // 2. 이 물건을 B가 훔칠 경우
                if (j + bTrace < m) {
                    dp[i + 1][j + bTrace] = Math.min(dp[i + 1][j + bTrace], dp[i][j]);
                }
            }
        }

        // dp[len][b] 중 A 흔적이 n 미만인 것들 중 최소값 반환
        int answer = Integer.MAX_VALUE;
        for (int b = 0; b < m; b++) {
            if (dp[len][b] < n) {
                answer = Math.min(answer, dp[len][b]);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
