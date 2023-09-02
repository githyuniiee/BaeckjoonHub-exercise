import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int arr[];
    static boolean visit[];
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visit = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            cnt = 0; // 매 테스트마다 카운트 0으로 초기화

            for (int j = 1; j <= n; j++) { //1부터 n까지 모두 확인
                if (!visit[j]) {
                    dfs(j);
                    cnt++; //순열 사이클 수 증가
                }
            }

            System.out.println(cnt);

        }
    }

    public static void dfs(int a) {
        while (!visit[a]) {
            visit[a] = true;
            a = arr[a];
        }
    }
}
