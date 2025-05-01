import java.util.*;

class Solution {
    
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        
        Arrays.sort(costs, (o1,o2) ->o1[2] - o2[2]);
        
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        
        for(int i=0; i<costs.length; i++){
            if(union(costs[i][0], costs[i][1])){
                answer += costs[i][2];
            }
        }
        
        
        return answer;
    }
    
    static int find(int x){
        if(parents[x] == x) return x;
        
        return find(parents[x]);
    }
    
    static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb) return false;
        parents[pa] = pb;
        return true; 
    }
}