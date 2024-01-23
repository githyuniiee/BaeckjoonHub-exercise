import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
   
        Queue<Integer> queue = new LinkedList<>();
    
        
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == arr[i+1]){
                arr[i] =10;
            }
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] < 10){
                queue.add(arr[i]);
            }
        }
        
        int[] arr2 = new int[queue.size()];
        
        int i=0;
        while(!queue.isEmpty()){
            arr2[i++] = queue.poll();
        }
        return arr2;
        
        
    }
}