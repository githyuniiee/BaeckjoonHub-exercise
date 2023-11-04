import java.lang.*;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder stb = new StringBuilder();
        
        for(int i=0; i<my_string.length() ; i++){
            
            char c = my_string.charAt(i);
            
            for(int j=0; j<n; j++){
                stb = stb.append(c);
            }
        }
        String answer = stb.toString();
        return answer;
    }
}