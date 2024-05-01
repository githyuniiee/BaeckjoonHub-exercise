import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    final static int MAX = 1000000 + 10;
    static int n;
    static int m;
    static int r;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int order; //현재 몇 번째로 방문했는지

    public static void dfs(int idx){
        visited[idx] = true;
        answer[idx] = order;
        order++;

        for(int i=0; i<graph[idx].size();i++){
            int next = graph[idx].get(i);
            if(!visited[next]) {
                dfs(next);
            }
        }
    }




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        //1. graph에 연결 정보 채우기
        graph = new ArrayList[MAX];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[MAX];
        answer = new int[MAX];
        order = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        //2. 오름차순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        //3. 재귀함수 호출
        dfs(r);

        for (int i = 1; i <= n; i++){
            System.out.println(answer[i]);
        }
    }

}


