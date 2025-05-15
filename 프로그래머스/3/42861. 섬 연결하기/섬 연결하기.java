import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1,o2) -> o1[2] - o2[2]);
        
        for(int i=0; i<costs.length; i++){
            if(union(costs[i][0], costs[i][1])){
                answer += costs[i][2];
            }
        }
        
        
        return answer;
    }
    
    static boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        
        if(px == py) return false;
        
        parent[px] = py;
        return true;
    }
    
    static int find(int a){
        if(parent[a] == a) return a;
        
        return find(parent[a]);
    }
}