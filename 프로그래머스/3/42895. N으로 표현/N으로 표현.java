import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1; // N이 number와 같다면 1 반환
        
        // DP 테이블 초기화 (1~8개의 N 사용 경우 저장)
        List<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }

        // 1개 사용했을 때는 N 자체만 가능
        list.get(1).add(N);

        // DP 테이블 채우기
        for (int i = 2; i <= 8; i++) {
            HashSet<Integer> currentSet = list.get(i);
            
            // N을 i개 이어붙인 숫자 추가 (ex: 5, 55, 555, 5555)
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            currentSet.add(num);
            
            // j개 사용한 경우 + (i-j)개 사용한 경우 조합
            for (int j = 1; j < i; j++) {
                for (int num1 : list.get(j)) {
                    for (int num2 : list.get(i - j)) {
                        currentSet.add(num1 + num2);
                        currentSet.add(num1 - num2);
                        currentSet.add(num1 * num2);
                        if (num2 != 0) currentSet.add(num1 / num2);
                    }
                }
            }

            // 원하는 숫자가 있으면 정답 반환
            if (currentSet.contains(number)) {
                return i;
            }
        }

        return -1; // 8개 이하로 만들 수 없는 경우
    }
}
