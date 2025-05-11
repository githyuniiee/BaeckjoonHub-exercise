import java.util.*;

class Solution {
    
    static int[] count;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    static int max = 0;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        count = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++){
            int start = edge[i][0];
            int end = edge[i][1];
            
            list.get(start).add(end);
            list.get(end).add(start);
        }
        
        bfs(1);
        
        // System.out.println(max);
        
        for(int num : count){
            if(num == max){
                answer++;
            }
        }
        
        return answer;
    }
    static void bfs(int a){
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        visited[a] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i : list.get(now)){
                if(!visited[i]){
                    visited[i] = true;
                    count[i] = count[now] + 1;
                    q.add(i);
                }
            }
            max = Math.max(max, count[now]);
        }
        
    }
}