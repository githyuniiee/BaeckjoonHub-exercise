import java.util.*;
class Solution {
    public int solution(String s) {
        
        List<Character> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            list.add(s.charAt(i));
        }
        
        for(int i=0; i<s.length(); i++){
            
            for(int j=0; j<s.length(); j++){
                
                if(stack.isEmpty()){
                    stack.push(list.get(j));
                }else{
                    if((stack.peek() == '[' && list.get(j) == ']')
                       || (stack.peek() == '(' && list.get(j) == ')')
                       || (stack.peek() == '{' && list.get(j) == '}')){
                        stack.pop();
            
                    }else{
                        stack.push(list.get(j));
                    }
                        
                    }
                }
            
            
            if(stack.isEmpty()){
                answer++;
            }
            stack.clear();
            
            list.add(list.get(0));
            list.remove(0);
        }
            
        return answer;
    }
}