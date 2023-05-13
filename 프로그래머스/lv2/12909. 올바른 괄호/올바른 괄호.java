class Solution {
    
    boolean solution(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }
            if (left < right) {
                return false;
            }
        }
        if (left == right) {
            return true;
        }
        return false;
    }
}