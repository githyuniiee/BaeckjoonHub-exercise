class Solution {
    public int[] solution(int brown, int yellow) {
    
        int[] answer = new int[2];
        
        //노란색 격자 수 1 이상 -> 가로, 세로 3 이상
        for(int i=3; i< brown + yellow; i++) {
            int width = (brown + yellow) / i;
            //가로가 세로보다 길거나 같은 경우 
            if(width >= i){
                if((i-2) * (width -2) == yellow) {
                    answer[0] = width;
                    answer[1] = i;
                    break;
                }     
            }
        }
        return answer;
    }
}