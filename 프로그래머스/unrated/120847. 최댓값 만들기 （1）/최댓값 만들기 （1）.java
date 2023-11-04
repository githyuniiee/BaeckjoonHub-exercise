import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        
        Arrays.sort(numbers);
        int len = numbers.length-1;
        
        int answer = numbers[len] * numbers[len-1];
        return answer;
    }
}