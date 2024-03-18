import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    static int n,m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int answer = 0;

    //bfs에 사용할 정보 클래스
    static class info {
        int index, count;
        public info(int index, int count){
            this.index = index;
            this.count = count;
        }
    }

    static void bfs(int start) {
        Queue<info> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(new info(start, 0)); //시작번호
        visited[start] = true;
        int result = 0;

        while (!q.isEmpty()) {
            info cur = q.poll();
            //인접한 관계 탐색
            for (int next : graph.get(cur.index)) {
                if (!visited[next]) {
                    result += cur.count + 1;
                    visited[next] = true;
                    q.add(new info(next, cur.count + 1));
                }
            }
        }

        if (result < min) {
            min = result;
            answer = start;
        }

    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        //관계 정보 그래프 형태로 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //각 인원 기준 bfs 탐색
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }
        System.out.println(answer + " ");


    }
}


