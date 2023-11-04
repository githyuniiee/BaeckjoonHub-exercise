class Solution {
    public int[] solution(int money) {
        
        int a = money/5500;
        int b = money%5500;
        
        int[] answer = new int[2];
        answer[0] = a;
        answer[1] = b;
        
        return answer;
    }
}