import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;


public class Main {


    static List<Integer>[] list;
    static boolean[] visited;
    static char color[];
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < K; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V+1];
            color = new char[V + 1];
            visited = new boolean[V + 1];
            answer = "YES";

            for (int i = 0; i < V + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[start].add(end);
                list[end].add(start);
            }



            for(int i=1; i<=V; i++){
                if(!visited[i]){
                    if(!bfs(i)){
                        answer = "NO";
                        break;
                    }
                }
            }

            System.out.println(answer);


        }

    }

    static boolean bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        color[start] = 'R';

        while (!q.isEmpty()) {
            int now = q.poll();
            char nowColor = color[now];

            for (int next : list[now]) {
                if (!visited[next]) {
                    color[next] = (nowColor == 'R') ? 'G' : 'R';
                    visited[next] = true;
                    q.add(next);
                } else if (color[next] == nowColor) {
                    return false;
                }
            }
        }
        return true;

    }


}