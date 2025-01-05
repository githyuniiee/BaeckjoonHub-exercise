class Solution {
    public int[] solution(int n, long left, long right) {
        int num = (int)(right - left);
        int[] answer = new int[num + 1];
        int s = 0;
        
        for(long i=left; i<=right; i++){
                long row = i / n;
                long col = i % n;
                answer[s] = Math.max((int)row, (int)col) + 1;
                s++;
        }
        
        return answer;
    }
}