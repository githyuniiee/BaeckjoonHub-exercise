class Solution {
    public int solution(int n) {
        int answer = 0;
        int c1 = Integer.bitCount(n);
        
        while(true){
            n++;
            int c2 = Integer.bitCount(n);
            
            if(c1 == c2){
                answer = n;
                break;
            }
        }
        
        
        return answer;
    }
}