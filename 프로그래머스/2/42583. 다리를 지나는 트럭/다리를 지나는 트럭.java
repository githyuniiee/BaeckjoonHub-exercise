import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int sum = 0;
        
        for(int i=0; i<truck_weights.length; i++){
            
            int truck = truck_weights[i];
            
            while(true){
                //큐에 아무것도 x
                if(queue.isEmpty()){
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                }else if(queue.size() == bridge_length){
                    //다리 길이만큼 트럭이 다 참
                    sum -= queue.poll();
                }else {
                    if(sum + truck <= weight){
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}