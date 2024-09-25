class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int ans1 = 0;
        int ans2 = 0;
        
        while(!s.equals("1")){
            
            int len_0 = 0;
            int len_1 = 0;
            
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0'){
                    ++len_0;
                }else{
                    ++len_1;
                }
            }
            
            s = Integer.toBinaryString(len_1);
            
            ans1 += 1;
            ans2 += len_0;
            
        }
        
        
        
        return new int[]{ans1, ans2};
    }
}