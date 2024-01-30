class Solution {
    public boolean solution(int x) {
        
        String str = "" + x;
        int sum = 0;
        boolean result = true;
        
        for(int i=0; i<str.length(); i++){
            sum += str.charAt(i) - '0';
        }
        
        if(x % sum != 0){
            result = false;
        }
        
        return result;
    }
}