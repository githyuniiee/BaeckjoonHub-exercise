class Solution {
    public int[] solution(String s) {
       
        char[] arr = new char[s.length()];
        int[] answer = new int[s.length()];
        answer[0] = -1;
        
        for(int i=0; i< s.length(); i++){
            arr[i] = s.charAt(i);
        }
        
        for(int i=1; i<s.length(); i++){
            int num = 0;
            for(int j=0; j<i; j++){
                if(s.charAt(i) == arr[j]){
                    answer[i] = i-j;
                    num++;   
                }
            }
            if(num == 0){
                answer[i] = -1;
            }
        }
        return answer;
    }
}