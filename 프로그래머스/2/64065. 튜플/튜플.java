import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] strs = s.replaceAll("[{}]","").split(",");
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(String st : strs){
            int num = Integer.parseInt(st);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a,b) -> b.getValue() - a.getValue());
        
        int[] answer = new int[entryList.size()];
        for(int i=0; i<entryList.size(); i++){
            answer[i] = entryList.get(i).getKey();
        }
        
        return answer;
    }
}