import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Queue<String> c1 = new LinkedList<>();
        Queue<String> c2 = new LinkedList<>();
        
        for(String str : cards1){
            c1.add(str);
        }
        
        for(String str : cards2) {
            c2.add(str);
        }
        
        int len = 0;
        String answer = "Yes";
        while(len < goal.length){
            
            if(!c1.isEmpty() && c1.peek().equals(goal[len])){
                c1.poll();
                len++;
            }else if(!c2.isEmpty() && c2.peek().equals(goal[len])){
                c2.poll();
                len++;
            }else{
                answer = "No";
                return answer;
            }
        }
        
        return answer;
        
        
    }
}