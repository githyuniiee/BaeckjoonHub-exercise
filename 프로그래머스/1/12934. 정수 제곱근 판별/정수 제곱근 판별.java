
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        Double a = Math.sqrt(n);
        if(a == a.intValue()) {
            return (long)Math.pow(a+1,2);
        }else{
        return -1;
        }
    }
}