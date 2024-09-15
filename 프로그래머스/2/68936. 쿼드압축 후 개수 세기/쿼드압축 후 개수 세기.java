class Solution {
    int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        quadZip(arr, 0, 0, arr.length);
        return answer;
    }
    
    public void quadZip(int[][] arr, int x, int y, int length){
        
        if(zipChk(arr, x, y, length, arr[x][y])){
            if(arr[x][y] == 1) answer[1]++;
            else answer[0]++;
            return;
        }
        
        quadZip(arr, x, y, length/2);
        quadZip(arr, x+length/2, y, length/2);
        quadZip(arr, x, y+length/2, length/2);
        quadZip(arr, x+length/2, y+length/2, length/2);
        
    }
    
    public boolean zipChk(int[][] arr, int x, int y, int length, int arrVal){
        for(int i=x; i< x + length; i++){
            for(int j=y; j<y+length; j++){
                if(arr[i][j] != arrVal) return false;
            }
        }
        return true;
    }
}