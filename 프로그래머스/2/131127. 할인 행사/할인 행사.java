import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int num = 0;
        
        for(int i=0; i<want.length; i++){
            map1.put(want[i], number[i]);
            num += number[i];
        }
        
        for(int i=0; i<num; i++){
            map2.put(discount[i], map2.getOrDefault(discount[i], 0) + 1);
        }
        
        int idx = 0;
        for(int i=num; i<=discount.length; i++){
            
            boolean isMatch = true;
            
            for(String key : map1.keySet()){
                if(map1.get(key) != map2.getOrDefault(key, 0)){
                    isMatch = false;
                    break;
                }
            }
            
            if(isMatch) answer++;
            
            if(i == discount.length){
                break;
            }
            
            map2.put(discount[idx], map2.get(discount[idx]) - 1);
            if(map2.get(discount[idx]) == 0){
                map2.remove(discount[idx]);
            }
            map2.put(discount[i], map2.getOrDefault(discount[i], 0) + 1);
            idx++;
        }
        
        
        return answer;
    }
}