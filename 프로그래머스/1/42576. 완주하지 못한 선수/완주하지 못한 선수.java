import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        // 참가자 명단을 해시맵에 추가하며 카운트 증가
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // 완주자 명단에 따라 카운트 감소
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        // 값이 0이 아닌 사람(완주하지 못한 사람)을 찾기
        for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                return name;
            }
        }

        return ""; // 완주하지 못한 사람이 없는 경우 (문제 조건에서는 발생하지 않음)
    }
}
