import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> targetMap = new HashMap<>();
        
        // 원하는 물품 목록을 map에 넣어줌
        for (int i = 0; i < want.length; i++) {
            targetMap.put(want[i], number[i]);
        }

        // 10일 동안의 할인 품목을 확인하기 위한 슬라이딩 윈도우
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> currentMap = new HashMap<>();

            // 현재 10일간의 할인 품목을 map에 넣어줌
            for (int j = i; j < i + 10; j++) {
                currentMap.put(discount[j], currentMap.getOrDefault(discount[j], 0) + 1);
            }

            // 원하는 물품 목록과 현재 10일간의 할인 품목을 비교
            boolean match = true;
            for (String item : targetMap.keySet()) {
                if (currentMap.get(item) != targetMap.get(item)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                answer++;
            }
        }

        return answer;
    }
}
