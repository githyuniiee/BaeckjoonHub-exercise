import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
       
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum_q1 = 0;
        long sum_q2 = 0;
        
        for(Integer a : queue1){
            q1.add(a);
            sum_q1+= a;
        }
        
        for(Integer a : queue2){
            q2.add(a);
            sum_q2+= a;
        }
        
        int iter = (q1.size() + q2.size()) * 2;
        int count = 0;
        
        if((sum_q1 + sum_q2) % 2 != 0){
            return -1;
        }
        
        while(sum_q1 != sum_q2){
            if(q1.isEmpty() || q2.isEmpty()){
                return -1;
            }
            if(sum_q1 > sum_q2){
                int first = q1.remove();
                q2.add(first);
                sum_q1 -= first;
                sum_q2 += first;
            }else if(sum_q1 < sum_q2){
                int first = q2.remove();
                q1.add(first);
                sum_q2 -= first;
                sum_q1 += first;
            }
            if(count > iter){
                return -1;
            }
            count++;
        }
        
        return count;

    }
}