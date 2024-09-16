import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        
        //q1 사이즈
        for(int i : queue1){
            q1.add(i);
            sum1 += i;
        }
        
        //q2 사이즈
        for(int i : queue2){
            q2.add(i);
            sum2 += i;
        }
        
        long sum = sum1 + sum2;
        
        if(sum % 2 !=0) return -1;
        
        //원하는 값
        long goal = sum/2;
        int maxOperation = (q1.size() + q2.size()) * 2 ;
        int operations = 0;
        
        while(sum1 != goal && operations <= maxOperation){
            
            if(sum1 > goal){
                int n = q1.poll();
                q2.add(n);
                sum1 -= n;
                sum2 += n;
                answer++;
                operations++;
            }
            
            if(sum2 > goal){
                int n = q2.poll();
                q1.add(n);
                sum1 += n;
                sum2 -= n;
                answer++;
                operations++;
            }
            
            
            
        }
        
        
        
        
        
        return (sum1 == goal) ? answer : -1;
    }
}