
class Solution {
    public int solution(int[] money) {
        int len = money.length;
        int[] first = new int[len]; 
        int[] second = new int[len];
        
        for(int i=0; i<len; i++){
            first[i] = money[i];
            second[i] = money[i];
        }
        
        //방문해서는 안되는 집
        first[1] = -1; 
        second[0] = -1;
        first[2] +=first[0]; //집이 3개일 경우
        
        //집이 4개 이상일 경우
        for(int i=3; i<len; i++){
            first[i] += Math.max(first[i-2], first[i-3]);
            second[i] += Math.max(second[i-2], second[i-3]);
        }
        
        //마지막 집과, 마지막-1
        int firstMax = Math.max(first[len-2], first[len-3]);
        int secondMax = Math.max(second[len-1], second[len-2]);
        
        return Math.max(firstMax, secondMax);
        
        
    
    }
}