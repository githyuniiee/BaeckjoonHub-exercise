import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hm = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            hm.put(key, hm.getOrDefault(key,0) + 1);
        }
        
        for(String key : hm.keySet()){
            answer *= hm.get(key) +1;
        }
        return answer - 1;
    }
}