import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int start = 0;
        
        for(int i=people.length-1; i>=0; i--){
            for(int j=start; j<=i; j++){
                
                if(people[j] != -1){
                    if(people[i] + people[j] <= limit){
                        people[i] = -1;
                        people[j] = -1;
                        answer++;
                    }else{
                        people[i] = -1;
                        answer++;
                    }
                    start = j;
                    break;
                }
            }
        }
        
        return answer;
    }
}