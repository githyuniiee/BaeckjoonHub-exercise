import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
     
        //잃어버린 사람 빼기
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //여벌을 챙겨온 사람이 도난당한 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(reserve[j] == lost[i]){
                    answer++;
                    lost[i] = reserve[j] = -1;
                    break;
                    
                }
            }
        }
        
        //체육복을 return
        for(int lostPerson : lost) {
            for(int i=0; i<reserve.length; i++){
                if(reserve[i] == lostPerson +1 || reserve[i] == lostPerson -1){
                    answer ++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        return answer;

    }
}