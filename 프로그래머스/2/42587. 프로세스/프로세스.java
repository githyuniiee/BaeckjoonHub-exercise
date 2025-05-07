import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            q.add(i); // 인덱스만 저장 (문서 번호)
        }

        int answer = 0;

        while (!q.isEmpty()) {
            int current = q.poll(); // 문서 인덱스

            // 현재 문서보다 우선순위 높은 문서가 큐에 있는지 확인
            boolean hasHigher = false;
            for (int idx : q) {
                if (priorities[idx] > priorities[current]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                // 우선순위 높은 게 있으면 다시 뒤로
                q.add(current);
            } else {
                // 인쇄 처리
                answer++;
                if (current == location) {
                    return answer;
                }
            }
        }

        return -1; // 이론상 도달하지 않음
    }
}
