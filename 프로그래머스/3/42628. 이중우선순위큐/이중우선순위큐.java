import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        
        Queue<Integer> maxQ = new PriorityQueue<>((o1,o2) -> o2 - o1);
        Queue<Integer> minQ = new PriorityQueue<>();
        
        for(int i=0; i<operations.length; i++){
            String[] str = operations[i].split(" ");
            
            if(str[0].equals("I")){
                maxQ.offer(Integer.parseInt(str[1]));
                minQ.offer(Integer.parseInt(str[1]));
            }else if(str[0].equals("D") && str[1].equals("-1") && !minQ.isEmpty()){
                maxQ.remove(minQ.poll());
            }else if(str[0].equals("D") && str[1].equals("1") && !maxQ.isEmpty()){
                minQ.remove(maxQ.poll());
            }
        }
        
        answer[0] = !maxQ.isEmpty() ? maxQ.poll() : 0;
        answer[1] = !minQ.isEmpty() ? minQ.poll() : 0;
                
        return answer;
    }
}