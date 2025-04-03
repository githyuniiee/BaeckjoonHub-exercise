import java.util.*;

class Solution {
    
    static int len;
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        visited = new boolean[len];
        
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    static void dfs(int k, int[][] dungeons, int cnt) {
        answer = Math.max(answer, cnt); // 최대 탐험 횟수 갱신

        for (int i = 0; i < len; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true; // 방문 처리
                dfs(k - dungeons[i][1], dungeons, cnt + 1); // 다음 탐색
                visited[i] = false; // 백트래킹 (복구)
            }
        }
    }
}
