class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int ans1 = -1;
        int ans2 = -1;
        
        while(end < sequence.length){
        
            sum += sequence[end];
            
            while(sum > k && start <= end){
                sum -= sequence[start];
                start++;
            }
            
            if(sum == k){
                if(end - start < min){
                    min = end - start;
                    ans1 = start;
                    ans2 = end;
                }
            }
            end++;
        }
        
        return new int[]{ans1, ans2};
    }
}