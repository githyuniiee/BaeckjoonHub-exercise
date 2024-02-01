class Solution {
    public int[] solution(int n, int m) {
       
        int[] answer = new int[2];
        
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        
        while(min != 0){
            int r = max % min;
            max = min;
            min = r;
        }
        
        
        return new int[] {max, n*m / max};
    }
}