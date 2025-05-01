import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a,b) -> a[2] - b[2]); //비용 기준 정렬
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        int answer = 0;
        for(int[] edge : costs){
            if(union(edge[0], edge[1])){
                answer += edge[2];
            }
        }
        return answer;
    
    }
    
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
        
    }
    
    static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb) return false;
        parent[pa] = pb;
        return true;
    }
    
  
}