class Solution {
    public int solution(String[] board) {
        int Ocnt = 0;
        int Xcnt = 0;
        
        //O와 X의 개수 세기
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i].charAt(j) == 'O'){
                    Ocnt++;
                }else if(board[i].charAt(j) == 'X'){
                    Xcnt++;
                }
            }
        }
        
        
        if(Xcnt > Ocnt){
            return 0;
        }
        
        if(Ocnt > Xcnt + 1){
            return 0;
        }
        
        if(hasWin(board, 'O')){
            if(Ocnt == Xcnt){
                return 0;
            }
        }
        
        if(hasWin(board, 'X')){
            if(Ocnt == Xcnt + 1){
                return 0;
            }
        }
        
        return 1;
    }
    
    private static boolean hasWin(String[] board, char ch){
        //가로 검사
        for(int i=0; i<3; i++){
            if(board[i].charAt(0) == ch && board[i].charAt(1) ==ch
              && board[i].charAt(2) == ch){
                return true;
            }
        }
        
        //세로 검사
        for(int i=0; i<3; i++){
            if(board[0].charAt(i) == ch 
               && board[1].charAt(i) == ch
              && board[2].charAt(i) == ch){
                return true;
            }
        }
        
        //대각선 검사
        if(board[0].charAt(0) == ch 
           && board[1].charAt(1) == ch
          && board[2].charAt(2) == ch){
            return true;
        }
        
        if(board[0].charAt(2) == ch 
           && board[1].charAt(1) == ch
          && board[2].charAt(0) == ch){
            return true;
        }
        
        return false;
    }
    
    
}