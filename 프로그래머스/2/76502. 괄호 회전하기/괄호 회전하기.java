import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        
        for(int i=0; i<s.length(); i++){
            
            Stack<Character> stack = new Stack<>();
            String str = s.substring(i,s.length()) + s.substring(0,i);
            for(int j=0; j<str.length(); j++){
                
                
                if(stack.isEmpty()){
                    stack.push(str.charAt(j));
                }else{
                    if(stack.peek() == '(' && str.charAt(j) == ')'){
                        stack.pop();
                    }else if(stack.peek() == '[' && str.charAt(j) == ']'){
                        stack.pop();
                    }else if(stack.peek() == '{' && str.charAt(j) == '}'){
                        stack.pop();
                    }else{
                        stack.push(str.charAt(j));
                    }
                }
            }
            
            if(stack.isEmpty()){
               answer++; 
            }
        }        
        return answer;
    }
}