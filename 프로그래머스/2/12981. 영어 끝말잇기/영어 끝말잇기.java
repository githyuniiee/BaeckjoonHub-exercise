import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        int num = 1;
        int cnt = 1;
        
        for(int i=1; i<words.length; i++){
            num++;
            
            if(map.containsKey(words[i]) ||
              words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)){
                answer[0] = num;
                answer[1] = cnt;
                break;
                
            }
            
            map.put(words[i],1);
            
            if(num >= n) {
                num = 0;
                cnt++;
            }
        }

        return answer;
    }
}