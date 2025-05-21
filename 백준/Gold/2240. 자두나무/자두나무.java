import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]); // 총 시간
        int w = Integer.parseInt(input[1]); // 최대 이동 횟수

        int[] tree = new int[t + 1];
        for (int i = 1; i <= t; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[t + 1][w + 1];

        for (int time = 1; time <= t; time++) {
            for (int move = 0; move <= w; move++) {
                int pos = (move % 2 == 0) ? 1 : 2;

                // 이전 상태에서 이동하지 않은 경우
                dp[time][move] = dp[time - 1][move];

                // 자두가 현재 위치에서 떨어지면 +1
                if (tree[time] == pos) {
                    dp[time][move]++;
                }

                // 이동할 수 있다면, 이동한 상태에서도 최대값 비교
                if (move > 0) {
                    dp[time][move] = Math.max(dp[time][move],
                            dp[time - 1][move - 1] + (tree[time] == pos ? 1 : 0));
                }
            }
        }

        int answer = 0;
        for (int move = 0; move <= w; move++) {
            answer = Math.max(answer, dp[t][move]);
        }

        System.out.println(answer);
    }
}
