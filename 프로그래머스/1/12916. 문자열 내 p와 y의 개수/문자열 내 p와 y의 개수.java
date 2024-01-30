class Solution {
    boolean solution(String s) {
        
        s = s.toLowerCase();
        int count = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == 'p')
                count++;
            if(ch =='y')
                count--;
        }
        

        return count == 0;
    }
}