import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int graph[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = i;
        }

        // 신뢰 관계 입력
        for (int i = 1; i <= n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(str[j]) == 1) {
                    union(i, j + 1); // i와 j+1을 연결
                }
            }
        }

        // 여행 계획 입력
        String[] str = br.readLine().split(" ");
        boolean check = true;
        for (int i = 0; i < str.length - 1; i++) {
            int a = Integer.parseInt(str[i]);
            int b = Integer.parseInt(str[i + 1]);
            if (find(a) != find(b)) {
                check = false;
                break;
            }
        }

        if (check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static int find(int x) {
        if (graph[x] != x) {
            graph[x] = find(graph[x]);
        }
        return graph[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            graph[rootB] = rootA;
        }
    }
}