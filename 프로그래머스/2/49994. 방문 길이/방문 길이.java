import java.util.*;

class Solution {
    static int[] dy = new int[]{1,0,-1,0}; //U,R,D,L
    static int[] dx = new int[]{0,1,0,-1};
    
    public int solution(String dirs) {
        int answer = 0;
        
        boolean[][][] visited = new boolean[11][11][4];
        
        int x = 5;
        int y = 5;
        int d = 0;
        
        for(char ch : dirs.toCharArray()){
            
            if(ch == 'U'){
                d = 0;
            }else if(ch == 'R'){
                d = 1;
            }else if(ch == 'D'){
                d = 2;
            }else{
                d = 3;
            }
            
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if(0 <= ny && ny < 11 && 0 <= nx && nx < 11){
                if(!visited[y][x][d]) {
                    visited[y][x][d] = true;
                    visited[ny][nx][(d + 2) % 4] = true;
                    answer++;
                }
                y = ny;
                x = nx;
            }
        }
        return answer;
    }
}