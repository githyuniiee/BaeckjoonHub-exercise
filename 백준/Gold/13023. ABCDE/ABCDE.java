import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,e;
    static ArrayList<Integer>[] list;
    static boolean visited[];
    static int ans = 0;

    public static void dfs(int start, int depth) {
        if (depth == 5) {
            ans = 1;
            return;
        }

        visited[start] = true;
        for(int i : list[start]) {
            int next = i;
            if(!visited[next]) {
                dfs(next, depth+1);
            }
        }

        visited[start] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            if (ans == 0) {
                dfs(i, 1);
            }
        }


        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();

    }




}