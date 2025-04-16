import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        
        boolean containsTarget = false;
        for(String word : words){
            if(word.equals(target)){
                containsTarget = true;
                break;
            }
        }
        
        if(!containsTarget) return 0;
        
        dfs(begin, target, words, 0);
        
        
        return answer;
    }
    
    static void dfs(String begin, String target, String[] words, int cnt){
        
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }
        
        
        for(int i=0; i<words.length; i++){
            String str = words[i];
            
            if(!visited[i]){
                int c = 0;
                
                for(int j=0; j<begin.length(); j++){
                   if(str.charAt(j) == begin.charAt(j)){
                       c++;
                   }
                }
                
                
                if(c == str.length() - 1){
                    visited[i] = true;
                    dfs(str, target, words, cnt + 1);
                    visited[i] = false;
                }
                
            }
            
            
        }
       
        
        
    }
}