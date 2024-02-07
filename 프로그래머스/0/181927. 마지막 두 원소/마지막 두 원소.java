class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        
        int len = num_list.length -1;
        int last = 0;
        if(num_list[len] > num_list[len-1]){
            last = num_list[len] - num_list[len-1];
        }else{
            last = num_list[len] * 2;
        }
        
        for(int i=0; i<answer.length; i++){
            if(i == answer.length-1){
                answer[i] = last;
            }else{
                answer[i] = num_list[i];
            }
        }
        return answer;
    }
}