import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dfs(n, 1, 1, 0, "1");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int max, int now, int num, int sum, String result) {
        if (max == now) {
            sum += num; // 마지막 숫자 처리
            if (sum == 0) {
                sb.append(result).append("\n");
            }
            return;
        }

        int next = now + 1;

        // 공백
        dfs(max, next, num * 10 + (num > 0 ? next : -next), sum, result + " " + next);

        // 덧셈
        dfs(max, next, next, sum + num, result + "+" + next);

        // 뺄셈
        dfs(max, next, -next, sum + num, result + "-" + next);
    }
}
