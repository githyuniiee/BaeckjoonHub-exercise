import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int a : scoville){
            queue.add(a);
        }
        
      
        int result = 0;
        
        while(queue.peek() <K) {
            if(queue.size() >= 2){
                queue.add(queue.poll() + (queue.poll() *2));
                result++;
            }else{
                return -1;
            }
            
        }
        
        
        return result;
        
    }
}