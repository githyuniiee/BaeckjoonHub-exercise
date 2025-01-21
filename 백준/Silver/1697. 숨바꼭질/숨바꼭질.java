import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int start;
    static int end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        end = Integer.parseInt(st.nextToken());   // 동생의 위치

        System.out.println(bfs());
    }

    static int bfs() {
        // 큐와 방문 기록
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001]; // 최대 100000까지 이동 가능
        queue.add(new int[]{start, 0});  // 시작 위치와 시간(초)
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int now = current[0];
            int count = current[1];

            // 목표 상태에 도달했을 때
            if (now == end) {
                return count;
            }

            // 세 가지 이동을 시도
            if (now - 1 >= 0 && !visited[now - 1]) {
                queue.add(new int[]{now - 1, count + 1});
                visited[now - 1] = true;
            }
            if (now + 1 <= 100000 && !visited[now + 1]) {
                queue.add(new int[]{now + 1, count + 1});
                visited[now + 1] = true;
            }
            if (now * 2 <= 100000 && !visited[now * 2]) {
                queue.add(new int[]{now * 2, count + 1});
                visited[now * 2] = true;
            }
        }

        return -1; // 도달 불가능한 경우
    }
}
