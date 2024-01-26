class Solution {
    public int solution(int a, int b) {
        
        int plus = Integer.parseInt("" +a+b);
        
        int answer = plus > (2*a*b) ? plus : (2*a*b);
        
        return answer;
    }
}