import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, s, m;
    static int[] change;
    static int answer = -1;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        change = new int[n];
        visited = new boolean[n + 1][m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            change[i] = Integer.parseInt(st.nextToken());
        }

        dfs(s, 0);
        System.out.println(answer);
    }

    static void dfs(int now, int depth) {
        if (now < 0 || now > m || visited[depth][now]) {  // 중복 탐색 방지
            return;
        }

        visited[depth][now] = true;

        if (depth == n) {  
            answer = Math.max(answer, now);  
            return;
        }

        dfs(now + change[depth], depth + 1);
        dfs(now - change[depth], depth + 1);
    }
}
