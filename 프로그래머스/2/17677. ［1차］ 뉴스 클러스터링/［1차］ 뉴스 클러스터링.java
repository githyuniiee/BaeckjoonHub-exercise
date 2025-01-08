import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        // str1에서 2글자씩 잘라서 map1에 추가
        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i + 2);
            if ('a' <= str.charAt(0) && str.charAt(0) <= 'z' &&
                'a' <= str.charAt(1) && str.charAt(1) <= 'z') {
                map1.put(str, map1.getOrDefault(str, 0) + 1);
            }
        }
        
        // str2에서 2글자씩 잘라서 map2에 추가
        for (int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i + 2);
            if ('a' <= str.charAt(0) && str.charAt(0) <= 'z' &&
                'a' <= str.charAt(1) && str.charAt(1) <= 'z') {
                map2.put(str, map2.getOrDefault(str, 0) + 1);
            }
        }
        
        // 교집합과 합집합 크기 계산
        int intersectionCount = 0; // 교집합
        int unionCount = 0; // 합집합

        // map1의 모든 항목을 순회하며 계산
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersectionCount += Math.min(map1.get(key), map2.get(key)); // 교집합 크기
                unionCount += Math.max(map1.get(key), map2.get(key)); // 합집합 크기
            } else {
                unionCount += map1.get(key); // map2에 없는 항목은 합집합에만 포함
            }
        }

        // map2에만 존재하는 항목을 합집합에 추가
        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                unionCount += map2.get(key); // map1에 없는 항목은 합집합에만 포함
            }
        }
        
        // 자카드 유사도 계산
        if (intersectionCount == 0 && unionCount == 0) {
            return 65536; // 교집합과 합집합이 모두 없을 경우
        }
        
        double ans = (double) intersectionCount / unionCount;
        answer = (int) (ans * 65536); // 비율을 65536으로 곱하여 결과 반환
        
        return answer;
    }
}
