import java.util.*;

class Solution {
    public int  solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int cnt = 0; //최솟값 카운트
        
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        ArrayList<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList, Collections.reverseOrder());
        
        for(int v : valueList){
            if(sum + v >= k){
                cnt++;
                break;
            }else{
                sum += v;
                cnt++;
            }
        }
        
        
        
        return cnt;
    }
}