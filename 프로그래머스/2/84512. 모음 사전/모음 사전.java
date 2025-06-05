import java.util.*;

class Solution {
    static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    static int answer = 0;
    static int cnt = 0;
    
    public int solution(String word) {
        
        dfs(0, "", word);
        return answer;
    }
    
    static void dfs(int depth, String str, String word){
        
        if(str.equals(word)){
            answer = cnt;
            return;
        }
        
        cnt++;
        
        if(depth >= 5){
            return;
        }
        
        for(int i=0; i<alpha.length; i++){
            dfs(depth + 1, str + alpha[i], word);
        }
        
    }
}