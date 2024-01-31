import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        
        int min = arr[0];
        
        for(int i = 0; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        if(arr.length == 1){
            list.add(-1);
        }else{
        for(int num : arr){
            if(num == min) continue;
            list.add(num);
        }
        }
        
        int[] answer = new int[list.size()];
        
     
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        
      
        return answer;
    }
}