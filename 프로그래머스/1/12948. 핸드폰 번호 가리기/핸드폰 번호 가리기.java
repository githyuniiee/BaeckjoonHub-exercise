class Solution {
    public String solution(String phone_number) {
        
        Character[] ch = new Character[phone_number.length()];
        
        for(int i=phone_number.length()-1; i>=0; i--){
            
            if( i<=phone_number.length()-1  && phone_number.length()-4<=i){
                ch[i] = phone_number.charAt(i);
            }else{
            
                ch[i] = '*';
            }
        }
        
        String str ="";
        for(char chr : ch){
            str += chr;
        }
        
        
        return str;
    }
}