class Solution {
    public int solution(int n, int m, int[] section) {
        int start = section[0];
        int end = section[0] + (m-1);
        int ans = 1;
        
        for(int i : section){
            if(i >= start && i <= end){
                continue; //start와 end 안에 들어가면 넘어감
            }else{
                start = i;
                end = i+ (m-1);
                ans++;
            }
        }
        return ans;
    }
}