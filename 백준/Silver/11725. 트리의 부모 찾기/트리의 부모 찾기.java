
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer>[] list;
    static int[] parents;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        parents = new int[n+1];
        check = new boolean[n + 1];



        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int j = 1; j < n; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int k = 1; k <= n; k++) {
            if (!check[k]) {
                dfs(k);
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int v) {
        if(check[v]){
            return;
        }
        check[v] = true;
        for (int result : list[v]) {
            if (!check[result]) {
                parents[result] = v;
                dfs(result);

            }
        }


    }
}




