import java.util.*;
class Solution {
    
    static boolean[][] visited;
    static int dy[] = new int[]{0,1,-1,0};
    static int dx[] = new int[]{-1,0,0,1};
    static final char START = 'R', GOAL = 'G', DISABLE = 'D';
    
    static class Node{
        int y;
        int x;
        int depth;
        
        public Node(int y, int x, int depth){
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
    
    
    public int solution(String[] board) {
        int answer = 0;
        Node robot = null;
        Node goal = null;
        visited = new boolean[board.length][board[0].length()];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length(); j++){
                if(board[i].charAt(j) == START){
                    robot = new Node(i,j,0);
                }else if(board[i].charAt(j) == GOAL){
                    goal = new Node(i,j,0);
                }
            }
        }
        
        answer = bfs(board, robot, goal);
        
        return answer;
    }
    
    static int bfs(String[] board, Node robot, Node goal){
        Queue<Node> q = new LinkedList<>();
        q.add(robot);
        visited[robot.y][robot.x] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.y == goal.y && now.x == goal.x){
                return now.depth;
            }
            
            for(int i=0; i<4; i++){
                int next_y = now.y;
                int next_x = now.x;
                
                while(0<=next_y && next_y <board.length && 
                  0<=next_x && next_x <board[0].length() &&
                  board[next_y].charAt(next_x) != DISABLE){
                    next_y += dy[i];
                    next_x += dx[i];
                }
                
                next_y -= dy[i];
                next_x -= dx[i];
                
                if(visited[next_y][next_x] || (now.y == next_y && now.x == next_x)) continue;
                
                visited[next_y][next_x] = true;
                q.add(new Node(next_y,next_x, now.depth +1));
                
            }
        }
        return -1;
        
    }
}