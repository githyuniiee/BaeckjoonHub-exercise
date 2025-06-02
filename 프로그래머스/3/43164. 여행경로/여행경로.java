import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> answers = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        dfs("ICN", "ICN", tickets, 0);

        String[] result = answers.get(0).split(" ");
        return result;
    }
    
    static void dfs(String curr, String path, String[][] tickets, int depth){
        if(depth == tickets.length){
            answers.add(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(curr)){
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}
