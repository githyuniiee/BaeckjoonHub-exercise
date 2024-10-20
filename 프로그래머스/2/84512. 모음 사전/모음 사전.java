import java.util.*;
class Solution {
    
    static List<String> list;
    static String[] words = new String[]{"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        
        list = new ArrayList<>();
        dfs("", 0);
        
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)){
                return i;
            }
        }        
        
        
        return -1;
    }
    
    static void dfs(String str, int len){
        list.add(str);
        if(len == 5){
            return;
        }
        
        for(int i=0; i<5; i++){
            dfs(str + words[i], len + 1);
        }
    }
}