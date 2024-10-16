class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {

        return dfs(numbers, target, 0, 0);
    }
    
    static int dfs(int[] numbers, int target, int now, int depth){
  
        if(depth == numbers.length){
            if(target == now){
                answer++;
            }
            return answer;
        }
        
      
        dfs(numbers, target, now + numbers[depth], depth + 1);
        dfs(numbers, target, now - numbers[depth], depth + 1);
        
        
        return answer;
        
        
        
    }
}