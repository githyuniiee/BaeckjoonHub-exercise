import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
       
        Arrays.sort(score);
        ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;
        
        for(int i=score.length-1; i>=0; i--){
            list.add(score[i]);
            if(list.size() >= m){
                answer+= (list.get(m-1)*m*1);
                list.clear();
            }
        }
        
        return answer;
        
    }
}