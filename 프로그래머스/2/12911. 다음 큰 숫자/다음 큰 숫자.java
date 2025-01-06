class Solution {
    public int solution(int n) {
        
        int b1 = Integer.bitCount(n);
        
        while(true){
            n++;
            
            int b2 = Integer.bitCount(n);
            
            if(b1 == b2){
                break;
            }
        }
        
        return n;
    }
}