import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
      
        int result = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        
        for(String key : map.keySet()){
            result *= (map.get(key)+1); //안 입는 경우 고려해 +1
        }
        
        result -= 1;
        
        return result;
      
        
    }
}