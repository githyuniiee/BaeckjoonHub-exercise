import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int len;
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {

        len = dungeons.length;
        visited = new boolean[len];
        
        dfs(k, dungeons, 0);
        
        
        return answer;
    }
    
    static void dfs(int k, int[][] dungeons, int depth){
        
        answer = Math.max(answer, depth);
        
        for(int i=0; i<len; i++){
            
            if(k >= dungeons[i][0] && !visited[i]){
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, depth + 1);
                visited[i] = false;
            }
        }
        
    }
}