import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<Node>[] list = new ArrayList[N+1];
        
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()){
            Node current = pq.poll();
            int now = current.index;
            int nowDist = current.distance;
            
            if(dist[now] < nowDist) continue;
            
            for(Node next : list[now]){
                int nextIndex = next.index;
                int nextDist = nowDist + next.distance;
                
                if(nextDist < dist[nextIndex]){
                    dist[nextIndex] = nextDist;
                    pq.add(new Node(nextIndex, nextDist));
                }
            }
        }
        
        for(int i=1; i<=N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }

        

        return answer;
    }
    
    static class Node {
        int index;
        int distance;
        
        Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
    }
}