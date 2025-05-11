import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] arr = new int[n+1][n+1];
        
        for(int i=0; i<results.length; i++){
            int win = results[i][0];
            int lose = results[i][1];
            
            arr[win][lose] = 1;
            arr[lose][win] = -1;
        }
        
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                for(int k=0; k<arr.length; k++){
                    if(arr[i][j] == 1 && arr[j][k] == 1){
                        arr[i][k] = 1;
                        arr[k][i] = -1;
                    }
                    
                    if(arr[i][j] == -1 && arr[j][k] == -1){
                        arr[i][k] = -1;
                        arr[k][i] = 1;
                    }
                }
            }
        }
        
        
        for(int i=0; i<arr.length; i++){
            int cnt = 0;
            for(int j=0; j<arr.length; j++){
                if(arr[i][j] != 0){
                    cnt++;
                }
            }
            
            if(cnt == n-1) answer++;
        }
        
        
        
        return answer;
    }
}