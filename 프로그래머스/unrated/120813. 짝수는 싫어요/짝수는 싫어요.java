class Solution {
    public int[] solution(int n) {

        int len = (n%2 == 0) ? n/2 : n/2 + 1; 
        
        int[] answer = new int[len];
        answer[0] = 1;
        int a  = 1;
        
        for(int i=2; i<=n; i++){
            if(i % 2 != 0){
                answer[a] = i;
                a++;
            }
        }
        return answer;
    }
}