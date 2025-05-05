import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            if(!total.containsKey(genres[i])){
                HashMap<Integer, Integer> m = new HashMap<>();
                total.put(genres[i], plays[i]);
                m.put(i, plays[i]);
                map.put(genres[i], m);
            }else{
                total.put(genres[i], total.get(genres[i]) + plays[i]);
                map.get(genres[i]).put(i, plays[i]);
            }
        }
        
        List<String> keySet = new ArrayList<>(total.keySet());
        Collections.sort(keySet, (o1,o2) -> total.get(o2) - total.get(o1));
        
        for(String key : keySet){
            
            HashMap<Integer, Integer> m = map.get(key);
            
            List<Integer> list = new ArrayList<>(m.keySet());
            Collections.sort(list, (o1,o2) -> m.get(o2) - m.get(o1));
            
            answer.add(list.get(0));
            
            if(list.size() > 1){
                answer.add(list.get(1));
            }
        }
        
        int[] ans = new int[answer.size()];
        
        for(int i=0; i<ans.length; i++){
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
}