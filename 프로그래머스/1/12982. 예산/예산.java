import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        
        Arrays.sort(d);
        int sum =0;
        int num = 0;
        
        for(int i=0; i<d.length; i++){
            sum += d[i];
            num++;
            if(sum > budget){
                num--;
                break;
            }
        }
        
        return num;
    }
}