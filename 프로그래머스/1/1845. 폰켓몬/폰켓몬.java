import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int num = nums.length / 2;
        
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        if(set.size() >= num){
            answer = num;
        }else{
            answer = set.size();
        }
        return answer;
    }
}