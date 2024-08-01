import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
    
        PriorityQueue<Integer> min = new PriorityQueue<>(); //오름차순
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        int[] answer = new int[2];
        
        for(String str : operations){
            String[] arr = str.split(" ");
            int num = Integer.parseInt(arr[1]);
         
            if(arr[0].equals("I")){
                min.add(num);
                max.add(num);
                
                continue;
            }
            
            if(arr[0].equals("D") && !min.isEmpty() && arr[1].equals("1")) {
                
                int a = max.poll();
                min.remove(a);
            }else if(arr[0].equals("D") && !max.isEmpty() && arr[1].equals("-1")){
                
                int a = min.poll();
                max.remove(a);
            }
        }
        
        
        if(min.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        
        answer[0] = max.poll();
        answer[1] = min.poll();
        
        return answer;
        
        
    }
}