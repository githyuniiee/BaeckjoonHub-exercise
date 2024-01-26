import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
    
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i=0; i<operations.length; i++){
            if(operations[i].charAt(0) == 'I'){
                
                //문자 -> 숫자
                String str = operations[i].substring(2, operations[i].length());
                int val = Integer.parseInt(str);
                
                //큐 삽입
                queue.add(val);
                
                
            }else if(operations[i].charAt(0) == 'D' && operations[i].charAt(2) == '1'){
                
                // 큐에서 최댓값 삭제
                if(!queue.isEmpty()) {
                    queue.remove(Collections.max(queue));
                }
                
            }else{
                
               //최솟값 삭제
                if(!queue.isEmpty()){
                    queue.poll();
                }
    
                
            }
            
        }
        
        int[] answer = new int[2];
        
        
        //큐에서 최댓값 최솟값 
        if(queue.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = Collections.max(queue);
            answer[1] = Collections.min(queue);
        }
        
        return answer;
        
    }
}