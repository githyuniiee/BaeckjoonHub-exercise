class Solution {
    public double solution(int[] arr) {
        int len = arr.length;
        
        double answer = 0;
        for(int i=0; i<len; i++){
            answer += arr[i];
        }
        answer /= len;
        return answer;
    }
}