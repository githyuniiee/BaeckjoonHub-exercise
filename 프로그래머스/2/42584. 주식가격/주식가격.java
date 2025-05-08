import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
            
            
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                
                int x = stack.pop();
                answer[x] = i - x;  
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            
            int x = stack.pop();
            answer[x] = prices.length - x - 1;
        }
        
        return answer;
    }
}