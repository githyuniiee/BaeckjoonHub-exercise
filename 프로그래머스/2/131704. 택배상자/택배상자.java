import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int currentBox = 1; // 메인 컨테이너 벨트에서 나오는 상자의 번호
        int answer = 0; // 트럭에 실은 상자의 개수
        
        for (int i = 0; i < order.length; i++) {
            int targetBox = order[i]; // 트럭에 실어야 할 상자 번호
            
            // 메인 컨테이너 벨트에서 상자를 꺼내며 targetBox에 도달할 때까지 stack에 넣음
            while (currentBox <= targetBox) {
                stack.push(currentBox);
                currentBox++;
            }
            
            // 스택의 맨 위에 있는 상자가 우리가 실어야 할 상자와 같은지 확인
            if (!stack.isEmpty() && stack.peek() == targetBox) {
                stack.pop(); // 스택에서 상자를 꺼내 트럭에 실음
                answer++;
            } else {
                // 더 이상 상자를 실을 수 없으므로 종료
                break;
            }
        }
        
        return answer;
    }
}
