import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(Integer key : nums){
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        for(Integer key : map.keySet()){
            answer++;
        }
        
        if(answer > (nums.length/2)) {
            answer = (nums.length/2);
        }
        
        return answer;
    }
}