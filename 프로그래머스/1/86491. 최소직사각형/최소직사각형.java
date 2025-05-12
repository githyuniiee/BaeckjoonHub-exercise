import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int maxWidth = 0;
        int maxHeigth = 0;
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            
            maxWidth = Math.max(maxWidth, sizes[i][0]);
            maxHeigth = Math.max(maxHeigth, sizes[i][1]);
        }
        
        
        return maxWidth*maxHeigth;
    }
}