import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        int answer = 0;
        parent = new int[n];
        
        Arrays.sort(costs, (o1,o2) -> o1[2] - o2[2]);
        
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        for(int i=0; i<costs.length; i++){
            if(union(costs[i][0], costs[i][1])){
                answer += costs[i][2];
            }
        }
               
        return answer;
    }
    
    static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb) return false;
        parent[pa] = pb;
        return true;
    }
    
    static int find(int x){
        if(parent[x] == x) return x;
        
        return find(parent[x]);
    }
}