import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 1;
        int i = 0;
        int cov = 2*w + 1;
        
        while(index <= n){
            
            if(i<stations.length && stations[i] - w <= index){
                index = stations[i] + w + 1;
                i++;
            }else{
                answer++;
                index += cov;
            }
        }
        return answer;
    }
}