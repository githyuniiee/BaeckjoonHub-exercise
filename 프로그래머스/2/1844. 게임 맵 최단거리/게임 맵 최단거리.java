import java.util.*;

class Solution {
    
    static int n,m;
    static boolean[][] visited;
    static int[] dy = new int[]{-1,0,0,1};
    static int[] dx = new int[]{0,-1,1,0};
    
    static class Point{
        int y;
        int x;
        
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        bfs(maps);
        
        answer= maps[n-1][m-1] > 1 ? maps[n-1][m-1] : -1;
        return answer;
    }
    
    static void bfs(int[][] maps){
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for(int i=0; i<4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                
                if(0<=ny && ny < n && 0<=nx && nx < m && maps[ny][nx] == 1){
                    if(!visited[ny][nx]){
                        visited[ny][nx] = true;
                        maps[ny][nx] = maps[now.y][now.x] + 1;
                        q.add(new Point(ny,nx));
                    }
                }
            }
        }
        
    }
}