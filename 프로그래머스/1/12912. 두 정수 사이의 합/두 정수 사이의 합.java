
class Solution {
    public long solution(int a, int b) {
        
        if(a == b){
            return a;
        }
        int minVal = Math.min(a, b);
        int maxVal = Math.max(a, b);
        
        long sum = 0;
        
        for(int i = minVal; i<= maxVal; i++){
           
            sum += i;
        }
        
        return sum;
    }
}