class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i+1; j<=n; j++){
                sum += j;
                if(sum >= n){
                    if(sum == n){
                        answer++;
                    }
                    break;
                }
            }
            
        }
        return answer;
    }
}