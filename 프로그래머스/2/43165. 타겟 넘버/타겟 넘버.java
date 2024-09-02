class Solution {
   
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        bfs(numbers, 0, target, 0);
        
        return answer;
       
    }
    
    static void bfs(int[] numbers, int depth, int target, int sum){
        
        if(depth == numbers.length){
            if(sum == target){
                answer++;
            }
        }else{
            bfs(numbers, depth+1, target, sum + numbers[depth]);
            bfs(numbers, depth+1, target, sum - numbers[depth]);
        }
    }
}