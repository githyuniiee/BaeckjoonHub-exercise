import java.util.*;

class Solution {
    public boolean solution(String s) {
       
        int len = s.length();
        //문자열 길이 확인
        if(4 == len || len == 6){
            
            //숫자로만 구성되어 있는지
            for(int i=0; i<s.length(); i++){
               if(!Character.isDigit(s.charAt(i))){
                   return false;
               }
            }
        }else{
            return false;
        }
        return true;
    }
}