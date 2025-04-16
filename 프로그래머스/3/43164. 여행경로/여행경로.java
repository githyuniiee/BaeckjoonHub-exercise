import java.util.*;

class Solution {
    
    static boolean[] visited;
    static List<String> answers = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
       
        //tickets 정렬
        Arrays.sort(tickets, (o1,o2) -> {
           
           if(o1[0].equals(o2[0])){
               return o1[1].compareTo(o2[1]);
           }
            
            return o1[0].compareTo(o2[0]);
        });
        
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        
        return answers.get(0).split(" ");
    }
    
    static void dfs(String from, String path, String[][] tickets, int depth){
        
        
        if(depth == tickets.length){
            answers.add(path);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(from) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false; //백트래킹
            }
        }
    
    }
}