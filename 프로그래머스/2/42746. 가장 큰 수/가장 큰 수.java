import java.util.*;

class Solution {
    public String[] solution(int[] numbers) {
        
        String[] arr = new String[numbers.length*(numbers.length-1)];
        ArrayList<Integer> arr2 = new ArrayList<>();
        
        String str = "";
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<numbers.length; j++){
                String num = Integer.toString(numbers[j]);
                str += num;
            }
            arr[i] = str;
            str = "";
        }
        
        return arr;
        
    }
}