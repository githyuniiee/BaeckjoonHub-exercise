import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K){
            int first = pq.poll();
            int two = pq.poll();
            
            int num = first + (two * 2);
            
            pq.offer(num);
            answer++;
            
            if(pq.size() == 1 && pq.peek() < K){
                answer = -1;
                break;
            }
            
            
        }
        return answer;
    }
}