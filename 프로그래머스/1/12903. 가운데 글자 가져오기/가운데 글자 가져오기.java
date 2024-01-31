class Solution {
    public String solution(String s) {
        
        int len = s.length();
        char ch = 'a';
        String str = "";
        
        if(len % 2 == 0){
             for(int i=len/2-1; i<=len/2; i++){
                 ch = s.charAt(i);
                 str += String.valueOf(ch);
             }
             
        }else{
            ch = s.charAt(len/2);
            str = String.valueOf(ch);
        }
        return str;
    }
}