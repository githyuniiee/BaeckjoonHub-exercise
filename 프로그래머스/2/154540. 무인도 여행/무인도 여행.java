import java.util.*;

class Solution {
    static char[][] arr;
    static boolean[][] visited;
    static int[] dy = new int[]{0,0,1,-1};
    static int[] dx = new int[]{-1,1,0,0};
    
    static int bfs(int y, int x){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x));
        visited[y][x] = true;
        int sum = arr[y][x] - '0';
        
        while(!q.isEmpty()){
            Node node = q.poll();
            
            for(int i=0; i<4; i++){
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                
                if(0<= ny && ny < arr.length && 0<= nx && nx < arr[0].length
                  && !visited[ny][nx] && arr[ny][nx] != 'X'){
                    visited[ny][nx] = true;
                    sum += arr[ny][nx] - '0';
                    q.add(new Node(ny,nx));
                }
            }
        }
        
        return sum;
    }
    
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        arr = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                arr[i][j] = maps[i].charAt(j);
            }
        }
        
      
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(!visited[i][j] && arr[i][j] != 'X'){
                   int days =  bfs(i,j);
                    if(days != 0){
                    list.add(days);
                    }
                }
            }
        }
        
        
        if(list.size() == 0){
            return new int[]{-1};
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    static class Node{
        int y;
        int x;
        
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}