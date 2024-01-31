import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                list.add(arr[i]);
            }
        }
        
         if(list.size() != 1){
            list.remove(0);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}