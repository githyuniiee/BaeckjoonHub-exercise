import java.util.*;

class Solution {
    
    static int[] dx = new int[]{-1,0,0,1};
    static int[] dy = new int[]{0,-1,1,0};
    
    static void bfs(int[][] maps, int y, int x){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x));
    
        
        while(!q.isEmpty()){
            Node node = q.poll();
            
            for(int i=0; i<4; i++){
                int next_x = node.x + dx[i];
                int next_y = node.y + dy[i];
                
                if((0<= next_y && next_y <maps.length)
                  && (0<= next_x && next_x<maps[0].length)
                  && maps[next_y][next_x] == 1){
                    q.add(new Node(next_y, next_x));
                    maps[next_y][next_x] = maps[node.y][node.x] + 1;
                }
            }
        }
    }
    public int solution(int[][] maps) {
        
        
        bfs(maps,0,0);
        
        if(maps[maps.length - 1][maps[0].length -1] > 1 ){
            return maps[maps.length - 1][maps[0].length -1];
        }
        return -1;
    }
}

class Node {
    int x;
    int y;
    
    public Node(int y, int x){
        this.x = x;
        this.y = y;
    }
}