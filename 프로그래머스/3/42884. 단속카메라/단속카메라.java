import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (o1,o2) -> o1[1] - o2[1]);
        
        int now = Integer.MIN_VALUE;
        int answer = 0;
        
        
        for(int i=0; i<routes.length; i++){
            
            if(routes[i][0] <= now && now <= routes[i][1]){
                continue;
            }else{
                now = routes[i][1];
                answer++;
            }
            
        }
        return answer;
    }
}