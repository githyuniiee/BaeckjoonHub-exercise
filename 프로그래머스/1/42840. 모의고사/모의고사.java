import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] p1 = new int[answers.length];
        int[] p2 = new int[answers.length];
        int[] p3 = new int[answers.length];
        
        int val = 1;
        //1번, 2번, 3번 찍은 영역 배열에 담기
        for(int i=0; i<answers.length; i++){
            p1[i] = val;
            val++;
            if(val > 5){
                val = 1;
            }
        }
        
        int[] arr = new int []{2,1,2,3,2,4,2,5};
        val = 0;
        for(int i=0; i<answers.length; i++){
            p2[i] = arr[val];
            val++;
            if(val > 7) {
                val = 0;
            }
        }
        
        int[] arr2 = new int []{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        val = 0;
        for(int i=0; i<answers.length; i++){
            p3[i] = arr2[val];
            val++;
            if(val > 9) {
                val = 0;
            }
        }
        
        //각 배열 답과 비교
        int result1 = 0;
        int result2 = 0;
        int result3 = 0;
        for(int i=0; i<p1.length; i++){
            if(p1[i] == answers[i])
                result1++;
            if(p2[i] == answers[i])
                result2++;
            if(p3[i] == answers[i])
                result3++;
        }
        
        //개수 비교
        int max = Math.max(result1, Math.max(result2,result3));
        List<Integer> resultList = new ArrayList<>();
        
        if(max == result1) resultList.add(1);
        if(max == result2) resultList.add(2);
        if(max == result3) resultList.add(3);
        
        int[] resultArray = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++){
            resultArray[i] = resultList.get(i);
        }
        

    
        
        return resultArray;
    }
}