import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);  // 정렬 필요
        int n = citations.length;
        
        int left = 0;
        int right = n;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            
            // mid 이상 인용된 논문 수 계산
            for (int citation : citations) {
                if (citation >= mid) {
                    count++;
                }
            }
            
            if (count >= mid) {
                // 조건 만족 → 더 큰 h가 있는지 확인
                answer = mid;
                left = mid + 1;
            } else {
                // 조건 불만족 → 더 작은 h 시도
                right = mid - 1;
            }
        }
        
        return answer;
    }
}
