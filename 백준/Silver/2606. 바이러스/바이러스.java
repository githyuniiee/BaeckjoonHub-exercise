import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int answer;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        dfs(1);

        System.out.println(answer);

    }

    static int dfs(int start){
       visited[start] = true;

        for (int i = 0; i < list[start].size(); i++) {
            int next = list[start].get(i);


            if(!visited[next]){
                answer++;
                dfs(next);
            }
        }

        return answer;
    }


}


