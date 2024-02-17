import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
       int[] answer = new int[N];
        Map<Integer, Double> fail = new HashMap<>();
        
        for(int i=1; i<= N; i++) {
            int challenger = 0; //도전자 수
            int failUser = 0; //실패한 사용자 수
            for(int j=0; j< stages.length; j++){
                if(i <= stages[j]){
                    challenger++;
                }
                if(i == stages[j]) {
                    failUser++;
                }
            }
            
            fail.put(i, challenger == 0 ? 0 : ((double) failUser / challenger));
        }
        
        //실패율 정렬
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(fail.entrySet());
        entryList.sort((o1, o2) -> {
            if(o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            } else {
                return o2.getValue(). compareTo(o1.getValue());
            }
        });
        
        //결과 반환
        int idx = 0;
        for(Map.Entry<Integer, Double> map : entryList) {
            answer[idx++] = map.getKey();
        }
        
        return answer;
        
    }
}