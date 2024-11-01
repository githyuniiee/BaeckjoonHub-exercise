import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ", -1);
        
        for(int i = 0; i < str.length; i++) {
            if (str[i].length() > 0) {
                String s1 = str[i].substring(0, 1).toUpperCase();
                String s2 = str[i].substring(1).toLowerCase();
                answer += s1 + s2;
            }
            
            // 마지막 단어가 아닐 경우에만 공백 추가
            if (i < str.length - 1) {
                answer += " ";
            }
        }
        
        return answer;
    }
}
