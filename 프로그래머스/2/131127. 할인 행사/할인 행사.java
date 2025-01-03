import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int num = 0;

        // 원하는 상품과 수량을 map1에 저장
        for (int i = 0; i < want.length; i++) {
            map1.put(want[i], number[i]);
            num += number[i];
        }

        // 초기 윈도우 설정
        for (int i = 0; i < num; i++) {
            map2.put(discount[i], map2.getOrDefault(discount[i], 0) + 1);
        }

        // 슬라이딩 윈도우로 비교
        for (int i = num; i <= discount.length; i++) {
            // map1과 map2를 비교
            boolean isMatch = true;
            for (String key : map1.keySet()) {
                if (!map1.get(key).equals(map2.getOrDefault(key, 0))) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                answer++;
            }

            // 윈도우를 한 칸 오른쪽으로 이동
            if (i < discount.length) {
                String startItem = discount[i - num];
                String endItem = discount[i];

                map2.put(startItem, map2.get(startItem) - 1);
                if (map2.get(startItem) == 0) {
                    map2.remove(startItem);
                }

                map2.put(endItem, map2.getOrDefault(endItem, 0) + 1);
            }
        }

        return answer;
    }
}
