import java.util.*;

class Solution {
    
    static int[][] dungeon;
    static boolean[] visited;
    static int len;
    static int answer;
    
    static void dfs(int remainingFatigue, int depth) {
        answer = Math.max(answer, depth); // 최대 깊이(탐험 수)를 갱신

        // 모든 던전을 순회하며 방문하지 않은 던전을 탐험
        for (int i = 0; i < len; i++) {
            if (!visited[i] && dungeon[i][0] <= remainingFatigue) {
                visited[i] = true;
                dfs(remainingFatigue - dungeon[i][1], depth + 1);
                visited[i] = false; // 탐험 후 다시 초기화
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        dungeon = dungeons;
        len = dungeons.length;
        visited = new boolean[len];
        answer = 0;

        // DFS 탐색 시작
        dfs(k, 0);

        return answer;
    }
}
