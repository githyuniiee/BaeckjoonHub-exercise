import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            int num = 100 - progresses[i];
            
            if(num % speeds[i] == 0){
                num /= speeds[i];
            }else{
                num = (num/speeds[i]) + 1;
            }
            
            q.add(num);
        }
        
        
        while(!q.isEmpty()){
            int num = q.poll();
            int count = 1;
            
            while(!q.isEmpty() && q.peek() <= num){
                q.poll();
                count++;
            }
            
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
    
        
        
        return answer;
    }
}