import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        //체육복 갖고 있는 학생 초기화
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //도난당했지만, 여벌 있는 학생
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        
        
        //옷 빌려주기
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(reserve[j] == lost[i] - 1|| reserve[j] == lost[i] + 1){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;

    }
}