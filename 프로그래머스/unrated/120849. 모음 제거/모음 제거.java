import java.lang.*;

class Solution {
    public String solution(String my_string) {
    
        char arr[] = new char[]{'a', 'e', 'i', 'o', 'u'};
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<my_string.length(); i++){
            
            char ch = my_string.charAt(i);
            boolean bl = false;
            
            for(int j=0; j<arr.length; j++){
                
                if(ch == arr[j]){
                    bl = true;
                    break;
                
            }
            }
            
            if(!bl){
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}