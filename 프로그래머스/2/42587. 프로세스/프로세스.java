import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            q.add(i);
        }
        
        while(true){
            
            int now = q.poll();
            
            boolean hasHigh = false;
            
            for(int next : q){
                if(priorities[next] > priorities[now]){
                    hasHigh = true;
                    break;
                }
            }
            
            
            if(!hasHigh){
                answer++;
                
                if(now == location){
                    return answer;
                }
            }else{
                q.add(now);
            }
        }

    }
}