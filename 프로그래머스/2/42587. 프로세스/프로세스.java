import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> loc = new LinkedList<>();
        Queue<Integer> pri = new LinkedList<>();
        
        for(int i=0; i< priorities.length; i++){
            loc.add(i);
            pri.add(priorities[i]);
        }
        
        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        
        
        while(idx >= 0){
            
            if(pri.peek() < priorities[idx]){
                loc.add(loc.poll());
                pri.add(pri.poll());
            }
            
            if(pri.peek() == priorities[idx]){
                
                int currentLoc = loc.poll();
                pri.poll();
                answer++;
                idx--;
                if(currentLoc == location){
                    break;
                }
            }
            
            
           
        }
        
        return answer;
    }
}