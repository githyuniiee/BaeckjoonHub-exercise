import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] list;
    
    public int solution(int n, int[][] wires) {
        int diff = Integer.MAX_VALUE;
        
        list = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            
            list[start].add(end);
            list[end].add(start);
        }
        
        for(int i=0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            
            list[start].remove(Integer.valueOf(end));
            list[end].remove(Integer.valueOf(start));
            
            boolean[] visited = new boolean[n+1];
            
            int cnt = dfs(1, visited);
            diff = Math.min(diff, (Math.abs(cnt - (n - cnt))));
            
            list[start].add(end);
            list[end].add(start);
        }
        
        return diff;
    }
    
    static int dfs(int num, boolean[] visited){
        visited[num] = true;
        int cnt = 1;
        
        for(int next : list[num]){
            if(!visited[next]){
                cnt += dfs(next, visited);
            }
        }
        
        return cnt;
    }
}