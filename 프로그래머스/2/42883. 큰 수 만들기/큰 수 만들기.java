import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        
        for(int i=0; i<number.length(); i++){
            
            char ch = number.charAt(i);
                     
            while(!stack.isEmpty() && k > 0 && (stack.peek() < ch)){
                    stack.pop();
                    k--;
            }
                 
            stack.push(ch);
                
        }
        
        for(int i=0; i<stack.size()-k; i++){
            sb.append(stack.get(i));
        }
        
        return sb.toString();
    }
}