import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        //출발시점 기준 정렬
        Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
        
        //실행시간 기준 정렬
        Queue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        
        int count = 0; //처리된 작업의 수
        int idx = 0; //현재 처리할 작업의 인덱스
        int time = 0; //현재 시간
        int totalWaitTime = 0; //전체 작업의 대기 시간
        
        while(count < jobs.length){
            
            while(idx < jobs.length && jobs[idx][0] <= time){
                q.offer(jobs[idx]);
                idx++;
            }
            
            //큐가 비어있다면, 다음 작업의 요청 시간으로 이동
            if(q.isEmpty()){
                time = jobs[idx][0];
            }else {
                int[] job = q.poll();
                
                time += job[1];
                
                totalWaitTime += time -job[0];
                
                count++;
            }
            
        }
            
        return totalWaitTime / jobs.length;
    }
}