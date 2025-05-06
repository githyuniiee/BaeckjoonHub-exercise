import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int row = 0;
        int col = 0;
        
        for(int i=1; i<= yellow; i++){
            int y_row = yellow / i;
            int y_col = i;
            
            if(y_row < y_col) break;
            
            int b_row = y_row*2;
            int b_col = (y_col + 2) *2;
            
            if(b_row + b_col == brown){
                row = y_row + 2;
                col = y_col + 2;
            }
        }
        
        answer[0] = row;
        answer[1] = col;
        
        
        return answer;
    }
}