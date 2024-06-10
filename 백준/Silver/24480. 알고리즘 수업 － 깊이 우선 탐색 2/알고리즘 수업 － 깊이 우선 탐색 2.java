import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n,m,r;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int[] answer;
    static boolean arrive;
    static int rank = 0;




    public static void dfs(int start) {

        rank++;
        answer[start] = rank;
        visited[start] = true;

        for (int a : list[start]) {
            if (!visited[a]) {
                dfs(a);
            }
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i], Collections.reverseOrder());
        }

        dfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }


    }
}





