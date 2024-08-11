class Solution {
    public int solution(int n) {
        
        int answer = fibo(n);
        
        return answer;
    }
    
    static int fibo(int num){
        int[] cache = new int[num+1];
        
        cache[0] = 0;
        cache[1] = 1;
        
        for(int i=2; i<=num; i++){
            cache[i] = (cache[i-1] + cache[i-2]) % 1234567;
        }
        
        return cache[num];
    }
}