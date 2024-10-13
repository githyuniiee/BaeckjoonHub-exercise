import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        list.add(k);
        
        while(k != 1){
            if(k % 2 == 0){
                k = k/2;
            }else{
                k = (k*3) + 1;
            }
            
            list.add(k);
        }
        
        int max_X = 0;
        for(int i=0; i<list.size()-1; i++){
            int x1 = i;
            int y1 = list.get(i);
            int x2 = i+1;
            int y2 = list.get(i+1);
            max_X = Math.max(max_X, x2);
            double s = (y1+y2)*(x2-x1)/2.0;
            list2.add(s);
        }
        
        
        for(int i=0; i<ranges.length; i++){
            int x1 = ranges[i][0];
            int x2 = max_X + ranges[i][1];
            
             
            if(x2 < x1){
                answer[i] = -1.0;
            }else if(x2 == x1){
                answer[i] = 0.0;
            }else{
                double sum = 0;
                for(int j=x1; j<x2; j++){
                    sum += list2.get(j);
                }
                answer[i] = sum;
            }
        }
        
        
        return answer;
    }
}