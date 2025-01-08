class Solution {
    
    static int answer;
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public void dfs(int depth, int now, int[] numbers, int target){
        
        if(depth == numbers.length){
            
            if(now == target){
                answer++;
            }
             return;
        }
        
        
        dfs(depth + 1, now + numbers[depth], numbers, target);
        dfs(depth + 1, now - numbers[depth], numbers, target);
        
        
    }
}