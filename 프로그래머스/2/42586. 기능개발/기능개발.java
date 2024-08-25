import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        ArrayList<Integer> list = new ArrayList<>();

        // 각 작업이 완료되는 데 필요한 일수 계산
        for (int i = 0; i < progresses.length; i++) {
            int num = 100 - progresses[i];
            days[i] = (num + speeds[i] - 1) / speeds[i];  // 더 간결한 계산 방식
        }

        int currentDeployDay = days[0];  // 첫 번째 작업의 배포 기준일
        int count = 1;  // 첫 번째 배포 그룹의 크기

        for (int i = 1; i < days.length; i++) {
            if (days[i] <= currentDeployDay) {
                // 현재 작업이 배포 기준일보다 빠르게 완료되는 경우 같은 그룹에 포함
                count++;
            } else {
                // 새로운 배포 그룹 시작
                list.add(count);
                currentDeployDay = days[i];  // 배포 기준일 업데이트
                count = 1;  // 새로운 그룹의 크기 초기화
            }
        }

        // 마지막 그룹 추가
        list.add(count);

        // 결과 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
