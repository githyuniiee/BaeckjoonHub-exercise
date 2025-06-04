import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> list;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            
            list.get(start).add(end);
            list.get(end).add(start);
        }
        
        for(int i=0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            
            boolean[] visited = new boolean[n+1];
            
            //삭제
            list.get(start).remove(Integer.valueOf(end));
            list.get(end).remove(Integer.valueOf(start));
            
            int cnt = dfs(1, visited);
            int remain = Math.abs(n - cnt);
            answer = Math.min(answer, Math.abs(cnt - remain));
            
            //되돌리기
            list.get(start).add(end);
            list.get(end).add(start);
        }
        return answer;
    }
    
    static int dfs(int num, boolean[] visited){
        visited[num] = true;
        int cnt = 1;
        
        for(int next : list.get(num)){
            if(!visited[next]){
                cnt += dfs(next, visited);
            }
        }
        
        return cnt;
    }
}