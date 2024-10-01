import java.util.*;
class Solution {
    
    static char[][] miro;
    static int[][] visited;
    static int lever_y = -1;
    static int lever_x = -1;
    static int dx[] = new int[]{-1,0,0,1};
    static int dy[] = new int[]{0,1,-1,0};
    
    
    public int solution(String[] maps) {
        int answer = 0;
        miro = new char[maps.length][maps[0].length()];
        int start_y = -1;
        int start_x = -1;
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                miro[i][j] = maps[i].charAt(j);
                if(miro[i][j] == 'S'){
                    start_y = i;
                    start_x = j;
                }
            }
        }
        
        //시작 -> 레버
        int answer1 = bfs(start_y, start_x, 'L');
        
        if(answer1 == -1){
            return -1;
        }
        
        //레버 -> 도착
        int answer2 = bfs(lever_y, lever_x, 'E');
        
        if(answer2 == -1){
            return -1;
        }
    
        
        return answer1 + answer2;
    }
    
    static int bfs(int y, int x, char target){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x));
        visited = new int[miro.length][miro[0].length];
        
        while(!q.isEmpty()){
            Node nd = q.poll();
            int now_y = nd.y;
            int now_x = nd.x;
            
            if(miro[now_y][now_x] == target){
                if(target == 'L'){
                    lever_y = now_y;
                    lever_x = now_x;
                }
                return visited[now_y][now_x];
            }
            
            
            for(int i=0; i<4; i++){
                int next_y = now_y + dy[i];
                int next_x = now_x + dx[i];
                
                
                if(0<=next_y && next_y < miro.length && 0<=next_x && next_x < miro[0].length
                   && visited[next_y][next_x] == 0 && miro[next_y][next_x] != 'X'){
                    
                        
                    
                    q.add(new Node(next_y, next_x));
                    visited[next_y][next_x] = visited[now_y][now_x] + 1;
                    

                }
            }
        }
        return -1;
    }
}

class Node{
    int y;
    int x;
    
    
    public Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}