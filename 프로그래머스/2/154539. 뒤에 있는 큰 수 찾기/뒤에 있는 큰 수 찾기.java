import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++){
            
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.peek()] = numbers[i];
                stack.pop();
            }
            stack.push(i);
        }
        
        for(int i=0; i<answer.length; i++){
            if(answer[i] == 0){
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}