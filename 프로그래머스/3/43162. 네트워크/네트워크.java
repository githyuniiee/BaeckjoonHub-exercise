import java.util.*;
class Solution {
    static boolean[] visited;
    static List<Integer>[] list;
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        list = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        
        
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[i].length; j++){
                if(computers[i][j] == 1){
                    list[i].add(j);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i);
            }
        }
        
        return answer;
    }
    
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i=0; i<list[now].size(); i++){
                int next = list[now].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        answer++;
    }
}