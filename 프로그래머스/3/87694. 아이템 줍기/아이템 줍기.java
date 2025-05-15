import java.util.*;

class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static int[]dy = new int[]{-1,0,0,1};
    static int[]dx = new int[]{0,-1,1,0};
    
    static class Point{
        int y;
        int x;
        int cnt;
        
        Point(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        arr = new int[101][101];
        visited = new boolean[101][101];
        
        for(int i=0; i<rectangle.length; i++){
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;
            
            for(int j=x1; j<=x2; j++){
                for(int k=y1; k<=y2; k++){
                    
                    if(j == x1 || j == x2 || k == y1 || k == y2){
                        if(arr[k][j] != -1){
                            arr[k][j] = 1; //테두리
                            continue;
                        }
                    }
                    
                    arr[k][j] = -1; //내부
                    
                }
            }      
        }
        
        int ans = bfs(characterX*2, characterY*2, itemX*2, itemY*2);
       
        return ans/2;
    }
    
    static int bfs(int sX, int sY, int eX, int eY){
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sY, sX, 1));
        visited[sY][sX] = true;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            if(now.y == eY && now.x == eX){
                return now.cnt;
            }
            
            for(int i=0; i<4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                
                if(0<=ny && ny <101 && 0<=nx && nx <101){
                    if(!visited[ny][nx] && arr[ny][nx] == 1){
                    q.add(new Point(ny,nx,now.cnt + 1));
                    visited[ny][nx] = true;
                    }    
                }
                
                
            }
        }
        
        return -1;
    }
}