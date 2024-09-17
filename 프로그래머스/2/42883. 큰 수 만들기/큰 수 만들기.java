import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        char[] ch = number.toCharArray();
        
        int len = number.length() - k;
        
        int start = 0;
        for(int i=0; i<len; i++){
            char c = '0';
            for(int j=start; j<= i+k; j++){
                if(ch[j] > c){
                    c = ch[j];
                    start = j + 1;
                }
            }
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}