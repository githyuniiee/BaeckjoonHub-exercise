import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                
                //case 1 : 가장 왼쪽
                if(j == 0){
                    triangle[i][0] += triangle[i-1][0];
                    continue;
                }
                
                
                
                //case 2 : 가장 우측
                if(j == triangle[i].length - 1){
                    triangle[i][j] += triangle[i-1][triangle[i-1].length -1];
                    continue;
                }
                
                
                //case 3 : 가운데
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                
            }
        }
        
        for(int a : triangle[triangle.length - 1]){
            answer = Math.max(answer, a);
        }
        
        return answer;
    }
}