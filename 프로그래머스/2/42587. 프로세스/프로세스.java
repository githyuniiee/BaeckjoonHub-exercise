import java.util.*;

class Solution {
    
    static class Node{
        int key;
        int value;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 인쇄 큐 초기화
        Queue<Node> queue = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            queue.add(new Node(i, priorities[i]));
        }
        
        // 우선순위 큐는 역순으로 정렬된 상태로 유지
        Arrays.sort(priorities);
        
        int index = priorities.length - 1;
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            // 현재 노드의 우선순위가 가장 높은 우선순위와 일치하는지 확인
            if(current.value == priorities[index]) {
                answer++;
                index--;
                
                // 만약 이 노드가 우리가 찾고 있는 위치에 있다면 종료
                if(current.key == location) {
                    break;
                }
            } else {
                // 우선순위가 더 높은 문서가 뒤에 있으므로 현재 문서를 다시 큐의 맨 뒤로 추가
                queue.add(current);
            }
        }
        
        return answer;
    }
}
