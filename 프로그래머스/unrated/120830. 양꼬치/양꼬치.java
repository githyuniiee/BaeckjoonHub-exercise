class Solution {
    public int solution(int n, int k) {
        
        int b = n/10;
        k = k - b;
        
        int answer = ((n * 12000) + (k*2000));
        return answer;
    }
}