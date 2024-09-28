import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int total = tangerine.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int a : map.values()){
            list.add(a);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        int sum = 0;
        
        for(int a : list){
            if(sum >= k){
                break;
            }
            
            sum += a;
            answer++;
        }
        
        
        return answer;
    }
}