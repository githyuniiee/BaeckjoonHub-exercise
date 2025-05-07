import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        int[] day = new int[speeds.length];
        
        for(int i=0; i<speeds.length; i++){
            
            int num = (100 - progresses[i]) % speeds[i];
            
            if(num == 0){
                day[i] = (100 - progresses[i]) / speeds[i];
            }else{
                day[i] = (100 - progresses[i]) / speeds[i] + 1; 
            }
        }
        
        int max = 0;
        for(int i=0; i<day.length; i++){
            
            if(stack.isEmpty()){
                stack.push(day[i]);
                max = day[i];
            }else{
                if(day[i] <= max){
                    stack.push(day[i]);
                }else{
                    list.add(stack.size());
                    stack.clear();
                    stack.push(day[i]);
                    max = day[i];
                }
            }
        }
        
        if(!stack.isEmpty()) list.add(stack.size());
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}