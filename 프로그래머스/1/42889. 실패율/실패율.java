import java.util.*;
class Solution {
    public  int[] solution(int N, int[] stages) {
        double[] failRate = new double[N];
        double remain = stages.length;
        int stage = 1; //현재 스테이지
        double failNum; //각 스테이지 별 실패 한 사용자 수
        int[] answer = new int[N];
        
        for(int j=0; j<N; j++){
            failNum = 0;
            for(int i=0; i<stages.length; i++){
            
            if(stages[i] == stage){
                failNum ++;
            }
            }
            if(remain != 0){
            failRate[j] =  failNum / remain;
            remain -= failNum;
            } else{
                failRate[j] = 0;
            }
            stage++;
        }
        
        //Map에 담기
        Map<Integer, Double> map = new HashMap<>();
        
        for(int i=0; i<N; i++){
            map.put(i+1, failRate[i]);
        }
        
        // value 기준 내림차순 정렬
        List<Integer> sortedKeys = new ArrayList<>(map.keySet());
        sortedKeys.sort(Comparator.comparingDouble(map::get).reversed());
        
        // List<Double> valueList = new ArrayList<>(map.values());
        // valueList.osrt((v1, v2) -> v2.compareTo(v1));
        
        int index = 0;
        for(Integer num : sortedKeys){
            answer[index++]= num;
        }
        
        
        return answer;
    
    }
}