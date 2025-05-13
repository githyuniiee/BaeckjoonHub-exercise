import java.util.*;

class Solution {
    
    static char alpha[] = new char[]{'A','E','I','O', 'U'};
    static int answer = 0;
    static int idx = 0;
    
    public int solution(String word) {
        
        dfs("", word);
        return answer;
    }
    
    static void dfs(String str, String word){
        
        if(str.length() > 5) return;
        
        if(str.equals(word)){
            answer = idx;
            return;
        }
        
        idx++;
        
        for(int i=0; i<alpha.length; i++){
            dfs(str + alpha[i], word);
        }
        
    }
}