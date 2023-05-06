class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int dev = 1000000007;
        int[][] path = new int[n+1][m+1];
        path[1][1] = 1;
      
        
         // 웅덩이 초기화
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][1];
            int y = puddles[i][0];
            
            path[x][y] = -1;
        }
        
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(path[i][j] == -1) continue;
                if(path[i-1][j] > 0) path[i][j] += path[i-1][j] % dev;
                if(path[i][j-1] > 0) path[i][j] += path[i][j-1] % dev;
                   
                   
            }
        }
                   
        int answer = path[n][m] % dev;
        
        return answer;
        
    }
}