import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> list;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        list = new ArrayList<>();
        
        for(int i=0; i<tickets.length; i++){
            
            if(tickets[i][0].equals("ICN")){
                visited[i] = true;
                dfs(1, tickets[i][1], tickets, "ICN");
                visited[i] = false;
            }
        }
        
        Collections.sort(list);
        
        String[] answer = list.get(0).split(" ");
        return answer;
    }
    
    static void dfs(int depth, String next, String[][] tickets, String str){
        
        
        if(depth == tickets.length){
            str += " " + next;
            list.add(str);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(next) && !visited[i]){
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], tickets, str + " " + tickets[i][0]);
                visited[i] = false;
            }
        }
        
    }
}