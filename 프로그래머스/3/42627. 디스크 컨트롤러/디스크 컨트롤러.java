import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        //작업 시간 기준으로 오름차순 정렬
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        int answer = 0;
        
        int count = 0;
        int idx = 0;
        int time = 0;
        int totalWaitTime = 0;
        
        //모든 작업이 처리될 때까지 반복
        while(count < jobs.length){
            
            //현재 시간 이전에 요청된 작업 우선순위 큐에 추가
            while(idx < jobs.length && jobs[idx][0] <= time){
                q.offer(jobs[idx++]);
            }
            
            if(q.isEmpty()){
                time = jobs[idx][0];
            }else {
                //다음 작업
                int[] job = q.poll();
                
                time += job[1];
                
                totalWaitTime += time - job[0];
                
                count++;
            }
        }
        return totalWaitTime / jobs.length;
    }
}