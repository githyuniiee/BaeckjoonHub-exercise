import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dy = new int[]{-1,0,0,1};
    static int[] dx = new int[]{0,-1,1,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        
        bfs(0,0, maps);
        
        if(maps[maps.length-1][maps[0].length-1] <=1){
            answer = -1;
        }else{
            answer = maps[maps.length-1][maps[0].length-1];
        }
        
        
        return answer;
    }
    
    public void bfs(int y, int x, int[][] maps){
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(y,x));
        visited[y][x] =true;
        
        while(!q.isEmpty()){
            Loc now = q.poll();
            
            for(int i=0; i<4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                
                if(0<=ny && ny < maps.length && 0<= nx && nx < maps[0].length
                  && !visited[ny][nx] && maps[ny][nx] == 1){
                    visited[ny][nx] = true;
                    q.add(new Loc(ny, nx));
                    maps[ny][nx] = maps[now.y][now.x] + 1;
                }
            }
            
        }
    }
    
    public class Loc{
        int y;
        int x;
        
        public Loc(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}