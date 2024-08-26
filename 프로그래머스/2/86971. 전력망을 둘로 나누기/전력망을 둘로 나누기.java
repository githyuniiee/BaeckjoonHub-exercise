import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        //그래프 연결
        graph = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int i=0; i<wires.length; i++){
            
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            visited = new boolean[n+1];
            
           
            int cnt = dfs(1);
            int diff = Math.abs(cnt - (n-cnt));
            
            min = Math.min(min, diff);
            
            graph[a].add(b);
            graph[b].add(a);
        }
        

        return min;
    }
    
    
    //연결 끊는 dfs
    static int dfs(int start){
        visited[start] = true;
        int cnt = 1;
        
        for(int a : graph[start]){
            if(!visited[a]){
                
                cnt += dfs(a);
            }
        }
        
        return cnt;
        
    }
}