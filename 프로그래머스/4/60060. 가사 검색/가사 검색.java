import java.util.*;

class Solution {
    
    class Trie {
        Map<Integer, Integer> lenMap = new HashMap<>();
        Trie[] child = new Trie[26];
        
        void insert(String str){
            Trie node = this;
            int len = str.length();
            
            //현재 길이의 단어 개수 증가
            node.lenMap.put(len, node.lenMap.getOrDefault(len,0) + 1);
            
            for(int i=0; i<len; i++){
                int idx = str.charAt(i) - 'a';
                if(node.child[idx] == null){
                    node.child[idx] = new Trie();
                }
                
                node = node.child[idx];
                node.lenMap.put(len, node.lenMap.getOrDefault(len,0) + 1);
            }
        }
        
        int search(String str){
            Trie node = this;
            int len = str.length();
            
            for(int i=0; i<len; i++){
                if(str.charAt(i) == '?'){
                    return node.lenMap.getOrDefault(len,0);
                }
                
                int idx = str.charAt(i) - 'a';
                if(node.child[idx] == null){
                    return 0;
                }
                
                node = node.child[idx];
            }
            
            return node.lenMap.getOrDefault(len, 0);
        }
    }
    
    
    public int[] solution(String[] words, String[] queries) {
        Trie[] tries = new Trie[10001];
        Trie[] reverseTries = new Trie[10001];
        
        
        
        for(String word : words){
            int len = word.length();
            if(tries[len] == null){
                tries[len] = new Trie();
                reverseTries[len] = new Trie();
            }
            
            tries[len].insert(word);
            reverseTries[len].insert(new StringBuilder(word).reverse().toString());
            
        }
        
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            String query = queries[i];
            int len = query.length();
            
            if(tries[len] == null){
                answer[i] = 0;
                continue;
            }
            
            if(query.charAt(0) != '?'){
                answer[i] = tries[len].search(query);
            }else {
                answer[i] = reverseTries[len].search(
                new StringBuilder(query).reverse().toString());
            }
        }
        
        return answer;
    }
}