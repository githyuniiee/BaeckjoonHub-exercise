class Solution {
    boolean solution(String s) {
        
        
        int p_length = 0;
        int y_length = 0;
        
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == 'p' ||  s.charAt(i) == 'P')
                p_length++;
            if(s.charAt(i) =='y' || s.charAt(i) == 'Y')
                y_length++;
        }
        
        boolean answer = (p_length == y_length) ? true : false;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}