import java.util.*;

class Solution {
    int zeroCnt = 0;
    int oneCnt = 0;
    
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return new int[]{zeroCnt, oneCnt};
    }
    
    void compress(int[][] arr, int y, int x, int size){
        if(isSame(arr, y,x,size)){
            if(arr[y][x] == 0) zeroCnt++;
            else oneCnt++;
            return;
        }
        
        int newSize = size / 2;
        compress(arr, y, x, newSize);                         // 1사분면
        compress(arr, y, x + newSize, newSize);               // 2사분면
        compress(arr, y + newSize, x, newSize);               // 3사분면
        compress(arr, y + newSize, x + newSize, newSize);
    }
    
    boolean isSame(int[][] arr, int y, int x, int size){
        int val = arr[y][x];
        
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(arr[i][j] != val) return false;
            }
        }
        
        return true;
    }
}