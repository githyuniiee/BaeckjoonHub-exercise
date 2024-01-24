import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
      
        ArrayList<Integer> arr =new ArrayList<>();
        int[] answer = new int[commands.length];
        
        for(int l=0; l<commands.length; l++){
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            //i부터 j까지
            for(int a = i-1 ; a < j; a++){
                arr.add(array[a]);
            }
            
            //정렬
            Collections.sort(arr);
            
            //반환 배열
            answer[l] = arr.get(k-1);
            arr.clear();
            
            
        }
        return answer;
    }
}