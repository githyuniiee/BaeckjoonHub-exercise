import java.util.*;

class Solution {

    static boolean[] visited;
    static int len;
    static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        
        len = words.length;
        visited = new boolean[len];
        
        dfs(begin, target, 0, words);
        
        answer = answer == Integer.MAX_VALUE ? 0 : answer;
        return answer;
    }
    
    static void dfs(String begin, String target, int depth, String[] words){
        
        if(depth == len){
            return;
        }
        
        if(begin.equals(target)){
            answer = Math.min(answer, depth);
            return;
        }
        
        for(int i=0; i<len; i++){
            if(!visited[i]){
                String str = words[i];
                int cnt = 0;
                for(int j=0; j<str.length(); j++){
                    if(begin.charAt(j) == str.charAt(j)){
                        cnt++;
                    }
                }
                
                if(cnt == str.length() - 1){
                    visited[i] = true;
                    dfs(str, target, depth + 1, words);
                    visited[i] = false;         
                }
            }
        }
    }
}