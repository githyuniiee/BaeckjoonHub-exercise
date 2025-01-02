import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(stack.isEmpty()){
                if(ch == ')'){
                    answer = false;
                    break;
                }else{
                    stack.push(ch);
                    continue;
                }
            }else{
                if(ch == ')'){
                    stack.pop();
                    continue;
                }else{
                    stack.push(ch);
                }
            }
        }
        
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}