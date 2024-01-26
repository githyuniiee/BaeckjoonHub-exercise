import java.util.*;
class Solution {
    public  int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; //수행되고난 직후의 시간
        int jobsIdx = 0; //jobs 배열의 인덱스
        int count = 0;
        
        
        //받은 배열 정렬
        Arrays.sort(jobs, (a,b)-> a[0] - b[0]);
        
        //처리 시간 오름차순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        while(count <jobs.length) {
            
            //하나의 작업이 완료되는 시점까지 들어온 모든 요청을 큐에 넣음
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end){
                pq.add(jobs[jobsIdx++]);
            }
            
            //큐가 비어있다면 작업 완료 이후에 다시 요청이 들어온다는 의미
            if(pq.isEmpty()){
                end = jobs[jobsIdx][0];
            }else{
                //가장 수행 시간이 짧은 요청부터 수행
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
            
        }
        
        
        return (int) Math.floor(answer/jobs.length);
    }
}