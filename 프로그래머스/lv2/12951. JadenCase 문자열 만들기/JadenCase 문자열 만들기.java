import java.util.*;

class Solution {
    public String solution(String s) {
       
        int len = s.length();
        ArrayList<Character> arr = new ArrayList<Character>();
        
        for(int i = 0; i< len-1; i++){
        arr.add(s.charAt(i));
        }
        
        if('a' <= arr[0] && arr[0] <='z'){
        arr[0] -= 32;
        
        for(int i=0; i<arr.length; i++){
        
        if(arr[i] == ""){
        if('a' <= arr[i+1] && arr[i+1] <= 'z'){
        arr[i+1] -= 32;
        }
        }
        }
        
        }
        
        String answer = new String(arr);
        
        return answer;
    }
}