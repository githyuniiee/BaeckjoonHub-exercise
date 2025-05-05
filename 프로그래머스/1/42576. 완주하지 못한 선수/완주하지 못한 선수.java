import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<participant.length; i++){
            String name = participant[i];
            
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for(int i=0; i<completion.length; i++){
            String name = completion[i];
            
            if(map.containsKey(name) ){
                map.put(name, map.getOrDefault(name, 0) - 1);
                
                if(map.get(name) == 0){
                    map.remove(name);
                }
            }
            
        }
        
        for(String name : map.keySet()){
            answer += name;
        }
        return answer;
    }
}