import java.util.*;

class Solution {
    
    static int[] box;
    static boolean[] visited;
    
    public int solution(int[] cards) {
        int answer = 1;
        ArrayList<Integer> list = new ArrayList<>();
        
        box = new int[cards.length + 1];
        visited = new boolean[box.length];
        
        for(int i=0; i<cards.length; i++){
            box[i+1] = cards[i];
        }
        
        for(int i=1; i<box.length; i++){
            if(!visited[i]){
                int cnt = dfs(i, 0);
                list.add(cnt);
                
            }
        }
       
        Collections.sort(list, Collections.reverseOrder());
        
        
        if(list.size() >= 2){
            answer = list.get(0) * list.get(1);
        }else{
            answer = 0;
        }
        
        return answer;
    }
    
    static int dfs(int start, int c){
        
        
        if(!visited[start]){
            visited[start] = true;
            return dfs(box[start], c + 1);
        }
        
        return c;
    }
}